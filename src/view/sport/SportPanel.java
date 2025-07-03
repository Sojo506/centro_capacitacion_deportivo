package view.sport;

import controller.SportController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Sport;
import view.MainFrame;

public class SportPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private List<Sport> sports;
    private SportController sportController;

    public SportPanel(MainFrame mainFrame) {
        initComponents();
        sportController = new SportController();
        sports = new ArrayList<>();

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
        model.addColumn("Characteristics");

        sportsTable.setModel(model);

        try {
            sports = sportController.listSports();

            for (Sport a : sports) {
                model.addRow(new Object[]{
                    a.getId(),
                    a.getName(),
                    a.getCharacteristics(),});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There was an error.", "404", JOptionPane.ERROR_MESSAGE);
        }

        sportsTable.getColumnModel().getColumn(2).setPreferredWidth(600);

        disableEditDeleteBtn();
    }

    public void disableEditDeleteBtn() {
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titileLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sportsTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(74, 74, 72));

        titileLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        titileLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sports.png"))); // NOI18N
        titileLabel.setText("Manage Sports");

        sportsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        sportsTable.getTableHeader().setReorderingAllowed(false);
        sportsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sportsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sportsTable);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(titileLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(refreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(titileLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(refreshBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        SportDialog sportDialog = new SportDialog(mainFrame, this, true, null);
        sportDialog.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = sportsTable.getSelectedRow();
        if (row != -1) {
            int id = (int) sportsTable.getValueAt(row, 0);
            Sport sport = sportController.getSportById(id);
            SportDialog sportDialog = new SportDialog(mainFrame, this, true, sport);
            sportDialog.setVisible(true);
            disableEditDeleteBtn();
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = sportsTable.getSelectedRow();
        if (row >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to delete this sport?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                int id = (int) sportsTable.getValueAt(row, 0);
                Sport a = sportController.getSportById(id);
                System.out.println(a.getRoutineId());
                boolean canDelete = true;

                if (a.getRoutineId() != 0) {
                    canDelete = false;
                }

                if (canDelete) {
                    sportController.deactivateSport(id);
                    JOptionPane.showMessageDialog(this, "Sport deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(this, "You can't delete this sport because is associated with a routine.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void sportsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sportsTableMouseClicked
        int selectedRow = sportsTable.getSelectedRow();
        if (selectedRow != -1) {
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }//GEN-LAST:event_sportsTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTable sportsTable;
    private javax.swing.JLabel titileLabel;
    // End of variables declaration//GEN-END:variables
}
