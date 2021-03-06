package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    public static Connection getConnection() {

        Connection conn = null;

        String STR_DRIVER = "org.gjt.mm.mysql.Driver";
        String STR_CONEX = "jdbc:mysql://localhost:3306/dbfutebolmanager";
        String USER = "root";
        String PASSWORD = "root";

        try {
            Class.forName(STR_DRIVER);
            conn = DriverManager.getConnection(STR_CONEX, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
