package view.login;

import controller.UserController;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.User;
import util.Colors;
import view.MainView;

public class SignIn extends javax.swing.JPanel {

    private LoginFrame loginFrame;
    private User user;
    private UserController userController;

    public SignIn() {
        initComponents();
        userController = new UserController();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (loginFrame == null) {
            loginFrame = (LoginFrame) SwingUtilities.getWindowAncestor(this);
        }
    }

    public boolean validateForm(String email, String password) {

        if (email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be 8 characters or more.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        inputPassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(216, 218, 211));

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(26, 26, 26));
        titleLabel.setText("Sign In to Depor&T");

        emailLabel.setFont(new java.awt.Font("Adwaita Sans", 0, 16)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(26, 26, 26));
        emailLabel.setText("Email");

        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Adwaita Sans", 0, 16)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(26, 26, 26));
        passwordLabel.setText("Password");

        loginBtn.setBackground(new java.awt.Color(45, 49, 66));
        loginBtn.setFont(new java.awt.Font("Adwaita Sans", 0, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        loginBtn.setBorderPainted(false);
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.setFocusPainted(false);
        loginBtn.setFocusable(false);
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnMouseExited(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        inputPassword.setPreferredSize(new java.awt.Dimension(150, 40));
        inputPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailLabel)
                    .addComponent(inputEmail)
                    .addComponent(passwordLabel)
                    .addComponent(loginBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        loginBtn.doClick();
    }//GEN-LAST:event_inputEmailActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String email = inputEmail.getText().trim();
        String password = new String(inputPassword.getText()).trim();

        boolean isValidate = validateForm(email, password);

        if (isValidate) {
            user = userController.loginUser(email, password);

            if (user != null) {
                JOptionPane.showMessageDialog(this, "Welcome back " + user.getFullName() + "!", "Welcome", JOptionPane.PLAIN_MESSAGE);
                loginFrame.dispose();
                java.awt.EventQueue.invokeLater(() -> new MainView(user).setVisible(true));
            } else {
                JOptionPane.showMessageDialog(this, "User not found.", "404", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_loginBtnActionPerformed

    private void loginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseEntered
        loginBtn.setBackground(Colors.BACKGROUND_PRIMARY);
    }//GEN-LAST:event_loginBtnMouseEntered

    private void loginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseExited
        loginBtn.setBackground(Colors.GUNMETAL);
    }//GEN-LAST:event_loginBtnMouseExited

    private void inputPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPasswordActionPerformed
        loginBtn.doClick();
    }//GEN-LAST:event_inputPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
