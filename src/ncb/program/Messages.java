package ncb.program;

import javax.swing.*;

/**
 * @author Malik Heron
 */
public class Messages {

    public static void loginMessage(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Enter Username", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void loginMessage2(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Enter Your Password", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void loginError(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Account not found!", "Invalid info", JOptionPane.ERROR_MESSAGE);
    }

    public static int exitPrompt(JPanel panel) {
        return JOptionPane.showConfirmDialog(panel, "Do you want to continue?", "Exit prompt", JOptionPane.YES_NO_OPTION);
    }

    public static int logoutPrompt(JPanel panel) {
        return JOptionPane.showConfirmDialog(panel, "Do you want to continue?", "Prompt", JOptionPane.YES_NO_OPTION);
    }

    public static void createMessage(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Account Created!", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void depositError(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Cannot deposit more than $30, 000", "Error", JOptionPane.WARNING_MESSAGE);
    }

    public static void withdrawError(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Cannot withdraw more than $30, 000", "Error", JOptionPane.WARNING_MESSAGE);
    }

    public static void exceedsBalance() {
        JOptionPane.showMessageDialog(null, "Cannot withdraw more than what is in your account", "Error", JOptionPane.WARNING_MESSAGE);
    }

    public static void noInternet(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Internet Connection unavailable", "Error", JOptionPane.WARNING_MESSAGE);
    }
}