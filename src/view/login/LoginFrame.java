package view.login;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import util.Colors;

public class LoginFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());
    private int xMouse, yMouse;

    public LoginFrame() {

        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        showPanel(new SignIn());
    }

    public void showPanel(JPanel newPanel) {
        panelContentRight.removeAll();
        panelContentRight.setLayout(new BorderLayout());
        panelContentRight.add(newPanel, BorderLayout.CENTER);
        panelContentRight.revalidate();
        panelContentRight.repaint();
    }

    public void setSignIn() {
        haveAccountLabel.setText("I do not have an account");
        signBtn.setText("Sign Up");
        showPanel(new SignIn());
    }

    public void setSignUp() {
        haveAccountLabel.setText("I do have an account");
        signBtn.setText("Sign In");
        showPanel(new SignUp());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        left = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        copyrightLabel = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        dragBtn = new javax.swing.JButton();
        accountInfo = new javax.swing.JPanel();
        haveAccountLabel = new javax.swing.JLabel();
        signBtn = new javax.swing.JButton();
        panelContentRight = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left.setBackground(new java.awt.Color(244, 244, 244));
        left.setPreferredSize(new java.awt.Dimension(400, 500));

        titleLabel.setFont(new java.awt.Font("Adwaita Mono", 1, 34)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(26, 26, 26));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        titleLabel.setText("Depor&T");
        titleLabel.setFocusable(false);
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        copyrightLabel.setFont(new java.awt.Font("Adwaita Sans", 0, 14)); // NOI18N
        copyrightLabel.setForeground(new java.awt.Color(102, 102, 102));
        copyrightLabel.setText("copyright © Depor&T all rights reserved");

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        exitBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.setFocusPainted(false);
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        dragBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dragdrop.png"))); // NOI18N
        dragBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dragBtn.setBorderPainted(false);
        dragBtn.setContentAreaFilled(false);
        dragBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        dragBtn.setFocusPainted(false);
        dragBtn.setFocusable(false);
        dragBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragBtnMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                dragBtnMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(copyrightLabel)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(leftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dragBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBtn)))
                .addContainerGap())
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitBtn)
                    .addComponent(dragBtn))
                .addGap(120, 120, 120)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(copyrightLabel)
                .addGap(20, 20, 20))
        );

        getContentPane().add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        accountInfo.setBackground(new java.awt.Color(74, 74, 72));
        accountInfo.setForeground(new java.awt.Color(244, 244, 244));
        accountInfo.setPreferredSize(new java.awt.Dimension(400, 0));

        haveAccountLabel.setForeground(new java.awt.Color(255, 255, 255));
        haveAccountLabel.setText("I do not have an account");

        signBtn.setBackground(new java.awt.Color(38, 103, 255));
        signBtn.setForeground(new java.awt.Color(255, 255, 255));
        signBtn.setText("Sign Up");
        signBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signBtn.setBorderPainted(false);
        signBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signBtn.setFocusPainted(false);
        signBtn.setFocusable(false);
        signBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signBtnMousePressed(evt);
            }
        });
        signBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountInfoLayout = new javax.swing.GroupLayout(accountInfo);
        accountInfo.setLayout(accountInfoLayout);
        accountInfoLayout.setHorizontalGroup(
            accountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountInfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(haveAccountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(signBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        accountInfoLayout.setVerticalGroup(
            accountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(accountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(haveAccountLabel)
                    .addComponent(signBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        getContentPane().add(accountInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, 60));

        javax.swing.GroupLayout panelContentRightLayout = new javax.swing.GroupLayout(panelContentRight);
        panelContentRight.setLayout(panelContentRightLayout);
        panelContentRightLayout.setHorizontalGroup(
            panelContentRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelContentRightLayout.setVerticalGroup(
            panelContentRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        getContentPane().add(panelContentRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signBtnActionPerformed
        if (haveAccountLabel.getText().equals("I do not have an account")) {
            setSignUp();
        } else {
            setSignIn();
        }
    }//GEN-LAST:event_signBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void dragBtnMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBtnMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_dragBtnMouseDragged

    private void dragBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBtnMouseMoved
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragBtnMouseMoved

    private void signBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signBtnMouseEntered
        signBtn.setBackground(Colors.GUNMETAL);
    }//GEN-LAST:event_signBtnMouseEntered

    private void signBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signBtnMouseExited
        signBtn.setBackground(Colors.BACKGROUND_PRIMARY);
    }//GEN-LAST:event_signBtnMouseExited

    private void signBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_signBtnMousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountInfo;
    private javax.swing.JLabel copyrightLabel;
    private javax.swing.JButton dragBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel haveAccountLabel;
    private javax.swing.JPanel left;
    private javax.swing.JPanel panelContentRight;
    private javax.swing.JButton signBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
