package view.panel;

import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import util.Colors;
import view.MainView;
import view.athlete.AthletePanel;
import view.checkout.CheckoutClientPanel;
import view.invoice.InvoicePanel;
import view.login.LoginFrame;
import view.parent.ParentPanel;
import view.routine.RoutinePanel;
import view.sport.SportPanel;

public class SidebarPanel extends javax.swing.JPanel {

    private MainView mainFrame;
    private LoginFrame loginFrame;
    private List<JButton> sectionBtns;

    public SidebarPanel(MainView mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        sectionBtns = Arrays.asList(athletesBtn, parentsBtn, sportsBtn, routinesBtn, invoicesBtn);
        setActiveButton(athletesBtn);
    }

    private void setActiveButton(JButton activeBtn) {
        for (JButton btn : sectionBtns) {
            if (btn == activeBtn) {
                btn.setBackground(Colors.GUNMETAL);
            } else {
                btn.setBackground(Colors.BACKGROUND_PRIMARY);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        manageLabel = new javax.swing.JLabel();
        athletesBtn = new javax.swing.JButton();
        parentsBtn = new javax.swing.JButton();
        sportsBtn = new javax.swing.JButton();
        routinesBtn = new javax.swing.JButton();
        invoicesBtn = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        settingsLabel = new javax.swing.JLabel();
        checkoutBtn = new javax.swing.JButton();

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
        athletesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                athletesBtnActionPerformed(evt);
            }
        });

        parentsBtn.setBackground(new java.awt.Color(38, 103, 255));
        parentsBtn.setForeground(new java.awt.Color(255, 255, 255));
        parentsBtn.setText("Parents");
        parentsBtn.setBorderPainted(false);
        parentsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        parentsBtn.setFocusPainted(false);
        parentsBtn.setFocusable(false);
        parentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parentsBtnActionPerformed(evt);
            }
        });

        sportsBtn.setBackground(new java.awt.Color(38, 103, 255));
        sportsBtn.setForeground(new java.awt.Color(255, 255, 255));
        sportsBtn.setText("Sports");
        sportsBtn.setBorderPainted(false);
        sportsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sportsBtn.setFocusPainted(false);
        sportsBtn.setFocusable(false);
        sportsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsBtnActionPerformed(evt);
            }
        });

        routinesBtn.setBackground(new java.awt.Color(38, 103, 255));
        routinesBtn.setForeground(new java.awt.Color(255, 255, 255));
        routinesBtn.setText("Routines");
        routinesBtn.setBorderPainted(false);
        routinesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        routinesBtn.setFocusPainted(false);
        routinesBtn.setFocusable(false);
        routinesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routinesBtnActionPerformed(evt);
            }
        });

        invoicesBtn.setBackground(new java.awt.Color(38, 103, 255));
        invoicesBtn.setForeground(new java.awt.Color(255, 255, 255));
        invoicesBtn.setText("Invoices");
        invoicesBtn.setBorderPainted(false);
        invoicesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invoicesBtn.setFocusPainted(false);
        invoicesBtn.setFocusable(false);
        invoicesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesBtnActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Adwaita Mono", 1, 34)); // NOI18N
        titulo.setForeground(new java.awt.Color(26, 26, 26));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Depor&T");

        settingsLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 18)); // NOI18N
        settingsLabel.setForeground(new java.awt.Color(26, 26, 26));
        settingsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        settingsLabel.setText("Settings");

        checkoutBtn.setBackground(new java.awt.Color(38, 103, 255));
        checkoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        checkoutBtn.setText("Checkout");
        checkoutBtn.setBorderPainted(false);
        checkoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkoutBtn.setFocusPainted(false);
        checkoutBtn.setFocusable(false);
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(titulo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(manageLabel)))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(athletesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parentsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sportsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(routinesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invoicesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(settingsLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(checkoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(titulo)
                .addGap(52, 52, 52)
                .addComponent(manageLabel)
                .addGap(18, 18, 18)
                .addComponent(athletesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(parentsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(routinesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(invoicesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(settingsLabel)
                .addGap(24, 24, 24)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void athletesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_athletesBtnActionPerformed
        mainFrame.showPanel(new AthletePanel(mainFrame));
        setActiveButton(athletesBtn);
    }//GEN-LAST:event_athletesBtnActionPerformed

    private void parentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parentsBtnActionPerformed
        mainFrame.showPanel(new ParentPanel(mainFrame));
        setActiveButton(parentsBtn);
    }//GEN-LAST:event_parentsBtnActionPerformed

    private void sportsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsBtnActionPerformed
        mainFrame.showPanel(new SportPanel(mainFrame));
        setActiveButton(sportsBtn);
    }//GEN-LAST:event_sportsBtnActionPerformed

    private void routinesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routinesBtnActionPerformed
        mainFrame.showPanel(new RoutinePanel(mainFrame));
        setActiveButton(routinesBtn);
    }//GEN-LAST:event_routinesBtnActionPerformed

    private void invoicesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesBtnActionPerformed
        mainFrame.showPanel(new InvoicePanel(mainFrame));
        setActiveButton(invoicesBtn);
    }//GEN-LAST:event_invoicesBtnActionPerformed

    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnActionPerformed
        mainFrame.showPanel(new CheckoutClientPanel(mainFrame));
        setActiveButton(checkoutBtn);
    }//GEN-LAST:event_checkoutBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton athletesBtn;
    private javax.swing.JButton checkoutBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton invoicesBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel manageLabel;
    private javax.swing.JButton parentsBtn;
    private javax.swing.JButton routinesBtn;
    private javax.swing.JLabel settingsLabel;
    private javax.swing.JButton sportsBtn;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
