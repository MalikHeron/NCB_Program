package ncb.program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 * @author Malik Heron
 */
public class AccountSummary {
    // declare objects
    private final JPanel panel = new JPanel();
    private final JTextField fNameField = new JTextField();
    private final JTextField lNameField = new JTextField();
    private final JTextField account_numberField = new JTextField();
    private final JTextField usernameField = new JTextField();
    private final JTextField midasField = new JTextField();

    public AccountSummary() throws Exception {
        // set properties for panel
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setSize(600, 500);
        panel.setOpaque(false);

        // set font and size of labels
        JLabel fName = new JLabel("First name: ");
        fName.setFont(new Font("times new roman", Font.PLAIN, 20));
        JLabel lName = new JLabel("Last name: ");
        lName.setFont(new Font("times new roman", Font.PLAIN, 20));
        JLabel username = new JLabel("Username: ");
        username.setFont(new Font("times new roman", Font.PLAIN, 20));
        JLabel account_number = new JLabel("Account number: ");
        account_number.setFont(new Font("times new roman", Font.PLAIN, 20));
        JLabel midas = new JLabel("Midas: ");
        midas.setFont(new Font("times new roman", Font.PLAIN, 20));

        // set properties for labels
        fName.setBounds(20, 100, 200, 20);
        lName.setBounds(20, 160, 200, 20);
        username.setBounds(20, 220, 200, 20);
        account_number.setBounds(20, 280, 200, 20);
        midas.setBounds(20, 340, 200, 20);
        panel.add(fName);
        panel.add(lName);
        panel.add(account_number);
        panel.add(username);
        panel.add(midas);

        // set properties for fields
        fNameField.setBounds(200, 95, 150, 30);
        fNameField.setFont(new Font("times new roman", Font.PLAIN, 18));
        fNameField.setEditable(false);
        lNameField.setBounds(200, 155, 150, 30);
        lNameField.setFont(new Font("times new roman", Font.PLAIN, 18));
        lNameField.setEditable(false);
        usernameField.setBounds(200, 215, 150, 30);
        usernameField.setFont(new Font("times new roman", Font.PLAIN, 18));
        usernameField.setEditable(false);
        account_numberField.setBounds(200, 275, 150, 30);
        account_numberField.setFont(new Font("times new roman", Font.PLAIN, 18));
        account_numberField.setEditable(false);
        midasField.setBounds(200, 335, 150, 30);
        midasField.setFont(new Font("times new roman", Font.PLAIN, 18));
        midasField.setEditable(false);
        panel.add(fNameField);
        panel.add(lNameField);
        panel.add(account_numberField);
        panel.add(usernameField);
        panel.add(midasField);

        // set properties for continueButton
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(190, 400, 250, 50);
        panel.add(continueButton);

        // set properties for image
        JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\AccountSummary UI.jpg"));
        image.setSize(590, 500);
        panel.add(image);

        getData();

        continueButton.addActionListener((ActionEvent e) -> {
            Window win = SwingUtilities.getWindowAncestor(panel);
            win.dispose();

            MainScreen.userButton.setEnabled(true);
            MainScreen.adminButton.setEnabled(true);
            MainScreen.createButton.setEnabled(true);
            MainScreen.exitButton.setEnabled(true);
        });
    }

    public static void createAndShowUI() throws Exception {
        // set properties for dialog
        JDialog dialog = new JDialog(null, null, Dialog.DEFAULT_MODALITY_TYPE);
        dialog.setType(Window.Type.UTILITY);
        dialog.setSize(590, 500);
        dialog.add(new AccountSummary().getComponent());
        dialog.setLocationRelativeTo(MainScreen.jPanel2);
        dialog.setResizable(false);
        dialog.setUndecorated(true);
        dialog.setVisible(true);
        dialog.setLayout(null);
        dialog.setResizable(false);
    }

    // gets data from the database
    private void getData() throws Exception {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/users";
            String root = "root";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, root, password);

            Statement statement = conn.createStatement();
            String queryString = "SELECT first, last, username, account_number, midas FROM data";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                fNameField.setText(results.getString("first"));
                lNameField.setText(results.getString("last"));
                usernameField.setText(results.getString("username"));
                account_numberField.setText(results.getString("account_number"));
                midasField.setText(results.getString("midas"));
            }

            System.out.println("Retrieved Info from Users Database.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public JPanel getComponent() {
        return panel;
    }
}