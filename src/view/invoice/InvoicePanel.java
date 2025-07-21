package view.invoice;

import controller.InvoiceController;
import dao.invoiceRoutine.InvoiceRoutineDAO;
import dao.invoiceRoutine.InvoiceRoutineDAOImpl;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Invoice;
import model.Routine;
import view.MainView;

public class InvoicePanel extends javax.swing.JPanel {

    private MainView mainFrame;
    private List<Invoice> invoices;
    private InvoiceController invoiceController;
    private InvoiceRoutineDAO invoiceRoutineDAO;

    public InvoicePanel(MainView mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        invoices = new ArrayList<>();
        invoiceController = new InvoiceController();
        invoiceRoutineDAO = new InvoiceRoutineDAOImpl();

        loadTable();
        disableEditDeleteBtn();
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
        model.addColumn("Routines");
        model.addColumn("Total $");
        model.addColumn("Status");
        model.addColumn("Created At");

        invoicesTable.setModel(model);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d HH:mm");

        try {
            var orderType = orderBtn.getText();

            if (orderType.equals("Order by Desc")) {
                invoices = invoiceController.listInvoicesDesc();
            } else {
                invoices = invoiceController.listInvoicesAsc();
            }

            for (Invoice i : invoices) {
                List<Routine> routines = invoiceRoutineDAO.getByInvoiceId(i.getId());

                String routineIds = routines.stream()
                        .map(r -> String.valueOf(r.getId()))
                        .reduce((a, b) -> a + " | " + b)
                        .orElse("None");

                String dateFormatted = i.getCreatedAt().format(formatter);

                model.addRow(new Object[]{
                    i.getId(),
                    i.getParentId(),
                    routineIds,
                    i.getTotal(),
                    i.getStatus(),
                    dateFormatted
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There was an error.", "404", JOptionPane.ERROR_MESSAGE);
        }

        disableEditDeleteBtn();
    }

    public void disableEditDeleteBtn() {
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicesTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        orderBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(74, 74, 72));

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invoice.png"))); // NOI18N
        jLabel1.setText("Manage Invoices");

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoicesTable.getTableHeader().setReorderingAllowed(false);
        invoicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoicesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invoicesTable);

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

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        addBtn.setBorderPainted(false);
        addBtn.setContentAreaFilled(false);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.setFocusPainted(false);
        addBtn.setFocusable(false);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit32.png"))); // NOI18N
        editBtn.setBorderPainted(false);
        editBtn.setContentAreaFilled(false);
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.setFocusPainted(false);
        editBtn.setFocusable(false);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete32.png"))); // NOI18N
        deleteBtn.setBorderPainted(false);
        deleteBtn.setContentAreaFilled(false);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.setFocusPainted(false);
        deleteBtn.setFocusable(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        orderBtn.setBackground(new java.awt.Color(45, 49, 66));
        orderBtn.setForeground(new java.awt.Color(255, 255, 255));
        orderBtn.setText("Order by Desc");
        orderBtn.setBorderPainted(false);
        orderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderBtn.setFocusPainted(false);
        orderBtn.setFocusable(false);
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(orderBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(refreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editBtn)
                            .addComponent(deleteBtn)
                            .addComponent(addBtn)
                            .addComponent(refreshBtn)
                            .addComponent(orderBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void invoicesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoicesTableMouseClicked
        int selectedRow = invoicesTable.getSelectedRow();
        if (selectedRow != -1) {
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }//GEN-LAST:event_invoicesTableMouseClicked

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        InvoiceDialog invoiceDialog = new InvoiceDialog(mainFrame, this, true, null);
        invoiceDialog.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = invoicesTable.getSelectedRow();
        if (row < 0) {
            return;
        }

        int id = (int) invoicesTable.getValueAt(row, 0);
        Invoice athlete = invoiceController.getInvoiceById(id);
        InvoiceDialog invoiceDialog = new InvoiceDialog(mainFrame, this, true, athlete);
        invoiceDialog.setVisible(true);
        disableEditDeleteBtn();

    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = invoicesTable.getSelectedRow();

        if (row < 0) {
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "Do you wish to delete this invoice?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        int id = (int) invoicesTable.getValueAt(row, 0);

        try {
            boolean success = invoiceController.deactivateInvoice(id);

            if (success) {
                JOptionPane.showMessageDialog(this, "Invoice deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTable();
            } else {
                JOptionPane.showMessageDialog(this, "Could not delete the invoice.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        var orderType = orderBtn.getText();

        if (orderType.equals("Order by Desc")) {
            orderBtn.setText("Order by Asc");
        } else {
            orderBtn.setText("Order by Desc");
        }

        loadTable();
    }//GEN-LAST:event_orderBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}
