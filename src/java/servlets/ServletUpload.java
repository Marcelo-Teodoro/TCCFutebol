package servlets;

import dao.ImageDao;
import dao.UserDao;
import entity.Imagem;
import entity.UserAdmin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Pgz
 */
public class ServletUpload extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ProcessRequest");        
         
        Integer id = null;
        UserDao userdao = new UserDao();
        UserAdmin user = new UserAdmin();        
        
        Imagem imagem = new Imagem();  
        
        
        
        boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
        if (isMultiPart) {

            FileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            String formulario = "";

            try {

                List items = upload.parseRequest(request);
                Iterator iter = items.iterator();

                while (iter.hasNext()) {

                    FileItem item = (FileItem) iter.next();
                    
                    if (item.getFieldName().equals("id")) {
                        id = (Integer.parseInt(item.getString()));
                    }

                    if (item.getFieldName().equals("acao")) {
                        formulario = item.getString();
                    }

                    if (!item.isFormField()) {

                        if (item.getName().length() > 0) {

                            imagem = this.inserirImagemDiretorio(item);

                        }

                    }

                }

            } catch (FileUploadException ex) {

                ex.printStackTrace();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }   
        if (id != null){
            user = userdao.getByID(id);
        }
        RequestDispatcher rd = request.getRequestDispatcher("MainPageServlet?acao=logon&txtLogin=" + user.getLogin() + "&txtPass="+user.getPassword());
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("DOGET");     
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("DOPOST");
        processRequest(request, response);
    }

    private Imagem inserirImagemDiretorio(FileItem item) throws IOException {

        //Pega o diretório /logo dentro do diretório atual de onde a
        //aplicação está rodando
        String caminho = getServletContext().getRealPath("/logo") + "/";
        // Cria o diretório caso ele não exista
        File diretorio = new File(caminho);

        if (!diretorio.exists()) {

            diretorio.mkdir();

        }

        // Mandar o arquivo para o diretório informado
        String nome = item.getName();

        String arq[] = nome.split("\\\\");

        for (int i = 0; i < arq.length; i++) {

            nome = arq[i];

        }

        File file = new File(diretorio, nome);

        FileOutputStream output = new FileOutputStream(file);

        InputStream is = item.getInputStream();

        byte[] buffer = new byte[2048];

        int nLidos;

        while ((nLidos = is.read(buffer)) >= 0) {

            output.write(buffer, 0, nLidos);

        }

        output.flush();

        output.close();

        //Guarda no banco de dados o endereço para recuperação da imagem
        /**
         * Estabeleça a conexão
         */
        Imagem imagem = new Imagem();
        imagem.setCaminho(caminho);
        imagem.setNome(nome);

        ImageDao image = new ImageDao();
        imagem.setIdImage(image.save(imagem));
        
        return imagem;
    }

}
