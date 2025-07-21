package view.checkout;

import javax.swing.JOptionPane;
import view.MainView;

public class CheckoutClientPanel extends javax.swing.JPanel {

    public CheckoutClientPanel(MainView mainFrame) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkoutTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        radioBtnPending = new javax.swing.JRadioButton();
        radioBtnPaid = new javax.swing.JRadioButton();
        radioBtnAll = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(74, 74, 72));

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh-data.png"))); // NOI18N
        refreshBtn.setBorderPainted(false);
        refreshBtn.setContentAreaFilled(false);
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.setFocusPainted(false);
        refreshBtn.setFocusable(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay.png"))); // NOI18N
        jLabel1.setText("Manage Checkout");

        checkoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        checkoutTable.getTableHeader().setReorderingAllowed(false);
        checkoutTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkoutTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(checkoutTable);

        jButton1.setBackground(new java.awt.Color(235, 87, 87));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("PAID");
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);

        jButton2.setBackground(new java.awt.Color(111, 207, 151));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("PENDING");
        jButton2.setBorderPainted(false);
        jButton2.setEnabled(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);

        radioBtnPending.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnPending.setText("Show pending");
        radioBtnPending.setFocusPainted(false);
        radioBtnPending.setFocusable(false);

        radioBtnPaid.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnPaid.setText("Show paid");
        radioBtnPaid.setFocusPainted(false);
        radioBtnPaid.setFocusable(false);

        radioBtnAll.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnAll.setText("Show all");
        radioBtnAll.setFocusPainted(false);
        radioBtnAll.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBtnPaid)
                            .addComponent(radioBtnAll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(174, 174, 174))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioBtnPending)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(refreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioBtnAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(refreshBtn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioBtnPaid)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioBtnPending))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton1))
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        //loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void checkoutTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutTableMouseClicked
        int selectedRow = checkoutTable.getSelectedRow();
        if (selectedRow != -1) {

        }
    }//GEN-LAST:event_checkoutTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable checkoutTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioBtnAll;
    private javax.swing.JRadioButton radioBtnPaid;
    private javax.swing.JRadioButton radioBtnPending;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}
