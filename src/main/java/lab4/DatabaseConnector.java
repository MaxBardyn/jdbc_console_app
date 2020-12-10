package lab4;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bardyn_lab3?useUnicode=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection databaseConnection;

    public DatabaseConnector() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            if (databaseConnection == null || databaseConnection.isClosed()) {
                try {
                    databaseConnection = DriverManager.getConnection(
                            DATABASE_URL,
                            USERNAME,
                            PASSWORD
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseConnection;
    }
}
