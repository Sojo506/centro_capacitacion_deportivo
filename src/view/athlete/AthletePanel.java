package view.athlete;

import controller.AthleteController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Athlete;
import view.MainFrame;

public class AthletePanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private List<Athlete> athletes;
    private AthleteController athleteController = new AthleteController();

    public AthletePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        athletes = new ArrayList<>();

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

        athletesTable.setModel(model);

        try {
            athletes = athleteController.listAthletes();

            for (Athlete a : athletes) {
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
        athletesTable = new javax.swing.JTable();
        titleLabel = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(74, 74, 72));

        athletesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        athletesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                athletesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(athletesTable);

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/athletes.png"))); // NOI18N
        titleLabel.setText("Manage Athletes");

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
                .addContainerGap(358, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(358, 358, 358))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(refreshBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addContainerGap())))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void athletesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_athletesTableMouseClicked
        int selectedRow = athletesTable.getSelectedRow();
        if (selectedRow != -1) {
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }//GEN-LAST:event_athletesTableMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = athletesTable.getSelectedRow();
        if (row >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to delete this athlete?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                int id = (int) athletesTable.getValueAt(row, 0);
                athleteController.deactivateAthlete(id);
                loadTable();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = athletesTable.getSelectedRow();
        if (row != -1) {
            int id = (int) athletesTable.getValueAt(row, 0);
            Athlete athlete = athleteController.getAthleteById(id);
            AthleteCardDialog athleteCardDialog = new AthleteCardDialog(mainFrame, this, true, athlete);
            athleteCardDialog.setVisible(true);
            disableEditDeleteBtn();
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        AthleteCardDialog athleteCardDialog = new AthleteCardDialog(mainFrame, this, true, null);
        athleteCardDialog.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable athletesTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
