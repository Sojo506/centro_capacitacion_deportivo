package view.panel;

import javax.swing.SwingUtilities;
import view.MainFrame;
import view.login.LoginFrame;

public class SidebarPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private LoginFrame loginFrame;

    public SidebarPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        usersBtn = new javax.swing.JButton();
        manageLabel = new javax.swing.JLabel();
        athletesBtn = new javax.swing.JButton();
        parentsBtn = new javax.swing.JButton();
        sportsBtn = new javax.swing.JButton();
        routinesBtn = new javax.swing.JButton();
        invoicesBtn = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        settingsLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(230, 230, 230));
        setPreferredSize(new java.awt.Dimension(200, 700));

        logoutBtn.setBackground(new java.awt.Color(74, 74, 72));
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Log out");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(191, 26, 47));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("Exit");
        exitBtn.setBorderPainted(false);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.setFocusPainted(false);
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        usersBtn.setBackground(new java.awt.Color(38, 103, 255));
        usersBtn.setForeground(new java.awt.Color(255, 255, 255));
        usersBtn.setText("Users");
        usersBtn.setBorderPainted(false);
        usersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersBtn.setFocusPainted(false);
        usersBtn.setFocusable(false);
        usersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersBtnActionPerformed(evt);
            }
        });

        manageLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 18)); // NOI18N
        manageLabel.setForeground(new java.awt.Color(26, 26, 26));
        manageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/manage.png"))); // NOI18N
        manageLabel.setText("Manage");

        athletesBtn.setBackground(new java.awt.Color(38, 103, 255));
        athletesBtn.setForeground(new java.awt.Color(255, 255, 255));
        athletesBtn.setText("Athletes");
        athletesBtn.setBorderPainted(false);
        athletesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        athletesBtn.setFocusPainted(false);
        athletesBtn.setFocusable(false);

        parentsBtn.setBackground(new java.awt.Color(38, 103, 255));
        parentsBtn.setForeground(new java.awt.Color(255, 255, 255));
        parentsBtn.setText("Parents");
        parentsBtn.setBorderPainted(false);
        parentsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parentsBtn.setFocusPainted(false);
        parentsBtn.setFocusable(false);

        sportsBtn.setBackground(new java.awt.Color(38, 103, 255));
        sportsBtn.setForeground(new java.awt.Color(255, 255, 255));
        sportsBtn.setText("Sports");
        sportsBtn.setBorderPainted(false);
        sportsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sportsBtn.setFocusPainted(false);
        sportsBtn.setFocusable(false);

        routinesBtn.setBackground(new java.awt.Color(38, 103, 255));
        routinesBtn.setForeground(new java.awt.Color(255, 255, 255));
        routinesBtn.setText("Routines");
        routinesBtn.setBorderPainted(false);
        routinesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        routinesBtn.setFocusPainted(false);
        routinesBtn.setFocusable(false);

        invoicesBtn.setBackground(new java.awt.Color(38, 103, 255));
        invoicesBtn.setForeground(new java.awt.Color(255, 255, 255));
        invoicesBtn.setText("Invoices");
        invoicesBtn.setBorderPainted(false);
        invoicesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invoicesBtn.setFocusPainted(false);
        invoicesBtn.setFocusable(false);

        titulo.setFont(new java.awt.Font("Adwaita Mono", 1, 34)); // NOI18N
        titulo.setForeground(new java.awt.Color(26, 26, 26));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Depor&T");

        settingsLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 18)); // NOI18N
        settingsLabel.setForeground(new java.awt.Color(26, 26, 26));
        settingsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        settingsLabel.setText("Settings");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageLabel)
                            .addComponent(settingsLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(usersBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(athletesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parentsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sportsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(routinesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoicesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titulo)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(titulo)
                .addGap(70, 70, 70)
                .addComponent(manageLabel)
                .addGap(18, 18, 18)
                .addComponent(usersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(athletesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(parentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(routinesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invoicesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(settingsLabel)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        loginFrame = new LoginFrame();
        mainFrame.dispose();
        loginFrame.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void usersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usersBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton athletesBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton invoicesBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel manageLabel;
    private javax.swing.JButton parentsBtn;
    private javax.swing.JButton routinesBtn;
    private javax.swing.JLabel settingsLabel;
    private javax.swing.JButton sportsBtn;
    private javax.swing.JLabel titulo;
    private javax.swing.JButton usersBtn;
    // End of variables declaration//GEN-END:variables
}
