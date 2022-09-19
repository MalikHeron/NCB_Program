package ncb.program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author Malik Heron
 */
public class AdminLogin {
    // declare objects
    private final JPanel panel = new JPanel();
    private final Storage get = new Storage();
    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JCheckBox show = new JCheckBox("Show password");

    public AdminLogin() throws Exception {
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
        usernameField.setForeground(new Color(153, 153, 153));
        usernameField.setFont(new Font("times new roman", Font.PLAIN, 16));
        passwordField.setBounds(185, 290, 310, 43);
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setForeground(new Color(153, 153, 153));
        passwordField.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(usernameField);
        panel.add(passwordField);

        // set properties for image
        JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\AdminLogin UI.jpg"));
        image.setSize(600, 500);
        panel.add(image);

        // Check which button was pressed
        confirm.addActionListener((ActionEvent e) -> {
            boolean check = verifyFields();

            if (check) {
                try {
                    boolean exist = searchDatabase();

                    if (exist) {
                        fieldReset();
                        AdminLoading.createAndShowGUI();
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

        // Check if field are in focus
        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                String field = String.valueOf(usernameField.getText());

                if (field.trim().equals("")) {
                    usernameField.setText("Username");
                    usernameField.setForeground(new Color(153, 153, 153));
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
        get.password = String.valueOf(passwordField.getPassword());

        // show a message if any of the fields are empty
        if (get.username.trim().equals("Username") || get.username.trim().equals("")) {
            Messages.loginMessage(MainScreen.jPanel2);
            return false;
        } else if (get.password.trim().equals("Password") || get.password.trim().equals("")) {
            Messages.loginMessage2(MainScreen.jPanel2);
            return false;
        } else {
            return true;
        }
    }

    private boolean searchDatabase() throws Exception {
        return DataSQL.getAdminAccount(get.username, get.password);
    }

    private void fieldReset() {
        usernameField.setText("Username");
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        show.setSelected(false);
        usernameField.setForeground(new Color(153, 153, 153));
        passwordField.setForeground(new Color(153, 153, 153));
    }

    public JComponent getComponent() {
        return panel;
    }
}