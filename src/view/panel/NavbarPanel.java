package view.panel;

import java.time.LocalDate;
import model.User;
import view.MainFrame;
import view.user.UserProfileDialog;

public class NavbarPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private User user;

    public NavbarPanel(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        user = mainFrame.getUser();
        userLabel.setText(user.getFullName());

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
        dateLabel.setText(+day + "/" + months[month - 1] + "/" + year);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 40));

        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        userLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addGap(367, 367, 367)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(464, 464, 464))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLabelMouseClicked
        UserProfileDialog profile = new UserProfileDialog(mainFrame, true, user);
        profile.setVisible(true);
    }//GEN-LAST:event_userLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
