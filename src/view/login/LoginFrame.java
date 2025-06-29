package view.login;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class LoginFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginFrame.class.getName());
    private int xMouse, yMouse;

    public LoginFrame() {

        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

        showPanel(new SignIn(this));
    }

    public void showPanel(JPanel newPanel) {
        panelContentRight.removeAll();
        panelContentRight.setLayout(new BorderLayout());
        panelContentRight.add(newPanel, BorderLayout.CENTER);
        panelContentRight.revalidate();
        panelContentRight.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        left = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        dragBtn = new javax.swing.JButton();
        accountInfo = new javax.swing.JPanel();
        haveAccount = new javax.swing.JLabel();
        signBtn = new javax.swing.JButton();
        panelContentRight = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left.setBackground(new java.awt.Color(244, 244, 244));
        left.setPreferredSize(new java.awt.Dimension(400, 500));

        titulo.setFont(new java.awt.Font("Adwaita Mono", 1, 34)); // NOI18N
        titulo.setForeground(new java.awt.Color(26, 26, 26));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Depor&T");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        copyright.setFont(new java.awt.Font("Adwaita Sans", 0, 14)); // NOI18N
        copyright.setForeground(new java.awt.Color(102, 102, 102));
        copyright.setText("copyright © Depor&T all rights reserved");

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

        dragBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/drag.png"))); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(135, 135, 135))
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(titulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(leftLayout.createSequentialGroup()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(copyright)
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(leftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dragBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitBtn)))
                .addContainerGap())
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitBtn)
                    .addComponent(dragBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(copyright)
                .addGap(20, 20, 20))
        );

        getContentPane().add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        accountInfo.setBackground(new java.awt.Color(230, 230, 230));
        accountInfo.setForeground(new java.awt.Color(244, 244, 244));
        accountInfo.setPreferredSize(new java.awt.Dimension(400, 0));

        haveAccount.setForeground(new java.awt.Color(102, 102, 102));
        haveAccount.setText("I do not have an account");

        signBtn.setBackground(new java.awt.Color(108, 117, 125));
        signBtn.setText("Sign Up");
        signBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        signBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signBtn.setFocusPainted(false);
        signBtn.setFocusable(false);
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
                .addComponent(haveAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(signBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        accountInfoLayout.setVerticalGroup(
            accountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(accountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(haveAccount)
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
        if (haveAccount.getText().equals("I do not have an account")) {
            haveAccount.setText("I do have an account");
            signBtn.setText("Sign In");
            showPanel(new SignUp(this));
        } else {
            haveAccount.setText("I do not have an account");
            signBtn.setText("Sign Up");
            showPanel(new SignIn(this));
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
    private javax.swing.JLabel copyright;
    private javax.swing.JButton dragBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel haveAccount;
    private javax.swing.JPanel left;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelContentRight;
    private javax.swing.JButton signBtn;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
