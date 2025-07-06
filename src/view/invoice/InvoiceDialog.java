package view.invoice;

import controller.InvoiceController;
import controller.ParentController;
import controller.RoutineController;
import dao.invoiceRoutine.InvoiceRoutineDAO;
import dao.invoiceRoutine.InvoiceRoutineDAOImpl;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Invoice;
import model.Parent;
import model.Routine;
import util.Colors;
import util.InvoiceEnum;
import util.Validate;

public class InvoiceDialog extends javax.swing.JDialog {

    private InvoicePanel invoicePanel;
    private Invoice invoice;
    private ParentController parentController = new ParentController();
    private RoutineController routineController = new RoutineController();
    private InvoiceController invoiceController = new InvoiceController();
    private InvoiceRoutineDAO invoiceRoutineDAO = new InvoiceRoutineDAOImpl();

    private List<Parent> parents = new ArrayList<>();
    private List<Routine> routines = new ArrayList<>();
    private List<Routine> selectedRoutines = new ArrayList<>();
    private Parent selectedParent;

    public InvoiceDialog(java.awt.Frame parent, InvoicePanel invoicePanel, boolean modal, Invoice invoice) {
        super(parent, modal);
        this.invoicePanel = invoicePanel;
        this.invoice = invoice;

        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(invoicePanel);

        loadParentTable();
        loadRoutineTable();

        setupParentClickListener();
        setupParentTableRenderer();

        setupRoutineClickListener();
        setupRoutineTableRenderer();

        if (invoice == null) {
            saveBtn.setText("Create");
        } else {
            saveBtn.setText("Edit");
            fillInputs();
        }
    }

    private void loadParentTable() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Name");

        parents = parentController.listParents();
        for (Parent p : parents) {
            model.addRow(new Object[]{p.getId(), p.getName() + " " + p.getLastName()});
        }

        parentsTable.setModel(model);
    }

    private void loadRoutineTable() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Description");

        routines = routineController.listRoutines();
        for (Routine r : routines) {
            model.addRow(new Object[]{r.getId(), r.getDescription()});
        }

        routinesTable.setModel(model);
        routinesTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        routinesTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    }

    private void setupParentClickListener() {
        parentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int viewRow = parentsTable.rowAtPoint(evt.getPoint());
                if (viewRow == -1) {
                    return;
                }

                int modelRow = parentsTable.convertRowIndexToModel(viewRow);
                Parent clicked = parents.get(modelRow);

                if (selectedParent != null && selectedParent.getId() == clicked.getId()) {
                    selectedParent = null;
                    parentsTable.clearSelection();
                } else {
                    selectedParent = clicked;
                    parentsTable.setRowSelectionInterval(viewRow, viewRow);
                }

                parentsTable.repaint();
            }
        });
    }

    private void setupParentTableRenderer() {
        parentsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int modelRow = table.convertRowIndexToModel(row);
                Parent p = parents.get(modelRow);

                if (selectedParent != null && selectedParent.getId() == p.getId()) {
                    c.setBackground(Colors.GUNMETAL);
                    c.setForeground(java.awt.Color.WHITE);
                } else {
                    c.setBackground(Colors.WHITE);
                    c.setForeground(Colors.BLACK);
                }
                return c;
            }
        });
    }

    private void setupRoutineTableRenderer() {
        routinesTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int modelRow = table.convertRowIndexToModel(row);
                Routine r = routines.get(modelRow);

                if (selectedRoutines.contains(r)) {
                    c.setBackground(Colors.GUNMETAL);
                    c.setForeground(java.awt.Color.WHITE);
                } else {
                    c.setBackground(Colors.WHITE);
                    c.setForeground(Colors.BLACK);
                }
                return c;
            }
        });
    }

    private void setupRoutineClickListener() {
        routinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int viewRow = routinesTable.rowAtPoint(evt.getPoint());
                if (viewRow == -1) {
                    return;
                }

                int modelRow = routinesTable.convertRowIndexToModel(viewRow);
                Routine a = routines.get(modelRow);

                if (selectedRoutines.contains(a)) {
                    selectedRoutines.remove(a);
                    routinesTable.removeRowSelectionInterval(viewRow, viewRow);
                } else {
                    selectedRoutines.add(a);
                    routinesTable.addRowSelectionInterval(viewRow, viewRow);
                }

                routinesTable.repaint();
            }
        });
    }

    private void createInvoice() {
        String total = inputTotal.getText().trim();

        boolean isValid = Validate.validateInvoice(
                this,
                selectedParent,
                selectedRoutines,
                total
        );

        if (isValid) {

            Invoice invoiceAux = new Invoice(
                    selectedParent.getId(),
                    Double.parseDouble(total),
                    InvoiceEnum.PENDING,
                    true,
                    LocalDateTime.now()
            );

            List<Integer> routinesIds = new ArrayList<>();

            for (int i = 0; i < selectedRoutines.size(); i++) {
                routinesIds.add(selectedRoutines.get(i).getId());
            }

            int invoiceId = invoiceController.registerInvoice(invoiceAux, routinesIds);
            if (invoiceId != -1) {
                invoicePanel.loadTable();
                JOptionPane.showMessageDialog(this, "Invoice created.", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "There was an error, try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.dispose();
        }
    }

    private void updateInvoice() {

    }

    private void fillInputs() {
        inputTotal.setText(String.valueOf(invoice.getTotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        routinesTable = new javax.swing.JTable();
        clientTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        parentsTable = new javax.swing.JTable();
        routineTitle = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        inputTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancelBtn.setBackground(new java.awt.Color(191, 26, 47));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorderPainted(false);
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setFocusPainted(false);
        cancelBtn.setFocusable(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit24.png"))); // NOI18N
        saveBtn.setBorderPainted(false);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.setFocusPainted(false);
        saveBtn.setFocusable(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        closeBtn.setBorderPainted(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBtn.setFocusPainted(false);
        closeBtn.setFocusable(false);
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/data.png"))); // NOI18N
        titleLabel.setText("Invoice Data");

        routinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        routinesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(routinesTable);

        clientTitle.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        clientTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/parents24.png"))); // NOI18N
        clientTitle.setText("Select Client");

        parentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        parentsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(parentsTable);

        routineTitle.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        routineTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/routines24.png"))); // NOI18N
        routineTitle.setText("Select Routine");

        totalLabel.setText("Total $:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(clientTitle)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(routineTitle)
                                .addGap(127, 127, 127))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(totalLabel)
                                .addGap(18, 18, 18)
                                .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(titleLabel)
                            .addComponent(cancelBtn))
                        .addGap(620, 620, 620)
                        .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLabel))
                        .addGap(45, 45, 45)
                        .addComponent(clientTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(routineTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (invoice == null) {
            //inputDescription.setText("");
            //inputDuration.setText("");
        } else {
            //fillInputs();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (invoice == null) {
            createInvoice();
        } else {
            updateInvoice();
        }
    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel clientTitle;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextField inputTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable parentsTable;
    private javax.swing.JLabel routineTitle;
    private javax.swing.JTable routinesTable;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
