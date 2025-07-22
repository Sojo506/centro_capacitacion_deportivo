package view.checkout;

import controller.InvoiceController;
import controller.ParentController;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Invoice;
import model.Parent;
import model.Routine;
import util.InvoiceEnum;
import view.MainView;

public class CheckoutClientPanel extends javax.swing.JPanel {

    private MainView mainFrame;
    private List<Invoice> invoices;
    private InvoiceController invoiceController;
    private ParentController parentController;

    public CheckoutClientPanel(MainView mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        invoices = new ArrayList<>();
        invoiceController = new InvoiceController();
        parentController = new ParentController();

        ButtonGroup group = new ButtonGroup();
        group.add(radioBtnAll);
        group.add(radioBtnPending);
        group.add(radioBtnPaid);
        radioBtnAll.setSelected(true);

        loadTable();

    }

    public void loadTable() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Client");
        model.addColumn("Total $");
        model.addColumn("Status");
        model.addColumn("Created At");

        checkoutTable.setModel(model);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d HH:mm");

        try {

            if (radioBtnPending.isSelected()) {
                invoices = invoiceController.listPendingInvoices();
            } else if (radioBtnPaid.isSelected()) {
                invoices = invoiceController.listPaidInvoices();
            } else {
                invoices = invoiceController.listAllInvoices();
            }

            for (Invoice i : invoices) {
                //List<Routine> routines = invoiceRoutineDAO.getByInvoiceId(i.getId());

                /*
                String routineIds = routines.stream()
                        .map(r -> String.valueOf(r.getId()))
                        .reduce((a, b) -> a + " | " + b)
                        .orElse("None");*/
                String dateFormatted = i.getCreatedAt().format(formatter);
                Parent parent = parentController.getParentById(i.getParentId());

                model.addRow(new Object[]{
                    i.getId(),
                    parent.getName(),
                    //routineIds,
                    i.getTotal(),
                    i.getStatus(),
                    dateFormatted
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There was an error.", "404", JOptionPane.ERROR_MESSAGE);
        }

        disableBtns();
    }

    public void disableBtns() {
        paidBtn.setEnabled(false);
        pendingBtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkoutTable = new javax.swing.JTable();
        paidBtn = new javax.swing.JButton();
        pendingBtn = new javax.swing.JButton();
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

        title.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pay.png"))); // NOI18N
        title.setText("Manage Checkout");

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

        paidBtn.setBackground(new java.awt.Color(235, 87, 87));
        paidBtn.setForeground(new java.awt.Color(0, 0, 0));
        paidBtn.setText("PAID");
        paidBtn.setBorderPainted(false);
        paidBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paidBtn.setEnabled(false);
        paidBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidBtnActionPerformed(evt);
            }
        });

        pendingBtn.setBackground(new java.awt.Color(111, 207, 151));
        pendingBtn.setForeground(new java.awt.Color(0, 0, 0));
        pendingBtn.setText("PENDING");
        pendingBtn.setBorderPainted(false);
        pendingBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pendingBtn.setEnabled(false);
        pendingBtn.setFocusPainted(false);
        pendingBtn.setFocusable(false);
        pendingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingBtnActionPerformed(evt);
            }
        });

        radioBtnPending.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnPending.setText("Show pending");
        radioBtnPending.setFocusPainted(false);
        radioBtnPending.setFocusable(false);
        radioBtnPending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPendingActionPerformed(evt);
            }
        });

        radioBtnPaid.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnPaid.setText("Show paid");
        radioBtnPaid.setFocusPainted(false);
        radioBtnPaid.setFocusable(false);
        radioBtnPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPaidActionPerformed(evt);
            }
        });

        radioBtnAll.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnAll.setText("Show all");
        radioBtnAll.setFocusPainted(false);
        radioBtnAll.setFocusable(false);
        radioBtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnAllActionPerformed(evt);
            }
        });

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
                        .addComponent(title)
                        .addGap(174, 174, 174))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioBtnPending)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(refreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paidBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pendingBtn)
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
                        .addComponent(title)
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
                                    .addComponent(pendingBtn)
                                    .addComponent(paidBtn))
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void checkoutTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutTableMouseClicked
        int selectedRow = checkoutTable.getSelectedRow();
        if (selectedRow != -1) {
            String estado = checkoutTable.getValueAt(selectedRow, 3).toString();

            if (estado.equals("PENDING")) {
                paidBtn.setEnabled(true);
                pendingBtn.setEnabled(false);
            } else if (estado.equals("PAID")) {
                paidBtn.setEnabled(false);
                pendingBtn.setEnabled(true);
            } else {
                paidBtn.setEnabled(false);
                pendingBtn.setEnabled(false);
            }
        }
    }//GEN-LAST:event_checkoutTableMouseClicked

    private void paidBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidBtnActionPerformed
        int row = checkoutTable.getSelectedRow();

        if (row != -1) {
            int invoiceId = Integer.parseInt(checkoutTable.getValueAt(row, 0).toString());
            int confirm = JOptionPane.showConfirmDialog(CheckoutClientPanel.this,
                    "Do you want to mark this invoice as PAID?",
                    "Confirm Payment",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = invoiceController.updateStatus(invoiceId, InvoiceEnum.PAID);

                if (success) {
                    JOptionPane.showMessageDialog(CheckoutClientPanel.this, "Invoice marked as paid successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadTable();
                    paidBtn.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(CheckoutClientPanel.this, "Error updating invoice status.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_paidBtnActionPerformed

    private void pendingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingBtnActionPerformed
        int row = checkoutTable.getSelectedRow();

        if (row != -1) {
            int invoiceId = Integer.parseInt(checkoutTable.getValueAt(row, 0).toString());
            int confirm = JOptionPane.showConfirmDialog(CheckoutClientPanel.this,
                    "Do you want to mark this invoice as PENDING?",
                    "Confirm Reversal",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = invoiceController.updateStatus(invoiceId, InvoiceEnum.PENDING);

                if (success) {
                    JOptionPane.showMessageDialog(CheckoutClientPanel.this, "Invoice marked as pending successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadTable();
                    pendingBtn.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(CheckoutClientPanel.this, "Error updating invoice status.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_pendingBtnActionPerformed

    private void radioBtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnAllActionPerformed
        loadTable();
    }//GEN-LAST:event_radioBtnAllActionPerformed

    private void radioBtnPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPaidActionPerformed
        loadTable();
    }//GEN-LAST:event_radioBtnPaidActionPerformed

    private void radioBtnPendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPendingActionPerformed
        loadTable();
    }//GEN-LAST:event_radioBtnPendingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable checkoutTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton paidBtn;
    private javax.swing.JButton pendingBtn;
    private javax.swing.JRadioButton radioBtnAll;
    private javax.swing.JRadioButton radioBtnPaid;
    private javax.swing.JRadioButton radioBtnPending;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
