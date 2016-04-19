package servlets;

import dao.UserDao;
import entity.Team;
import entity.UserAdmin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pgz
 */
public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        System.out.println("AÇAO = " + acao);

        // Ação da primeira Tela
        if (acao.equals("cadastrarJogador")) {

            //UserDao login = new UserDao();

//            if (user.getIdUserAdmin()!= null){
//                user.seteMail("darkskullwow@gmail.com" );
//                Team time = new Team();
//                time.setTeamName("Porto F.C");
//                user.setTeam(time);
            //request.setAttribute("User", user);
            request.getRequestDispatcher("MemberPage.jsp").forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
