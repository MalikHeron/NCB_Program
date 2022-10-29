package ncb.program;

import javax.swing.*;
import java.sql.*;
import java.util.Objects;

/**
 * @author Malik Heron
 */
public class DataSQL {

    public static boolean getUserAccount(String username, String password) throws Exception {
        boolean found = false;

        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            System.out.println("Connected to Users Database.");
            String queryString = "SELECT id, first, last, gender, parish, email, username, account_number, password, balance, time FROM data";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                int id = results.getInt("id");
                String fName = results.getString("first");
                String lName = results.getString("last");
                String gender = results.getString("gender");
                String parish = results.getString("parish");
                String email = results.getString("email");
                String user = results.getString("username");
                String num = results.getString("account_number");
                String pass = results.getString("password");
                float balance = results.getFloat("balance");
                String time = results.getString("time");

                if ((username.equals(user)) && (password.equals(pass))) {
                    found = true;

                    assert con != null;
                    PreparedStatement delete = con.prepareStatement("DELETE FROM log WHERE id > 0");
                    delete.executeUpdate();

                    PreparedStatement posted = con.prepareStatement("INSERT INTO log(id, first, last, gender, parish, email, username, password, account_number, balance, time) VALUES ('" + id + "', '" + fName + "', '" + lName + "', '" + gender + "', '" + parish + "', '" + email + "', '" + username + "', '" + password + "', '" + num + "', '" + balance + "', '" + time + "')");
                    posted.executeUpdate();

                    System.out.println("Copy Completed.");
                }
            }

            results.close();
            assert con != null;
            con.close();
        } catch (SQLException sql) {
            System.out.println(sql);
        }

        return found;
    }

    public static boolean getAdminAccount(String username, String password) throws Exception {
        boolean found = false;

        try {
            Connection con = getAdminConnection();
            Statement statement = Objects.requireNonNull(getAdminConnection()).createStatement();
            System.out.println("Connected to Admin Database");
            String queryString = "SELECT username, password FROM data";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                String user = results.getString("username");
                String pass = results.getString("password");

                if ((username.equals(user)) && (password.equals(pass))) {
                    found = true;
                }
            }

            results.close();
            assert con != null;
            con.close();
        } catch (SQLException sql) {
            System.out.println(sql);
        }

        return found;
    }

    public static boolean checkUsername(String username) throws Exception {
        boolean found = false;

        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT username FROM data";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                String user = results.getString("username");

                if ((username.equals(user))) {
                    found = true;
                }
            }

            results.close();
            assert con != null;
            con.close();
        } catch (SQLException sql) {
            System.out.println(sql);
        }

        return found;
    }

    public static boolean checkPassword(String password) throws Exception {
        boolean found = true;

        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT password FROM log";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                String pass = results.getString("password");

                if ((password.equals(pass))) {
                    found = false;
                }
            }

            results.close();
            assert con != null;
            con.close();
        } catch (SQLException sql) {
            System.out.println(sql);
        }

        return found;
    }

    public static boolean checkAcc(String fName, String lName, String accNum) throws Exception {
        boolean found = true;

        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT id, first, last, account_number, balance FROM data";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                int id = results.getInt("id");
                String fname = results.getString("first");
                String lname = results.getString("last");
                String accnum = results.getString("account_number");
                float balance = results.getFloat("balance");

                if ((fName.equals(fname) && (lName.equals(lname)) && (accNum.equals(accnum)))) {
                    assert con != null;
                    PreparedStatement delete = con.prepareStatement("DELETE FROM trans WHERE id > 0");
                    delete.executeUpdate();

                    PreparedStatement posted = con.prepareStatement("INSERT INTO trans(id, balance) VALUES ('" + id + "', '" + balance + "')");
                    posted.executeUpdate();

                    System.out.println("Information Copied.");

                    found = false;
                }
            }

            results.close();
            assert con != null;
            con.close();
        } catch (SQLException sql) {
            System.out.println(sql);
        }

        return found;
    }

    public static void deposit(Float amount) throws SQLException {
        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT id, balance FROM log";
            ResultSet results = statement.executeQuery(queryString);

            Float balance = null;

            while (results.next()) {
                int ID = results.getInt("id");
                balance = results.getFloat("balance");

                balance += amount;

                assert con != null;
                PreparedStatement posted = con.prepareStatement("UPDATE data SET balance = '" + balance + "' WHERE ID = '" + ID + "'");
                posted.executeUpdate();

                PreparedStatement posted2 = con.prepareStatement("UPDATE log SET balance = '" + balance + "' WHERE id = '" + ID + "'");
                posted2.executeUpdate();

                System.out.println("Deposit Completed.");
                JOptionPane.showMessageDialog(MainScreen.jPanel2, "Deposit Completed.", null, JOptionPane.INFORMATION_MESSAGE);
            }

            results.close();
            assert con != null;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void withdraw(Float amount) throws SQLException {
        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT id, balance FROM log";
            ResultSet results = statement.executeQuery(queryString);

            Float balance = null;

            while (results.next()) {
                int ID = results.getInt("id");
                balance = results.getFloat("balance");

                if (balance < amount) {
                    Messages.exceedsBalance();
                    System.out.println("Withdraw Failed.");
                    break;
                } else {
                    balance -= amount;

                    assert con != null;
                    PreparedStatement posted = con.prepareStatement("UPDATE data SET balance = '" + balance + "' WHERE ID = '" + ID + "'");
                    posted.executeUpdate();

                    PreparedStatement posted2 = con.prepareStatement("UPDATE log SET balance = '" + balance + "' WHERE id = '" + ID + "'");
                    posted2.executeUpdate();

                    System.out.println("Withdraw Completed.");
                    JOptionPane.showMessageDialog(MainScreen.jPanel2, "Withdraw Completed.", null, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            results.close();
            assert con != null;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void transferCash(Float amount) throws SQLException {
        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT id, balance FROM log";
            ResultSet results = statement.executeQuery(queryString);

            Float balance = null;

            while (results.next()) {
                int ID = results.getInt("id");
                balance = results.getFloat("balance");

                if (balance < amount) {
                    Messages.exceedsBalance();
                    System.out.println("Transfer Failed.");
                    break;
                } else {
                    balance -= amount;

                    assert con != null;
                    PreparedStatement posted = con.prepareStatement("UPDATE data SET balance = '" + balance + "' WHERE ID = '" + ID + "'");
                    posted.executeUpdate();

                    PreparedStatement posted2 = con.prepareStatement("UPDATE log SET balance = '" + balance + "' WHERE ID = '" + ID + "'");
                    posted2.executeUpdate();

                    System.out.println("Withdraw Completed.");

                    placeCash(amount);
                }
            }

            results.close();
            assert con != null;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void placeCash(Float amount) throws SQLException {
        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT id, balance FROM trans";
            ResultSet results = statement.executeQuery(queryString);

            Float balance = null;
            int ID = 0;

            while (results.next()) {
                ID = results.getInt("id");
                balance = results.getFloat("balance");
            }

            results.close();

            balance += amount;

            assert con != null;
            PreparedStatement posted = con.prepareStatement("UPDATE data SET balance = '" + balance + "' WHERE ID = '" + ID + "'");
            posted.executeUpdate();

            System.out.println("Transfer Completed.");

            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Transfer Completed.", null, JOptionPane.INFORMATION_MESSAGE);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void post(String fName, String lName, String age, String gender, Object parish,
                            String email, String username, String password, String accountnum, String midas, Float balance, String time) throws Exception {

        balance = (float) 0;

        try {
            Connection con = getUserConnection();
            assert con != null;
            PreparedStatement posted = con.prepareStatement("INSERT INTO data(first, last, age, gender, parish, email, username, password, account_number, midas, balance, time) VALUES ('" + fName + "', '" + lName + "', '" + age + "', '" + gender + "', '" + parish + "', '" + email + "', '" + username + "', '" + password + "', '" + accountnum + "', '" + midas + "', '" + balance + "', '" + time + "')");

            posted.executeUpdate();

            System.out.println("Information Stored.");

            posted.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addAccessTime(String accTime) throws Exception {
        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT id FROM log";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                int ID = results.getInt("id");

                assert con != null;
                PreparedStatement posted = con.prepareStatement("UPDATE data SET accessTime = '" + accTime + "' WHERE ID = '" + ID + "'");

                posted.executeUpdate();

                System.out.println("Access Time Stored.");

                posted.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void change(String username, String password) throws Exception {
        try {
            Connection con = getUserConnection();
            Statement statement = Objects.requireNonNull(getUserConnection()).createStatement();
            String queryString = "SELECT id FROM log";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                int ID = results.getInt("id");

                assert con != null;
                PreparedStatement posted = con.prepareStatement("UPDATE data SET username = '" + username + "' WHERE ID = '" + ID + "'");
                posted.executeUpdate();

                PreparedStatement updatePass = con.prepareStatement("UPDATE data SET password = '" + password + "' WHERE ID = '" + ID + "'");
                updatePass.executeUpdate();

                PreparedStatement posted2 = con.prepareStatement("UPDATE log SET username = '" + username + "' WHERE ID = '" + ID + "'");
                posted2.executeUpdate();

                PreparedStatement updatePass2 = con.prepareStatement("UPDATE log SET password = '" + password + "' WHERE ID = '" + ID + "'");
                updatePass2.executeUpdate();
            }

            System.out.println("Information Stored.");
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Account Information Updated.", null, JOptionPane.INFORMATION_MESSAGE);

            statement.close();
            assert con != null;
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static double createDataTable() {
        try {
            Connection con = getUserConnection();
            assert con != null;
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE data(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), age varchar(255), gender varchar(255), parish varchar(255), email varchar(255), username varchar(255), password varchar(255), account_number varchar(9), midas varchar(16), balance float, time varchar(255), accessTime varchar(255), PRIMARY KEY(id))";

            if ((stmt.executeUpdate(sql)) == 0) {
                System.out.println("DataTable Created.");
            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return 20;
    }

    public static double createLogTable() {
        try {
            Connection con = getUserConnection();
            assert con != null;
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE log(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), gender varchar(255), parish varchar(255), email varchar(255), username varchar(255), password varchar(255), account_number varchar(9), balance float, time varchar(255), accessTime varchar(255), PRIMARY KEY(id))";

            if ((stmt.executeUpdate(sql)) == 0) {
                System.out.println("LogTable Created.");
            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return 20;
    }

    public static double createTransTable() {
        try {
            Connection con = getUserConnection();
            assert con != null;
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE trans(id int NOT NULL AUTO_INCREMENT, balance float, PRIMARY KEY(id))";

            if ((stmt.executeUpdate(sql)) == 0) {
                System.out.println("TransTable Created.");
            }

            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return 20;
    }

    public static Connection getUserConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/users";
            String username = "root";
            String password = "";
            Class.forName(driver);

            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public static Connection getAdminConnection() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/admin";
            String username = "root";
            String password = "";
            Class.forName(driver);

            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return null;
    }
}