package ncb.program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author Malik Heron
 */
public class CreateAccount {
    // declare objects
    private final JPanel panel = new JPanel();
    private final Storage var = new Storage();

    // Text fields
    private final JTextField firstNameField = new JTextField();
    private final JTextField lastNameField = new JTextField();
    private final JTextField ageField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JPasswordField confirmPasswordField = new JPasswordField();
    private final JTextField usernameField = new JTextField();

    // Others
    private final JComboBox<String> comboBox1 = new JComboBox<>();
    private final JRadioButton maleRadioButton = new JRadioButton("Male");
    private final JRadioButton femaleRadioButton = new JRadioButton("Female");
    private final ButtonGroup genderGroup = new ButtonGroup();

    public CreateAccount() {
        // set properties for panel
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setSize(600, 500);
        panel.setOpaque(false);

        // set properties for labels
        JLabel firstName = new JLabel("First name: ");
        firstName.setBounds(10, 65, 150, 40);
        JLabel lastName = new JLabel("Last name: ");
        lastName.setBounds(10, 103, 150, 40);
        JLabel age = new JLabel("Age: ");
        age.setBounds(10, 140, 150, 40);
        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(10, 178, 150, 40);
        JLabel parish = new JLabel("Parish: ");
        parish.setBounds(10, 220, 150, 40);
        JLabel email = new JLabel("Email address: ");
        email.setBounds(10, 255, 150, 40);
        JLabel username = new JLabel("Username: ");
        username.setBounds(10, 290, 150, 40);
        JLabel password = new JLabel("New password: ");
        password.setBounds(10, 335, 150, 40);
        JLabel confirmPassword = new JLabel("Confirm password: ");
        confirmPassword.setBounds(10, 370, 150, 40);

        // set font and size of labels
        firstName.setFont(new Font("times new roman", Font.PLAIN, 18));
        lastName.setFont(new Font("times new roman", Font.PLAIN, 18));
        age.setFont(new Font("times new roman", Font.PLAIN, 18));
        gender.setFont(new Font("times new roman", Font.PLAIN, 18));
        parish.setFont(new Font("times new roman", Font.PLAIN, 18));
        email.setFont(new Font("times new roman", Font.PLAIN, 18));
        username.setFont(new Font("times new roman", Font.PLAIN, 18));
        password.setFont(new Font("times new roman", Font.PLAIN, 18));
        confirmPassword.setFont(new Font("times new roman", Font.PLAIN, 18));

        // add labels to panel
        panel.add(firstName);
        panel.add(lastName);
        panel.add(age);
        panel.add(gender);
        panel.add(parish);
        panel.add(email);
        panel.add(username);
        panel.add(password);
        panel.add(confirmPassword);

        // set properties for fields
        firstNameField.setBounds(200, 75, 310, 25);
        lastNameField.setBounds(200, 110, 310, 25);
        ageField.setBounds(200, 145, 310, 25);
        emailField.setBounds(200, 260, 310, 25);
        usernameField.setBounds(200, 300, 310, 25);
        passwordField.setBounds(200, 340, 310, 25);
        confirmPasswordField.setBounds(200, 375, 310, 25);

        emailField.setText("Email Address");
        usernameField.setText("Username");
        passwordField.setEchoChar((char) 0);
        passwordField.setText("Password");
        confirmPasswordField.setEchoChar((char) 0);
        confirmPasswordField.setText("Confirm Password");

        emailField.setForeground(new Color(153, 153, 153));
        usernameField.setForeground(new Color(153, 153, 153));
        passwordField.setForeground(new Color(153, 153, 153));
        confirmPasswordField.setForeground(new Color(153, 153, 153));

        firstNameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        lastNameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        ageField.setFont(new Font("times new roman", Font.PLAIN, 16));
        emailField.setFont(new Font("times new roman", Font.PLAIN, 16));
        usernameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        passwordField.setFont(new Font("times new roman", Font.PLAIN, 16));
        confirmPasswordField.setFont(new Font("times new roman", Font.PLAIN, 16));

        // add text fields to panel
        panel.add(firstNameField);
        panel.add(lastNameField);
        panel.add(ageField);
        panel.add(emailField);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(confirmPasswordField);

        // set properties for buttons
        // Buttons
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(140, 430, 170, 50);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(340, 430, 170, 50);

        confirmButton.setFocusPainted(false);
        cancelButton.setFocusPainted(false);

        confirmButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        cancelButton.setFont(new Font("times new roman", Font.PLAIN, 16));

        confirmButton.setMnemonic(KeyEvent.VK_ENTER);
        cancelButton.setMnemonic(KeyEvent.VK_ESCAPE);

        panel.add(confirmButton);
        panel.add(cancelButton);

        // set properties for combo box
        comboBox1.setBounds(200, 225, 310, 25);
        comboBox1.addItem("");
        comboBox1.addItem("Clarendon");
        comboBox1.addItem("Hanover");
        comboBox1.addItem("Kingston");
        comboBox1.addItem("Manchester");
        comboBox1.addItem("Portland");
        comboBox1.addItem("St. Andrew");
        comboBox1.addItem("St. Ann");
        comboBox1.addItem("St. Catherine");
        comboBox1.addItem("St. Elizabeth");
        comboBox1.addItem("St. James");
        comboBox1.addItem("St. Mary");
        comboBox1.addItem("St. Thomas");
        comboBox1.addItem("Trelawny");
        comboBox1.addItem("Westmoreland");
        comboBox1.setFocusable(false);
        comboBox1.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(comboBox1);

        // set properties for radio button
        maleRadioButton.setBounds(200, 185, 135, 25);
        maleRadioButton.setOpaque(false);
        maleRadioButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        femaleRadioButton.setBounds(370, 185, 138, 25);
        femaleRadioButton.setOpaque(false);
        femaleRadioButton.setFont(new Font("times new roman", Font.PLAIN, 16));

        maleRadioButton.setFocusPainted(false);
        femaleRadioButton.setFocusPainted(false);

        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        panel.add(maleRadioButton);
        panel.add(femaleRadioButton);

        // set properties for image
        // Labels
        JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\CreateAccount UI.jpg"));
        image.setSize(600, 500);
        panel.add(image);

        // what each button does when pressed
        confirmButton.addActionListener((ActionEvent e) -> {
            boolean check = false;
            try {
                check = verifyFields();
            } catch (Exception ex) {
                System.out.println(ex);
            }

            if (check) {
                try {
                    postToDatabase();
                    fieldReset();

                    MainScreen.userButton.setEnabled(false);
                    MainScreen.adminButton.setEnabled(false);
                    MainScreen.createButton.setEnabled(false);
                    MainScreen.exitButton.setEnabled(false);

                    AccountSummary.createAndShowUI();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        cancelButton.addActionListener((ActionEvent e) -> {
            fieldReset();
        });

        // shows text when the fields are out of or in focus
        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String pass = String.valueOf(emailField.getText());

                if (pass.trim().equals("")) {
                    emailField.setText("Email Address");
                    emailField.setForeground(new Color(153, 153, 153));
                }
            }
        });

        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String pass = String.valueOf(emailField.getText());

                if (pass.trim().equals("Email Address")) {
                    emailField.setText("");
                    emailField.setForeground(Color.black);
                }
            }
        });

        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String pass = String.valueOf(usernameField.getText());

                if (pass.trim().equals("")) {
                    usernameField.setText("Username");
                    usernameField.setForeground(new Color(153, 153, 153));
                }
            }
        });

        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String pass = String.valueOf(usernameField.getText());

                if (pass.trim().equals("Username")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.black);
                }
            }
        });

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(passwordField.getPassword());

                if (field.trim().equals("")) {
                    passwordField.setText("Password");
                    passwordField.setForeground(new Color(153, 153, 153));
                    passwordField.setEchoChar((char) 0);
                }
            }
        });

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String field = String.valueOf(passwordField.getPassword());

                if (field.trim().equals("Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.black);
                    passwordField.setEchoChar(('*'));
                }
            }
        });

        confirmPasswordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(confirmPasswordField.getPassword());

                if (field.trim().equals("")) {
                    confirmPasswordField.setText("Confirm Password");
                    confirmPasswordField.setForeground(new Color(153, 153, 153));
                    confirmPasswordField.setEchoChar((char) 0);
                }
            }
        });

        confirmPasswordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String field = String.valueOf(confirmPasswordField.getPassword());

                if (field.trim().equals("Confirm Password")) {
                    confirmPasswordField.setText("");
                    confirmPasswordField.setForeground(Color.black);
                    confirmPasswordField.setEchoChar(('*'));
                }
            }
        });

        // ensures that only certain characters are entered
        firstNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!Character.isLetter(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        lastNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!Character.isLetter(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        ageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
    }

    private boolean verifyFields() throws Exception {
        // declare variables
        var.fName = firstNameField.getText();
        var.lName = lastNameField.getText();
        var.age = ageField.getText();
        var.email = emailField.getText();
        var.username = usernameField.getText();
        var.parish = comboBox1.getSelectedItem();
        var.password = String.valueOf(passwordField.getPassword());
        var.pass = String.valueOf(confirmPasswordField.getPassword());
        maleRadioButton.getSelectedObjects();
        femaleRadioButton.getSelectedObjects();

        if (var.fName.trim().equals("") || var.lName.trim().equals("") || var.age.trim().equals("")
                || (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected())
                || var.parish.equals("") || var.email.equals("") || var.email.equals("Email Address")
                || var.username.equals("") || var.username.equals("Username")
                || var.password.trim().equals("") || var.password.trim().equals("Password")
                || var.pass.equals("") || var.pass.equals("Confirm Password")
        ) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "One or more fields are empty", "Warning", 2);
            return false;
        }

        if (Float.valueOf(var.age) < 18) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "18 and older", "Warning", 2);
            return false;
        }

        if (!VerifyEmail.isValid(var.email)) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Invalid Email Address", "Warning", 2);
            return false;
        }

        if (DataSQL.checkUsername(var.username)) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Username already exists", "Warning", 2);
            return false;
        }

        if (var.password.length() < 8) {
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Password requires 8 or more characters", "Warning", 2);
            return false;
        }

        if (!var.password.equals(var.pass)) { /* check if the two password match */
            JOptionPane.showMessageDialog(MainScreen.jPanel2, "Password Doesn't Match", "Warning", 2);
            return false;
        } else {
            return true;
        }
    }

    private void postToDatabase() throws Exception {
        if (maleRadioButton.isSelected()) {
            var.gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            var.gender = "Female";
        }

        accNumGenerator();
        midasGenerator();
        MD5hasher(var.pass);
        dateAndTime();

        DataSQL.post(var.fName, var.lName, var.age, var.gender, var.parish, var.email, var.username, var.password, var.accountNum, var.midas, var.balance, var.time);
        Messages.createMessage(MainScreen.jPanel2);
    }

    protected void accNumGenerator() {
        String saltChars = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() <= 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }

        System.out.println("Account Number Generated.");
        var.accountNum = salt.toString();
    }

    protected void midasGenerator() {
        String saltChars = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() <= 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }

        System.out.println("Midas Generated.");
        var.midas = salt.toString();
    }

    public void MD5hasher(String password) {
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
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
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
        // set properties for fields
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        emailField.setText("Email Address");
        usernameField.setText("Username");
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        confirmPasswordField.setText("Confirm Password");
        confirmPasswordField.setEchoChar((char) 0);

        emailField.setForeground(new Color(153, 153, 153));
        usernameField.setForeground(new Color(153, 153, 153));
        passwordField.setForeground(new Color(153, 153, 153));
        confirmPasswordField.setForeground(new Color(153, 153, 153));
        genderGroup.clearSelection();
        comboBox1.setSelectedIndex(0);
    }

    public void dateAndTime() {
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        var.time = dateTime.format(formatter);
        System.out.println("Date Stored.");
    }

    public JPanel getComponent() {
        return panel;
    }
}