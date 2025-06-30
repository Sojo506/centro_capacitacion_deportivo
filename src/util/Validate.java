package util;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Validate {

    public static boolean validateForm(String fullName, String email, String password) {

        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Full name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (fullName.length() < 3) {
            JOptionPane.showMessageDialog(null, "Full name must be 3 characters or more.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be 8 characters or more.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean validateFormProfile(Component parent, String fullName, String password, String confirmPassword) {

        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Full name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (fullName.length() < 3) {
            JOptionPane.showMessageDialog(parent, "Full name must be 3 characters or more.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(parent, "Password must be 8 characters or more.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Confirm password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (confirmPassword.length() < 8) {
            JOptionPane.showMessageDialog(parent, "Confirm password must be 8 characters or more.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(parent, "Passwords must be the same.", "Incorrect passwords", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
