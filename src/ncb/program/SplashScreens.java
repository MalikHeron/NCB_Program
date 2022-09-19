package ncb.program;

import javafx.concurrent.Task;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Malik Heron
 */
class SplashScreens {
    // declare objects
    private static final JWindow window = new JWindow();
    private static final JLabel image = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\logo.png"));
    private static final JProgressBar progressBar = new JProgressBar();

    public static void welcome() {
        // set properties for frame
        window.setSize(600, 300);
        window.setLocationRelativeTo(null);
        window.getContentPane().setBackground(Color.WHITE);
        window.setVisible(true);

        // set properties for image
        image.setBounds(20, -20, 600, 300);
        image.setSize(600, 300);
        window.add(image);

        // set properties for progress bar
        progressBar.setBounds(100, 250, 400, 30);
        progressBar.setFont(new Font("times new roman", Font.PLAIN, 16));
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.LIGHT_GRAY);
        progressBar.setValue(0);
        window.add(progressBar);

        int i = 0;//Creating an integer variable and initializing it to 0

        while (i <= 110) {
            progressBar.setValue(i);//Setting value of Progress Bar
            progressBar.setString("Loading...");

            try {
                if (i < 20) {
                    i += Database.createAdminDatabase();
                } else if (i < 40) {
                    i += Database.createUsersDatabase();
                } else if (i < 60) {
                    i += DataSQL.createDataTable();
                } else if (i < 80) {
                    i += DataSQL.createLogTable();
                } else if (i < 100) {
                    i += DataSQL.createTransTable();
                } else {
                    Thread.sleep(400);
                    i += 25;
                    window.dispose();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class AdminLoading {
    private final JWindow window = new JWindow();
    private final JLabel text = new JLabel("Logging in ");
    private final JLabel gif = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\load2.gif"));

    public static void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> {
            new AdminLoading().start();
        });
    }

    private void start() {
        window.setSize(595, 500);
        window.setLocationRelativeTo(MainScreen.jPanel2);
        window.setVisible(true);

        // set the properties of the text
        text.setFont(new Font("times new roman", Font.ITALIC, 40));
        text.setBounds(205, 60, 500, 50);
        text.setForeground(Color.BLACK);
        window.add(text);

        // set properties of gif
        gif.setBounds(0, 0, 595, 510);
        window.add(gif);

        new StartWorker().execute();
    }

    private class StartWorker extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            // Do background process
            Thread.sleep(2000);
            AdminOptions.createAndShowUI();
            return null;
        }

        @Override
        protected void done() {
            try {
                LoggedIn.createAndShowGUI();
                window.dispose();
            } catch (Exception ex) {
                Logger.getLogger(AdminLoading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class UserLoading {
    private final JWindow window = new JWindow();
    private final JLabel text = new JLabel("Logging in ");
    private final JLabel gif = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\load2.gif"));

    public static void createAndShowGUI() {
        SwingUtilities.invokeLater(() -> {
            new UserLoading().start();
        });
    }

    private void start() {
        window.setSize(595, 500);
        window.setLocationRelativeTo(MainScreen.jPanel2);
        window.setVisible(true);

        // set the properties of the text
        text.setFont(new Font("times new roman", Font.ITALIC, 40));
        text.setBounds(205, 60, 500, 50);
        text.setForeground(Color.BLACK);
        window.add(text);

        // set properties of gif
        gif.setBounds(0, 0, 595, 510);
        window.add(gif);

        new StartWorker().execute();
    }

    private class StartWorker extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            // Do background process
            Thread.sleep(2000);
            GUI.createAndShowUI();
            return null;
        }

        @Override
        protected void done() {
            try {
                LoggedIn.createAndShowGUI();
                window.dispose();
            } catch (Exception ex) {
                Logger.getLogger(UserLoading.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class LoggedIn {
    private static final JDialog dialog = new JDialog(null, null, Dialog.DEFAULT_MODALITY_TYPE);
    // declare objects
    private final JPanel panel = new JPanel();

    public LoggedIn() throws Exception {
        // set properties for panel
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setSize(600, 500);
        panel.setOpaque(true);

        // set the properties of the text
        JLabel text = new JLabel("You are now logged in ");
        text.setFont(new Font("times new roman", Font.ITALIC, 24));
        text.setBounds(185, 80, 500, 50);
        text.setForeground(Color.BLACK);
        panel.add(text);

        // set properties for button
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(230, 340, 120, 40);
        continueButton.setFocusPainted(false);
        continueButton.setFont(new Font("times new roman", Font.PLAIN, 16));
        panel.add(continueButton);

        // set properties of gif
        JLabel gif = new JLabel(new ImageIcon("D:\\Users\\Malik Heron\\IdeaProjects\\NCB Program\\src\\ncb\\icons\\arrow5.gif"));
        gif.setBounds(0, 0, 595, 500);
        panel.add(gif);

        // what happens when continueButton is pressed
        continueButton.addActionListener(e -> {
            Window win = SwingUtilities.getWindowAncestor(panel);
            win.dispose();
        });
    }

    public static void createAndShowGUI() throws Exception {
        // loading dialog
        dialog.setType(Window.Type.UTILITY);
        dialog.getContentPane().add(new LoggedIn().getComponent());
        dialog.setSize(595, 500);
        dialog.setLocationRelativeTo(MainScreen.jPanel2);
        dialog.setResizable(false);
        dialog.setUndecorated(true);
        dialog.setVisible(true);
        dialog.setLayout(null);
    }

    public JComponent getComponent() {
        return panel;
    }
}