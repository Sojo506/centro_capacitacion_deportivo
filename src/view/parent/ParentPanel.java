package view.parent;

import controller.AthleteController;
import controller.ParentController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Athlete;
import model.Parent;
import view.MainFrame;

public class ParentPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private List<Parent> parents;
    private ParentController parentController = new ParentController();
    private AthleteController athleteController = new AthleteController();

    public ParentPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        parents = new ArrayList<>();

        loadTable();
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }

    public void loadTable() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Last name");
        model.addColumn("City");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Email");

        parentsTable.setModel(model);

        try {
            parents = parentController.listParents();

            for (Parent a : parents) {
                model.addRow(new Object[]{
                    a.getId(),
                    a.getName(),
                    a.getLastName(),
                    a.getCity(),
                    a.getAddress(),
                    a.getPhone(),
                    a.getEmail()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        parentsTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(74, 74, 72));

        parentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        parentsTable.getTableHeader().setReorderingAllowed(false);
        parentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(parentsTable);

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/parents.png"))); // NOI18N
        titleLabel.setText("Manage Parents");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(182, 182, 182)
                .addComponent(refreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void parentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parentsTableMouseClicked
        int selectedRow = parentsTable.getSelectedRow();
        if (selectedRow != -1) {
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }//GEN-LAST:event_parentsTableMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = parentsTable.getSelectedRow();
        if (row != -1) {
            int id = (int) parentsTable.getValueAt(row, 0);
            Parent athlete = parentController.getParentById(id);
            ParentDialog parentDialog = new ParentDialog(mainFrame, this, true, athlete);
            parentDialog.setVisible(true);
            disableEditDeleteBtn();
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = parentsTable.getSelectedRow();
        if (row >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to delete this athlete?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                int id = (int) parentsTable.getValueAt(row, 0);
                List<Athlete> athletes = athleteController.getByParentId(id);

                if (athletes.size() > 0) {
                    for (Athlete a : athletes) {
                        a.setParentId(null);
                        athleteController.updateAthlete(a);
                    }
                }

                parentController.deactivateParent(id);
                JOptionPane.showMessageDialog(this, "Parent deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadTable();

            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        ParentDialog parentDialog = new ParentDialog(mainFrame, this, true, null);
        parentDialog.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable parentsTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
