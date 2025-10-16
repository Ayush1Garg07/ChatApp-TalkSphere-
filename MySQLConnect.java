import java.sql.*;

public class MySQLConnect {
    public static void main(String[] args) {
        // Replace "testdb" with your actual DB name if needed
        String url = "jdbc:mysql://localhost:3306/testdb"; 
        String user = "root";
        String password = "DarkModeOn@2025";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // You can now run queries...

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
