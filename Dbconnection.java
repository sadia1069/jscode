import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/travel_db", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}