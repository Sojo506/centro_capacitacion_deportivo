package view.panel;

import java.time.LocalDate;
import javax.swing.SwingUtilities;
import model.User;
import view.MainFrame;

public class NavbarPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;

    public NavbarPanel(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        User user = mainFrame.getUser();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(368, 368, 368)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
