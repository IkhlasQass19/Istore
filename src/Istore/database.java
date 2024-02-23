package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

    // Placeholders to be replaced with your actual values (DO NOT hardcode)
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE_NAME = "istore";
    private static final String USERNAME = "root"; // Replace with your actual username
    private static final String PASSWORD = "1234"; // Replace with your actual password

    public static Connection connectDb() throws SQLException {
        try {
            // Load the MySQL driver dynamically (recommended)
            Class.forName("com.mysql.jdbc.Driver"); // Or use the driver class from your chosen library

            // Use a parameterized query to prevent SQL injection vulnerabilities
            String url = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DATABASE_NAME);
            Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD);

            // Set connection properties for security and performance (optional)
            // connection.setClientInfo("application_name", "studentmanagementsystem");
            // connection.setStatementTimeout(30); // Set timeout in seconds

            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error loading MySQL driver", e);
        }
    }

    // Consider adding methods for closing connections, handling transactions, etc.

}
