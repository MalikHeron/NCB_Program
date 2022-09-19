package ncb.program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Malik Heron
 */
public class UserLogin {
    // declare objects
    private final JPanel panel = new JPanel();
    private final Storage get = new Storage();
    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JCheckBox show = new JCheckBox("Show password");

    public UserLogin() {
        // set properties for panel
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setSize(600, 500);
        panel.setOpaque(false);

        // set properties for buttons
        JButton confirm = new JButton("Confirm");
        confirm.setBounds(180, 450, 150, 30);
        confirm.setFocusPainted(false);
        confirm.setFont(new Font("times new roman", Font.PLAIN, 16));
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(340, 450, 150, 30);
        cancel.setFocusPainted(false);
        cancel.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(confirm);
        panel.add(cancel);

        // set properties for checkbox
        show.setBounds(186, 350, 150, 30);
        show.setFocusPainted(false);
        show.setOpaque(false);
        show.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(show);

        // set properties for fields
        usernameField.setBounds(185, 170, 310, 43);
        usernameField.setText("Username");
        usernameField.setForeground(Color.GRAY);
        usernameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        passwordField.setBounds(185, 290, 310, 43);
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(usernameField);
        panel.add(passwordField);

        // set properties for image
        JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\UserLogin UI.jpg"));
        image.setSize(600, 500);
        panel.add(image);

        // Check which button was pressed
        confirm.addActionListener((ActionEvent e) -> {
            boolean check = verifyFields();

            if (check) {
                try {
                    boolean exist = processDetails();

                    if (exist) {
                        fieldReset();

                        UserLoading.createAndShowGUI();
                    } else {
                        Messages.loginError(panel);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        cancel.addActionListener((ActionEvent e) -> {
            fieldReset();
        });

        // Check field focus
        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(usernameField.getText());

                if (field.trim().equals("")) {
                    usernameField.setText("Username");
                    usernameField.setForeground(Color.GRAY);
                }
            }
        });

        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);

                String field = String.valueOf(usernameField.getText());

                if (field.trim().equals("Username")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
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
                    passwordField.setForeground(Color.GRAY);
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
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setEchoChar(('*'));
                }
            }
        });

        // check status of checkbox
        show.addActionListener((ActionEvent e) -> {
            if (show.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar(('*'));
            }
        });
    }

    private boolean verifyFields() {
        get.username = usernameField.getText();
        get.pass = String.valueOf(passwordField.getPassword());

        // show a message if any of the fields are empty
        if (get.username.trim().equals("Username") || get.username.trim().equals("")) {
            Messages.loginMessage(MainScreen.jPanel2);
            return false;
        } else if (get.pass.trim().equals("Password") || get.pass.trim().equals("")) {
            Messages.loginMessage2(MainScreen.jPanel2);
            return false;
        } else {
            return true;
        }
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
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            //Get complete hashed password in hex format
            generatedPassword = sb.toString();

            System.out.println("Password Hash Completed.");
        } catch (NoSuchAlgorithmException e) {
            System.out.print(e);
        }

        get.password = generatedPassword;
    }

    private boolean processDetails() throws Exception {
        MD5hasher(get.pass);
        return DataSQL.getUserAccount(get.username, get.password);
    }

    private void fieldReset() {
        usernameField.setText("Username");
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        show.setSelected(false);
        usernameField.setForeground(Color.GRAY);
        passwordField.setForeground(Color.GRAY);
    }

    public JComponent getComponent() {
        return panel;
    }
}