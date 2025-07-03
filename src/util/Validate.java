package util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Validate {

    public static boolean validateRegister(String fullName, String email, String password) {

        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Full name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (fullName.length() < 3 || fullName.length() > 30) {
            JOptionPane.showMessageDialog(null, "Full name must be between 3 and 30 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (email.length() > 30) {
            JOptionPane.showMessageDialog(null, "Email must not exceed 30 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < 8 || password.length() > 64) {
            JOptionPane.showMessageDialog(null, "Password must be between 8 and 64 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean validateUserData(
            Component parent,
            String fullName,
            String email,
            String password,
            String confirmPassword
    ) {

        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (fullName.length() < 3 || fullName.length() > 30) {
            JOptionPane.showMessageDialog(parent, "Full name must be between 3 and 30 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(parent, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (email.length() > 30) {
            JOptionPane.showMessageDialog(parent, "Email must not exceed 30 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < 8 || password.length() > 64) {
            JOptionPane.showMessageDialog(parent, "Password must be between 8 and 64 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (confirmPassword.length() < 8 || confirmPassword.length() > 64) {
            JOptionPane.showMessageDialog(parent, "Confirm password must be between 8 and 64 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(parent, "Passwords must be the same.", "Incorrect passwords", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean validateAthleteParentForm(
            Component parent,
            String name,
            String lastName,
            String city,
            String address,
            String phone,
            String email
    ) {
        if (name.isEmpty() || lastName.isEmpty() || city.isEmpty()
                || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (name.length() > 15 || lastName.length() > 15) {
            JOptionPane.showMessageDialog(parent, "Name and last name must not exceed 15 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (city.length() > 30 || address.length() > 30) {
            JOptionPane.showMessageDialog(parent, "City or address too long.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (phone.length() > 30) {
            JOptionPane.showMessageDialog(parent, "Phone number is too long.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(parent, "Please enter a valid email.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (email.length() > 30) {
            JOptionPane.showMessageDialog(parent, "Email must not exceed 30 characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
