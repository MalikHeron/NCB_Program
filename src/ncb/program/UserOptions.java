package ncb.program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Malik Heron
 */
public class UserOptions {
    // Create and set up the windows
    private final JPanel panel = new JPanel();

    // declare buttons
    private final JButton dSubmit = new JButton("Submit");
    private final JButton wSubmit = new JButton("Submit");

    // declare textFields
    private final JTextField balField = new JTextField();
    private final JTextField balField2 = new JTextField();
    private final JTextField fNameField = new JTextField();
    private final JTextField lNameField = new JTextField();
    private final JTextField genderField = new JTextField();
    private final JTextField parishField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JTextField usernameField = new JTextField();
    private final JTextField timeField = new JTextField();
    private final JTextField account_numberField = new JTextField();
    private final JTextField amountField = new JTextField();
    private final JTextField amountField2 = new JTextField();

    public UserOptions() {
        // Display the window
        panel.setSize(600, 500);
        panel.setOpaque(false);
        panel.setVisible(true);
        panel.setLayout(new GridLayout(1, 1));

        // set panel properties
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));
        panel1.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        panel2.setLayout(null);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 1));
        panel3.setLayout(null);

        // set properties for amount texts
        JLabel amountText = new JLabel("Amount: $");
        amountText.setFont(new Font("times new roman", Font.PLAIN, 16));
        amountText.setBounds(10, 90, 100, 30);
        panel1.add(amountText);

        JLabel amountText2 = new JLabel("Amount: $");
        amountText2.setBounds(10, 90, 100, 30);
        amountText2.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel2.add(amountText2);

        // set properties for amount fields
        amountField.setBounds(75, 90, 150, 30);
        amountField.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel1.add(amountField);

        amountField2.setBounds(75, 90, 150, 30);
        amountField2.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel2.add(amountField2);

        // set properties for submit buttons
        dSubmit.setBounds(95, 130, 100, 30);
        dSubmit.setFocusPainted(false);
        dSubmit.setEnabled(false);
        dSubmit.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel1.add(dSubmit);

        wSubmit.setBounds(95, 130, 100, 30);
        wSubmit.setFocusPainted(false);
        wSubmit.setEnabled(false);
        wSubmit.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel2.add(wSubmit);

        // set properties for balance texts
        JLabel balText = new JLabel("Balance: $");
        balText.setBounds(350, 20, 100, 30);
        balText.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel1.add(balText);

        JLabel balText2 = new JLabel("Balance: $");
        balText2.setBounds(350, 20, 100, 30);
        balText2.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel2.add(balText2);

        // set properties for balance fields
        balField.setBounds(425, 20, 150, 30);
        balField.setEditable(false);
        balField.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel1.add(balField);

        balField2.setBounds(425, 20, 150, 30);
        balField2.setEditable(false);
        balField2.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel2.add(balField2);

        // properties for labels
        // declare labels
        JLabel fNameText = new JLabel("First name: ");
        fNameText.setBounds(20, 50, 120, 30);
        fNameText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel lNameText = new JLabel("Last name: ");
        lNameText.setBounds(20, 110, 120, 30);
        lNameText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel genderText = new JLabel("Gender: ");
        genderText.setBounds(20, 170, 120, 30);
        genderText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel parishText = new JLabel("Parish: ");
        parishText.setBounds(20, 230, 120, 30);
        parishText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel emailText = new JLabel("Email: ");
        emailText.setBounds(20, 290, 120, 30);
        emailText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel usernameText = new JLabel("Username: ");
        usernameText.setBounds(20, 350, 120, 30);
        usernameText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel account_numberText = new JLabel("Account number: ");
        account_numberText.setBounds(20, 410, 150, 30);
        account_numberText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel timeText = new JLabel("Time created: ");
        timeText.setBounds(340, 10, 120, 30);
        timeText.setFont(new Font("times new roman", Font.PLAIN, 18));
        panel3.add(fNameText);
        panel3.add(lNameText);
        panel3.add(genderText);
        panel3.add(parishText);
        panel3.add(emailText);
        panel3.add(usernameText);
        panel3.add(account_numberText);
        panel3.add(timeText);

        // properties for fields
        fNameField.setBounds(135, 50, 120, 30);
        fNameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        fNameField.setEditable(false);
        lNameField.setBounds(135, 110, 120, 30);
        lNameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        lNameField.setEditable(false);
        genderField.setBounds(135, 170, 120, 30);
        genderField.setFont(new Font("times new roman", Font.PLAIN, 16));
        genderField.setEditable(false);
        parishField.setBounds(135, 230, 120, 30);
        parishField.setFont(new Font("times new roman", Font.PLAIN, 16));
        parishField.setEditable(false);
        emailField.setBounds(135, 290, 220, 30);
        emailField.setFont(new Font("times new roman", Font.PLAIN, 16));
        emailField.setEditable(false);
        usernameField.setBounds(135, 350, 120, 30);
        usernameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        usernameField.setEditable(false);
        account_numberField.setBounds(150, 410, 120, 30);
        account_numberField.setFont(new Font("times new roman", Font.PLAIN, 16));
        account_numberField.setEditable(false);
        timeField.setBounds(440, 10, 150, 30);
        timeField.setFont(new Font("times new roman", Font.PLAIN, 16));
        timeField.setEditable(false);
        panel3.add(fNameField);
        panel3.add(lNameField);
        panel3.add(genderField);
        panel3.add(parishField);
        panel3.add(emailField);
        panel3.add(usernameField);
        panel3.add(account_numberField);
        panel3.add(timeField);

        // set properties for images
        // declare image objects
        String path = "D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\Plain UI.jpg";
        JLabel image = new JLabel(new ImageIcon(path));
        image.setSize(600, 500);
        panel.add(image);

        JLabel image1 = new JLabel(new ImageIcon(path));
        image1.setSize(600, 500);
        panel1.add(image1);

        JLabel image2 = new JLabel(new ImageIcon(path));
        image2.setSize(600, 500);
        panel2.add(image2);

        JLabel image3 = new JLabel(new ImageIcon(path));
        image3.setSize(600, 500);
        panel3.add(image);

        // set properties for tabs
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFocusable(false);
        tabbedPane.setFont(new Font("times new roman", Font.PLAIN, 16));
        tabbedPane.addTab("Deposit", panel1);
        tabbedPane.addTab("Withdraw", panel2);
        tabbedPane.addTab("Account Details", panel3);

        // set contents for window
        panel.add(tabbedPane);

        getData();

        // Check field focus
        amountField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(amountField.getText());

                if (field.trim().equals("")) {
                    amountField.setText("0");
                    amountField.setForeground(Color.GRAY);
                }
            }
        });

        amountField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String field = String.valueOf(amountField.getText());

                if (field.trim().equals("0")) {
                    amountField.setText("");
                    amountField.setForeground(Color.BLACK);
                }
            }
        });

        amountField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(amountField2.getText());

                if (field.trim().equals("")) {
                    amountField2.setText("0");
                    amountField2.setForeground(Color.GRAY);
                }
            }
        });

        amountField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String field = String.valueOf(amountField2.getText());

                if (field.trim().equals("0")) {
                    amountField2.setText("");
                    amountField2.setForeground(Color.BLACK);
                }
            }
        });

        // ensures that only numbers are entered
        amountField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                String field = String.valueOf(amountField.getText());

                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                } else if (!field.trim().equals("0")) {
                    dSubmit.setEnabled(true);
                } else {
                    dSubmit.setEnabled(false);
                }
            }
        });

        amountField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                String field = String.valueOf(amountField2.getText());

                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                } else if (!field.trim().equals("0")) {
                    wSubmit.setEnabled(true);
                } else {
                    wSubmit.setEnabled(false);
                }
            }
        });

        dSubmit.addActionListener((ActionEvent e) -> {
            try {
                float amount = Float.parseFloat(amountField.getText());

                if (amount <= 30000) {
                    DataSQL.deposit(amount);
                    clearFields();
                    getData();
                } else {
                    Messages.depositError(MainScreen.jPanel2);
                    System.out.println("Deposit Failed.");
                    clearFields();
                }
            } catch (NumberFormatException | SQLException ex) {
                System.out.println(ex);
            }
        });

        wSubmit.addActionListener((ActionEvent e) -> {
            try {
                float amount = Float.parseFloat(amountField2.getText());

                if (amount <= 30000) {
                    DataSQL.withdraw(amount);
                    clearFields();
                    getData();
                } else {
                    Messages.withdrawError(MainScreen.jPanel2);
                    System.out.println("Withdraw Failed.");
                    clearFields();
                }
            } catch (NumberFormatException | SQLException ex) {
                System.out.println(ex);
            }
        });
    }

    private void getData() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/users";
            String username = "root";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to LogTable.");

            Statement statement = conn.createStatement();
            String queryString = "SELECT first, last, gender, parish, email, username, account_number, balance, time FROM log";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                fNameField.setText(results.getString("first"));
                lNameField.setText(results.getString("last"));
                genderField.setText(results.getString("gender"));
                parishField.setText(results.getString("parish"));
                emailField.setText(results.getString("email"));
                usernameField.setText(results.getString("username"));
                account_numberField.setText(results.getString("account_number"));
                timeField.setText(results.getString("time"));

                DecimalFormat f = new DecimalFormat("##.00");
                Float bal = Float.parseFloat(results.getString("balance"));
                balField.setText(f.format(bal));
                balField2.setText(f.format(bal));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    private void clearFields() {
        amountField.setText("");
        dSubmit.setEnabled(false);
        amountField2.setText("");
        wSubmit.setEnabled(false);
    }

    public JPanel getComponent() {
        return panel;
    }
}

class CurrencyConverter {
    // set up window
    private final JPanel panel = new JPanel();

    // declare text fields
    private final JTextField jmdField = new JTextField();
    private final JTextField usdField = new JTextField();
    private final JTextField canField = new JTextField();
    private final JTextField gbpField = new JTextField();
    private final JTextField ttField = new JTextField();

    // declare buttons
    private final JButton convertButton = new JButton("Convert");

    public CurrencyConverter() {
        panel.setSize(600, 500);
        panel.setOpaque(false);
        panel.setVisible(true);
        panel.setLayout(null);

        // set properties for from text
        JLabel jmdText = new JLabel("Jamaican Dollars: $ ");
        jmdText.setBounds(10, 60, 170, 30);
        jmdText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel usdText = new JLabel("United States Dollars: ");
        usdText.setBounds(10, 120, 170, 30);
        usdText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel canText = new JLabel("Canadian Dollars: ");
        canText.setBounds(10, 180, 170, 30);
        canText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel gbpText = new JLabel("Great Britain Pounds: ");
        gbpText.setBounds(10, 240, 170, 30);
        gbpText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel ttText = new JLabel("Trinidad & Tobago Dollars: ");
        ttText.setBounds(10, 300, 210, 30);
        ttText.setFont(new Font("times new roman", Font.PLAIN, 18));
        panel.add(jmdText);
        panel.add(usdText);
        panel.add(canText);
        panel.add(gbpText);
        panel.add(ttText);

        // set properties for fields
        jmdField.setBounds(225, 60, 150, 30);
        jmdField.setFont(new Font("times new roman", Font.PLAIN, 16));
        usdField.setBounds(225, 120, 150, 30);
        usdField.setFont(new Font("times new roman", Font.PLAIN, 16));
        usdField.setEditable(false);
        canField.setBounds(225, 180, 150, 30);
        canField.setFont(new Font("times new roman", Font.PLAIN, 16));
        canField.setEditable(false);
        gbpField.setBounds(225, 240, 150, 30);
        gbpField.setFont(new Font("times new roman", Font.PLAIN, 16));
        gbpField.setEditable(false);
        ttField.setBounds(225, 300, 150, 30);
        ttField.setFont(new Font("times new roman", Font.PLAIN, 16));
        ttField.setEditable(false);
        panel.add(jmdField);
        panel.add(usdField);
        panel.add(canField);
        panel.add(gbpField);
        panel.add(ttField);

        // set properties for convert button
        convertButton.setBounds(420, 60, 100, 30);
        convertButton.setFocusPainted(false);
        convertButton.setEnabled(false);
        convertButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(convertButton);

        // set properties for image
        // declare labels
        JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\Plain UI.jpg"));
        image.setSize(600, 500);
        panel.add(image);

        jmdField.setText("0");
        jmdField.setForeground(Color.GRAY);

        // Check field focus
        jmdField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(jmdField.getText());

                if (field.trim().equals("")) {
                    jmdField.setText("0");
                    jmdField.setForeground(Color.GRAY);
                }
            }
        });

        jmdField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String field = String.valueOf(jmdField.getText());

                if (field.trim().equals("0")) {
                    jmdField.setText("");
                    jmdField.setForeground(Color.BLACK);
                }
            }
        });

        jmdField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                String field = String.valueOf(jmdField.getText());

                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                } else convertButton.setEnabled(!field.trim().equals("0"));
            }
        });

        convertButton.addActionListener((ActionEvent e) -> {
            Float amount = Float.parseFloat(jmdField.getText());
            convertCurrency(amount);
            clearFields();
        });
    }

    private void convertCurrency(Float amount) {
        DecimalFormat f = new DecimalFormat("##.00");

        double USD = 137.95;
        double usdConvert = (amount / USD);
        usdField.setText("$ " + f.format(usdConvert));

        double CAN = 105.59;
        double canConvert = (amount / CAN);
        canField.setText("$ " + f.format(canConvert));

        double TT = 20.36;
        double ttConvert = (amount / TT);
        ttField.setText("$ " + f.format(ttConvert));

        double GBP = 176.86;
        double gbpConvert = (amount / GBP);
        gbpField.setText("$ " + f.format(gbpConvert));
    }

    private void clearFields() {
        jmdField.setText("0");
        convertButton.setEnabled(false);
    }

    public JPanel getComponent() {
        return panel;
    }
}

class ChangeInfo {
    // declare objects
    private final Storage var = new Storage();

    // set up window
    private final JPanel panel = new JPanel();

    // declare text fields
    private final JTextField usernameField = new JTextField();
    private final JPasswordField currentPassField = new JPasswordField();
    private final JPasswordField newPassField = new JPasswordField();
    private final JPasswordField confirmPassField = new JPasswordField();

    // declare buttons
    private final JButton confirmButton = new JButton("Confirm");

    public ChangeInfo() {
        // Display the window
        panel.setSize(600, 500);
        panel.setOpaque(false);
        panel.setVisible(true);
        panel.setLayout(null);

        // set properties for labels
        JLabel usernameText = new JLabel("New Username: ");
        usernameText.setBounds(10, 120, 140, 30);
        usernameText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel currentPassText = new JLabel("Current Password: ");
        currentPassText.setBounds(10, 180, 140, 30);
        currentPassText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel newPassText = new JLabel("New Password: ");
        newPassText.setBounds(10, 240, 140, 30);
        newPassText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel confirmPassText = new JLabel("Confirm Password: ");
        confirmPassText.setBounds(10, 300, 180, 30);
        confirmPassText.setFont(new Font("times new roman", Font.PLAIN, 18));
        panel.add(usernameText);
        panel.add(currentPassText);
        panel.add(newPassText);
        panel.add(confirmPassText);

        // set properties for labels
        usernameField.setBounds(180, 120, 350, 30);
        usernameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        currentPassField.setBounds(180, 180, 350, 30);
        currentPassField.setFont(new Font("times new roman", Font.PLAIN, 16));
        newPassField.setBounds(180, 240, 350, 30);
        newPassField.setFont(new Font("times new roman", Font.PLAIN, 16));
        confirmPassField.setBounds(180, 300, 350, 30);
        confirmPassField.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(usernameField);
        panel.add(currentPassField);
        panel.add(newPassField);
        panel.add(confirmPassField);

        // set properties for buttons
        confirmButton.setBounds(230, 380, 200, 50);
        confirmButton.setFocusPainted(false);
        confirmButton.setEnabled(false);
        confirmButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(confirmButton);

        // set properties for image
        // declare labels
        JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\Plain UI.jpg"));
        image.setSize(600, 500);
        panel.add(image);

        // What happens to the fields
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String field = String.valueOf(usernameField.getText());
                String field2 = String.valueOf(currentPassField.getPassword());
                String field3 = String.valueOf(newPassField.getPassword());
                String field4 = String.valueOf(confirmPassField.getPassword());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("")) {
                    confirmButton.setEnabled(false);
                } else {
                    confirmButton.setEnabled(true);
                }
            }
        });

        currentPassField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String field = String.valueOf(usernameField.getText());
                String field2 = String.valueOf(currentPassField.getPassword());
                String field3 = String.valueOf(newPassField.getPassword());
                String field4 = String.valueOf(confirmPassField.getPassword());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("")) {
                    confirmButton.setEnabled(false);
                } else {
                    confirmButton.setEnabled(true);
                }
            }
        });

        newPassField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String field = String.valueOf(usernameField.getText());
                String field2 = String.valueOf(currentPassField.getPassword());
                String field3 = String.valueOf(newPassField.getPassword());
                String field4 = String.valueOf(confirmPassField.getPassword());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("")) {
                    confirmButton.setEnabled(false);
                } else {
                    confirmButton.setEnabled(true);
                }
            }
        });

        confirmPassField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String field = String.valueOf(usernameField.getText());
                String field2 = String.valueOf(currentPassField.getPassword());
                String field3 = String.valueOf(newPassField.getPassword());
                String field4 = String.valueOf(confirmPassField.getPassword());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("")) {
                    confirmButton.setEnabled(false);
                } else {
                    confirmButton.setEnabled(true);
                }
            }
        });

        // what happens when the button is pressed
        confirmButton.addActionListener((ActionEvent e) -> {
            boolean check = false;
            try {
                check = verifyFields();

                if (check) {
                    MD5hasher(var.pass);
                    postToDatabase();
                    fieldReset();
                }
            } catch (Exception ex) {
                Logger.getLogger(ChangeInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private boolean verifyFields() throws Exception {
        // declare variables
        var.username = usernameField.getText();
        var.password = String.valueOf(currentPassField.getPassword());
        var.newPass = String.valueOf(newPassField.getPassword());
        var.pass = String.valueOf(confirmPassField.getPassword());

        MD5hasher(var.password);

        if (DataSQL.checkUsername(var.username)) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Username already exists", "Warning", 2);
            return false;
        }

        if (var.newPass.length() < 8) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Password requires 8 or more characters", "Warning", 2);
            return false;
        }

        if (DataSQL.checkPassword(var.password)) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Incorrect Password", "Warning", 2);
            return false;
        }

        if (!var.newPass.equals(var.pass)) { /* check if the two password match */
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Password Doesn't Match", "Warning", 2);
            return false;
        } else {
            return true;
        }
    }

    private void postToDatabase() throws Exception {
        MD5hasher(var.pass);

        DataSQL.change(var.username, var.password);
    }

    private void MD5hasher(String password) {
        String generatedPassword = null;

        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            //Add password bytes to digest
            md.update(password.getBytes());

            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format

            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            //Get complete hashed password in hex format
            generatedPassword = sb.toString();

            System.out.println("Password Hash Completed.");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }

        var.password = generatedPassword;
    }

    private void fieldReset() {
        usernameField.setText("");
        currentPassField.setText("");
        newPassField.setText("");
        confirmPassField.setText("");
    }

    public JPanel getComponent() {
        return panel;
    }
}

class TransferCash {
    // declare objects
    private final Storage var = new Storage();

    // set up window
    private final JPanel panel = new JPanel();

    // declare text fields
    private final JTextField fNameField = new JTextField();
    private final JTextField lNameField = new JTextField();
    private final JTextField accNumField = new JTextField();
    private final JTextField amountField = new JTextField();
    private final JTextField balField = new JTextField();

    // declare buttons
    private final JButton submitButton = new JButton("Submit");

    public TransferCash() {
        // Display the window
        panel.setSize(600, 500);
        panel.setOpaque(false);
        panel.setVisible(true);
        panel.setLayout(null);

        // set properties for labels
        JLabel balText = new JLabel("Balance: $");
        balText.setBounds(350, 20, 100, 30);
        balText.setFont(new Font("times new roman", Font.PLAIN, 16));
        JLabel fNameText = new JLabel("First Name: ");
        fNameText.setBounds(10, 120, 140, 30);
        fNameText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel lNameText = new JLabel("Last Name: ");
        lNameText.setBounds(10, 180, 140, 30);
        lNameText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel accNumText = new JLabel("Account Number: ");
        accNumText.setBounds(10, 240, 140, 30);
        accNumText.setFont(new Font("times new roman", Font.PLAIN, 18));
        JLabel amountText = new JLabel("Amount: ");
        amountText.setBounds(10, 300, 180, 30);
        amountText.setFont(new Font("times new roman", Font.PLAIN, 18));
        panel.add(balText);
        panel.add(fNameText);
        panel.add(lNameText);
        panel.add(accNumText);
        panel.add(amountText);

        // set properties for labels
        balField.setBounds(425, 20, 150, 30);
        balField.setFont(new Font("times new roman", Font.PLAIN, 16));
        balField.setEditable(false);
        fNameField.setBounds(180, 120, 350, 30);
        fNameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        lNameField.setBounds(180, 180, 350, 30);
        lNameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        accNumField.setBounds(180, 240, 350, 30);
        accNumField.setFont(new Font("times new roman", Font.PLAIN, 16));
        amountField.setBounds(180, 300, 350, 30);
        amountField.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(balField);
        panel.add(fNameField);
        panel.add(lNameField);
        panel.add(accNumField);
        panel.add(amountField);

        // set properties for buttons
        submitButton.setBounds(230, 380, 200, 50);
        submitButton.setFocusPainted(false);
        submitButton.setEnabled(false);
        submitButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(submitButton);

        // set properties for image
        // declare labels
        JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\Plain UI.jpg"));
        image.setSize(600, 500);
        panel.add(image);

        amountField.setText("0");
        amountField.setForeground(Color.GRAY);

        getBalance();

        // What happens to the fields
        fNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!Character.isLetter(e.getKeyChar())) {
                    e.consume();
                }

                String field = String.valueOf(fNameField.getText());
                String field2 = String.valueOf(lNameField.getText());
                String field3 = String.valueOf(accNumField.getText());
                String field4 = String.valueOf(amountField.getText());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("0")) {
                    submitButton.setEnabled(false);
                } else {
                    submitButton.setEnabled(true);
                }
            }
        });

        lNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!Character.isLetter(e.getKeyChar())) {
                    e.consume();
                }

                String field = String.valueOf(fNameField.getText());
                String field2 = String.valueOf(lNameField.getText());
                String field3 = String.valueOf(accNumField.getText());
                String field4 = String.valueOf(amountField.getText());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("0")) {
                    submitButton.setEnabled(false);
                } else {
                    submitButton.setEnabled(true);
                }
            }
        });

        accNumField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                String field = String.valueOf(fNameField.getText());
                String field2 = String.valueOf(lNameField.getText());
                String field3 = String.valueOf(accNumField.getText());
                String field4 = String.valueOf(amountField.getText());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("0")) {
                    submitButton.setEnabled(false);
                } else {
                    submitButton.setEnabled(true);
                }
            }
        });

        // Check field focus
        amountField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(amountField.getText());

                if (field.trim().equals("")) {
                    amountField.setText("0");
                    amountField.setForeground(Color.GRAY);
                }
            }
        });

        amountField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String field = String.valueOf(amountField.getText());

                if (field.trim().equals("0")) {
                    amountField.setText("");
                    amountField.setForeground(Color.BLACK);
                }
            }
        });

        amountField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }

                String field = String.valueOf(fNameField.getText());
                String field2 = String.valueOf(lNameField.getText());
                String field3 = String.valueOf(accNumField.getText());
                String field4 = String.valueOf(amountField.getText());

                if (field.trim().equals("") || field2.trim().equals("") || field3.trim().equals("") || field4.trim().equals("0")) {
                    submitButton.setEnabled(false);
                } else {
                    submitButton.setEnabled(true);
                }
            }
        });

        // what happens when the button is pressed
        submitButton.addActionListener((ActionEvent e) -> {
            try {
                boolean check = verifyFields();

                if (check) {
                    postToDatabase();
                    fieldReset();
                }
            } catch (Exception ex) {
                Logger.getLogger(ChangeInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private boolean verifyFields() throws Exception {
        // declare variables
        var.fName = fNameField.getText();
        var.lName = lNameField.getText();
        var.accountNum = accNumField.getText();
        var.balance = Float.parseFloat(amountField.getText());

        if (var.accountNum.equals(getAccNum())) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Invalid Info", "Warning", 2);
            return false;
        }

        if (DataSQL.checkAcc(var.fName, var.lName, var.accountNum)) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Account doesn't exist", "Warning", 2);
            return false;
        } else {
            return true;
        }
    }

    private void getBalance() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/users";
            String username = "root";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to LogTable.");

            Statement statement = conn.createStatement();
            String queryString = "SELECT balance FROM log";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                DecimalFormat f = new DecimalFormat("##.00");
                Float bal = Float.parseFloat(results.getString("balance"));
                balField.setText(f.format(bal));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    private String getAccNum() {
        String accNum = null;

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost/users";
            String username = "root";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to LogTable.");

            Statement statement = conn.createStatement();
            String queryString = "SELECT account_number FROM log";
            ResultSet results = statement.executeQuery(queryString);

            while (results.next()) {
                accNum = results.getString("account_number");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return accNum;
    }

    private void postToDatabase() throws SQLException {
        Float amount = Float.parseFloat(amountField.getText());

        DataSQL.transferCash(amount);
    }

    private void fieldReset() throws Exception {
        getBalance();
        fNameField.setText("");
        lNameField.setText("");
        accNumField.setText("");
        amountField.setText("0");
    }

    public JPanel getComponent() {
        return panel;
    }
}

class GUI {
    // declare image objects
    private static final JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\logo.png"));
    private static final JLabel rights = new JLabel("Copyright © 2019 Malik Heron.");

    // declare buttons
    private static final JButton optionsButton = new JButton("Options");
    private static final JButton transferButton = new JButton("Transfer Money");
    private static final JButton currencyButton = new JButton("Currency Converter");
    private static final JButton changeButton = new JButton("Change Login Info");
    private static final JButton logoutButton = new JButton("Log out");

    public static void createAndShowUI() {
        // set properties for buttons
        optionsButton.setBounds(80, 70, 200, 50);
        optionsButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        optionsButton.setFocusPainted(false);
        transferButton.setBounds(80, 140, 200, 50);
        transferButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        transferButton.setFocusPainted(false);
        currencyButton.setBounds(80, 210, 200, 50);
        currencyButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        currencyButton.setFocusPainted(false);
        changeButton.setBounds(80, 280, 200, 50);
        changeButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        changeButton.setFocusPainted(false);
        logoutButton.setBounds(80, 350, 200, 50);
        logoutButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        logoutButton.setFocusPainted(false);

        // set properties for rights
        rights.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        rights.setBounds(180, 320, 400, 30);

        // set properties for image
        image.setBounds(0, 80, 600, 300);

        // what the buttons do when pressed
        optionsButton.addActionListener((ActionEvent e) -> {
            optionsButton.setEnabled(false);
            transferButton.setEnabled(true);
            currencyButton.setEnabled(true);
            changeButton.setEnabled(true);

            MainScreen.jPanel2.removeAll();
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();

            MainScreen.jPanel2.add(new UserOptions().getComponent());
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();
        });

        transferButton.addActionListener((ActionEvent e) -> {
            transferButton.setEnabled(false);
            optionsButton.setEnabled(true);
            currencyButton.setEnabled(true);
            changeButton.setEnabled(true);

            MainScreen.jPanel2.removeAll();
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();

            MainScreen.jPanel2.add(new TransferCash().getComponent());
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();
        });

        currencyButton.addActionListener((ActionEvent e) -> {
            currencyButton.setEnabled(false);
            transferButton.setEnabled(true);
            changeButton.setEnabled(true);
            optionsButton.setEnabled(true);

            MainScreen.jPanel2.removeAll();
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();

            MainScreen.jPanel2.add(new CurrencyConverter().getComponent());
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();
        });

        changeButton.addActionListener((ActionEvent e) -> {
            changeButton.setEnabled(false);
            transferButton.setEnabled(true);
            currencyButton.setEnabled(true);
            optionsButton.setEnabled(true);

            MainScreen.jPanel2.removeAll();
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();

            MainScreen.jPanel2.add(new ChangeInfo().getComponent());
            MainScreen.jPanel2.repaint();
            MainScreen.jPanel2.revalidate();
        });

        logoutButton.addActionListener((ActionEvent e) -> {
            boolean isYes;

            int selection = Messages.logoutPrompt(MainScreen.jPanel1);

            isYes = (selection == JOptionPane.YES_OPTION);

            if (isYes) {
                try {
                    GUI.dateAndTime();
                    //System.exit(0);
                    MainScreen.jPanel1.removeAll();
                    MainScreen.jPanel1.repaint();
                    MainScreen.jPanel1.revalidate();

                    MainScreen.jPanel1.add(MainScreen.userButton);
                    MainScreen.jPanel1.add(MainScreen.adminButton);
                    MainScreen.jPanel1.add(MainScreen.createButton);
                    MainScreen.jPanel1.add(MainScreen.exitButton);

                    changeButton.setEnabled(true);
                    transferButton.setEnabled(true);
                    currencyButton.setEnabled(true);
                    optionsButton.setEnabled(true);
                    MainScreen.userButton.setEnabled(true);

                    MainScreen.jPanel2.removeAll();
                    MainScreen.jPanel2.repaint();
                    MainScreen.jPanel2.revalidate();

                    MainScreen.jPanel2.add(rights);
                    MainScreen.jPanel2.add(image);
                    MainScreen.jPanel2.repaint();
                    MainScreen.jPanel2.revalidate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // set up the screens
        MainScreen.jPanel1.removeAll();
        MainScreen.jPanel1.repaint();
        MainScreen.jPanel1.revalidate();

        MainScreen.jPanel1.add(optionsButton);
        MainScreen.jPanel1.add(transferButton);
        MainScreen.jPanel1.add(currencyButton);
        MainScreen.jPanel1.add(changeButton);
        MainScreen.jPanel1.add(logoutButton);
        MainScreen.jPanel1.repaint();
        MainScreen.jPanel1.revalidate();

        MainScreen.jPanel2.removeAll();
        MainScreen.jPanel2.repaint();
        MainScreen.jPanel2.revalidate();

        MainScreen.jPanel2.add(rights);
        MainScreen.jPanel2.add(image);
        MainScreen.jPanel2.repaint();
        MainScreen.jPanel2.revalidate();
    }

    public static void dateAndTime() throws Exception {
        Storage var = new Storage();

        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        var.time = dateTime.format(formatter);
        System.out.println("Date Stored.");

        DataSQL.addAccessTime(var.time);
    }
}