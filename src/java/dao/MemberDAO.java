package dao;

import connection.ConnectionManager;
import entity.Member;
import entity.UserAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pgz
 */
public class MemberDAO {
    
    public int save(Member member) {

        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        Connection conn = ConnectionManager.getConnection();
        try {
            PreparedStatement stmt = null;
            String QUERY_INSERT = "insert into useradmin (name, dataNascimento, endereco, cpf, rg, email, nivelacesso) values (?, ?, ?, ?, ?, ?, ?)";
            String QUERY_UPDATE = "update user set name = ?, dataNascimento = ?, endereco = ? , cpf = ?, rg = ?, email = ?, nivelacesso = ? where iduseradmin = ? ";

            if (member.getIdMember()== null) {

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, member.getNomeMember());
//                stmt.setString(2, member.getLogin());
//                stmt.setString(3, member.getPassword());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                conn.close();
                stmt.close();

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, member.getNomeMember());
//                stmt.setString(2, member.getLogin());
//                stmt.setString(3, member.getPassword());
//                stmt.setInt(4, member.getIdUserAdmin());
//
//                stmt.executeUpdate();
//                resultado = member.getIdUserAdmin(); // alterei aqui pra ficar igual ao do ProfessorDAO
//                conn.close();
//                stmt.close();
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
        }       
        return resultado;
    }

    public boolean delete(UserAdmin user) {

        boolean resultado = false;
        Connection conn = ConnectionManager.getConnection();

        try {
            PreparedStatement stmt = null;

            String QUERY_DELETE = "delete from user where iduseradmin = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, user.getIdUserAdmin());

            stmt.executeUpdate();
            conn.close();
            stmt.close();

            resultado = true;

        } catch (SQLException ex) {

            ex.printStackTrace();
            resultado = false;
        }
        return resultado;
    }
    
    public UserAdmin byLoginPass (String login, String pass){
        Integer idUser = null;
        UserAdmin user = new UserAdmin();
        
        Connection conn = ConnectionManager.getConnection();
        
        try{
            
            String Query_Pesquisa = "select * from useradmin where login = ? "
                    + "and pass = ?"; 
            PreparedStatement stmt = null;
            
            ResultSet rs = null;
            
            stmt = conn.prepareStatement(Query_Pesquisa);
            stmt.setString(1, login);
            stmt.setString(2, pass);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                user.setIdUserAdmin(rs.getInt("iduseradmin"));
                user.setNome(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("pass"));
            }
            
            conn.close();
            stmt.close();
            
        }catch (Exception ex) { 

            ex.printStackTrace();
            user = null;

        }
        
        return user;
        
    }
    
    public UserAdmin getByID (Integer id){
        Integer idUser = null;
        UserAdmin user = new UserAdmin();
        
        Connection conn = ConnectionManager.getConnection();
        
        try{
            
            String Query_Pesquisa = "select * from useradmin where iduseradmin = ?"; 
            PreparedStatement stmt = null;
            
            ResultSet rs = null;
            
            stmt = conn.prepareStatement(Query_Pesquisa);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                user.setIdUserAdmin(rs.getInt("iduseradmin"));
                user.setNome(rs.getString("name"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("pass"));
            }
            
            conn.close();
            stmt.close();
            
        }catch (Exception ex) { 

            ex.printStackTrace();
            user = null;

        }
        
        return user;
        
    }
    
}