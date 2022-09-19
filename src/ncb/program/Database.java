package ncb.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Malik Heron
 */
public class Database {
    static final String JBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";

    static final String USER = "Malik";
    static final String PASS = "Bo$$2001";

    public static double createAdminDatabase() throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();

        Class.forName(JBC_DRIVER);

        String sql = "CREATE DATABASE IF NOT EXISTS ADMIN";

        if ((stmt.executeUpdate(sql)) != 0) {
            System.out.println("Admin Database already exists.");
        } else {
            System.out.println("Admin Database Created.");
        }

        stmt.close();
        conn.close();

        return 20;
    }

    public static double createUsersDatabase() throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();

        Class.forName(JBC_DRIVER);

        String sql = "CREATE DATABASE IF NOT EXISTS USERS";

        if ((stmt.executeUpdate(sql)) != 0) {
            System.out.println("Users Database already exists.");
        } else {
            System.out.println("Users Database Created.");
        }

        stmt.close();
        conn.close();

        return 20;
    }
}