import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    private static final java.lang.String URL = "jdbc:mysql://localhost:3306/emp?allowPublicKeyRetrieval=true&useSSL=false";
    static String USER = "root";
    static String PASS = "root";
    static Connection con = null;
    static Boolean loginFlag = false;

    public static void main(String[] args) throws SQLException {
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GUI.login();
    }

}
