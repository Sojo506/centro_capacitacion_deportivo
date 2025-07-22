package view.checkout;

import controller.InvoiceController;
import controller.ParentController;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Invoice;
import model.Parent;
import util.InvoiceEnum;

public class CheckoutServerPanel extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CheckoutServerPanel.class.getName());
    private List<Invoice> invoices;
    private InvoiceController invoiceController;
    private ParentController parentController;
    
    public CheckoutServerPanel() {
        initComponents();
        invoices = new ArrayList<>();
        invoiceController = new InvoiceController();
        parentController = new ParentController();
        startSocketServer();
        setResizable(false);
        setLocationRelativeTo(null);
        loadTable();
        
    }
    
    private void loadTable() {
        DefaultTableModel model = getDefaultTableModel();
        checkoutTable.setModel(model);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d HH:mm");
        double total = 0;
        
        try {
            var orderType = orderBtn.getText();
            
            if (orderType.equals("Order by Desc")) {
                invoices = invoiceController.listInvoicesDesc().stream()
                        .filter(i -> i.getStatus() == InvoiceEnum.PAID)
                        .collect(Collectors.toList());
            } else {
                invoices = invoiceController.listInvoicesAsc().stream()
                        .filter(i -> i.getStatus() == InvoiceEnum.PAID)
                        .collect(Collectors.toList());
            }
            
            for (Invoice i : invoices) {
                String dateFormatted = i.getCreatedAt().format(formatter);
                Parent parent = parentController.getParentById(i.getParentId());
                
                model.addRow(new Object[]{
                    i.getId(),
                    parent.getName() + " " + parent.getLastName(),
                    i.getTotal(),
                    i.getStatus(),
                    dateFormatted
                });
                total += i.getTotal();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There was an error loading table.", "404", JOptionPane.ERROR_MESSAGE);
        }
        
        totalLabel.setText("Total of the invoices: $" + String.format("%.2f", total));
    }
    
    private void addInvoiceToTable(Invoice invoice) {
        try {
            DefaultTableModel model = (DefaultTableModel) checkoutTable.getModel();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d HH:mm");
            Parent parent = parentController.getParentById(invoice.getParentId());
            
            model.addRow(new Object[]{
                invoice.getId(),
                parent.getName() + " " + parent.getLastName(),
                invoice.getTotal(),
                invoice.getStatus(),
                invoice.getCreatedAt().format(formatter)
            });
            
            double total = 0;
            
            for (int i = 0; i < model.getRowCount(); i++) {
                total += Double.parseDouble(model.getValueAt(i, 2).toString());
            }
            
            totalLabel.setText("Total of the invoices: $" + String.format("%.2f", total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding invoice to table: " + e.getMessage(), "Display Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private DefaultTableModel getDefaultTableModel() {
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
        
        return model;
    }
    
    private void startSocketServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(5000)) {
                System.out.println("Server listening on port 5000...");
                
                while (true) {
                    Socket socket = serverSocket.accept();
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    
                    Invoice invoice = (Invoice) in.readObject();
                    invoices.add(invoice);

                    SwingUtilities.invokeLater(() -> addInvoiceToTable(invoice));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Socket error: " + e.getMessage(), "Server Error", JOptionPane.ERROR_MESSAGE);
            }
        }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        checkoutTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        orderBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        totalLabel.setFont(new java.awt.Font("Adwaita Sans", 0, 16)); // NOI18N
        totalLabel.setText("Total");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(orderBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(title)
                        .addGap(303, 303, 303)))
                .addComponent(refreshBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalLabel)
                            .addComponent(title))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(orderBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkoutTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkoutTableMouseClicked

    }//GEN-LAST:event_checkoutTableMouseClicked

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        var orderType = orderBtn.getText();
        
        if (orderType.equals("Order by Desc")) {
            orderBtn.setText("Order by Asc");
        } else {
            orderBtn.setText("Order by Desc");
        }
        
        loadTable();
    }//GEN-LAST:event_orderBtnActionPerformed
    
    public static void main(String args[]) {
        
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
        java.awt.EventQueue.invokeLater(() -> new CheckoutServerPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable checkoutTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables

}
