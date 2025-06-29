package view.login;

import controller.UserController;
import javax.swing.JOptionPane;
import model.User;
import util.Colors;

public class SignUp extends javax.swing.JPanel {

    private LoginFrame loginFrame;
    private User user;
    private UserController userController;

    public SignUp(LoginFrame loginFrame) {
        initComponents();
        this.loginFrame = loginFrame;
        userController = new UserController();
    }

    public boolean validateForm(String fullName, String email, String password) {

        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Full name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (fullName.length() < 3) {
            JOptionPane.showMessageDialog(this, "Full name must be 3 characters or more.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

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

        inputEmail = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        fullName = new javax.swing.JLabel();
        inputFullName = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(216, 218, 211));

        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        registerBtn.setBackground(new java.awt.Color(0, 123, 255));
        registerBtn.setFont(new java.awt.Font("Adwaita Sans", 0, 18)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(26, 26, 26));
        registerBtn.setText("Register");
        registerBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtn.setFocusPainted(false);
        registerBtn.setFocusable(false);
        registerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerBtnMouseExited(evt);
            }
        });
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(26, 26, 26));
        title.setText("Create Account");

        fullName.setFont(new java.awt.Font("Adwaita Sans", 0, 16)); // NOI18N
        fullName.setForeground(new java.awt.Color(26, 26, 26));
        fullName.setText("Full name");

        inputFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFullNameActionPerformed(evt);
            }
        });

        email.setBackground(new java.awt.Color(26, 26, 26));
        email.setFont(new java.awt.Font("Adwaita Sans", 0, 16)); // NOI18N
        email.setForeground(new java.awt.Color(26, 26, 26));
        email.setText("Email");

        password.setFont(new java.awt.Font("Adwaita Sans", 0, 16)); // NOI18N
        password.setForeground(new java.awt.Color(26, 26, 26));
        password.setText("Password");

        inputPassword.setPreferredSize(new java.awt.Dimension(150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password)
                    .addComponent(fullName)
                    .addComponent(inputFullName)
                    .addComponent(email)
                    .addComponent(inputEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(fullName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        String fullName = inputFullName.getText().trim();
        String email = inputEmail.getText().trim();
        String password = new String(inputPassword.getText()).trim();

        boolean isValidate = validateForm(fullName, email, password);

        if (isValidate) {
            user = userController.findUser(email);
            if (user == null) {
                userController.registerUser(fullName, email, password);
                JOptionPane.showMessageDialog(this, "User created.", "Success", JOptionPane.INFORMATION_MESSAGE);
                loginFrame.showPanel(new SignIn(loginFrame));
            } else {
                JOptionPane.showMessageDialog(this, "User already exist.", "404", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_registerBtnActionPerformed

    private void inputFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFullNameActionPerformed

    private void registerBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnMouseEntered
        registerBtn.setBackground(Colors.BUTTON_HOVER);
    }//GEN-LAST:event_registerBtnMouseEntered

    private void registerBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnMouseExited
        registerBtn.setBackground(Colors.BUTTON_PRIMARY);
    }//GEN-LAST:event_registerBtnMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email;
    private javax.swing.JLabel fullName;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputFullName;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel password;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
