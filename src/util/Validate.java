package util;

import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import model.Parent;
import model.Routine;

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

    public static boolean validateSport(Component parent, String name, String characteristics) {

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (name.length() < 3 || name.length() > 20) {
            JOptionPane.showMessageDialog(null, "Full name must be between 3 and 20 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (characteristics.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Characteristics cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (characteristics.length() < 10 || characteristics.length() > 200) {
            JOptionPane.showMessageDialog(null, "Characteristics must be between 10 and 200 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean validateRoutine(Component parent, String description, String duration) {

        if (description.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Description cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (description.length() < 3 || description.length() > 300) {
            JOptionPane.showMessageDialog(parent, "Description must be between 3 and 300 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (duration.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Duration cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int dur = Integer.parseInt(duration);
            if (dur <= 0) {
                JOptionPane.showMessageDialog(parent, "Duration must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, "Duration must be a valid number (e.g., 120, 60, 30).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public static boolean validateInvoice(Component parent, Parent selectedParent, List<Routine> selectedRoutines, String total) {
        try {
            double t = Double.parseDouble(total);
            if (t <= 0) {
                JOptionPane.showMessageDialog(parent, "Total must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, "Total must be a valid number (e.g., 13.800, 9000, 22.000).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (selectedParent == null) {
            JOptionPane.showMessageDialog(parent, "You must select a parent.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (selectedRoutines.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "You must select at least one routine.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

}
