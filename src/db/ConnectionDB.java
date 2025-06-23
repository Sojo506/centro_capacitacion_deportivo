package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/centro_capacitacion_deportivo";
    private static final String USER = "root";
    private static final String PASS = System.getProperty("DB_PASSWORD");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
