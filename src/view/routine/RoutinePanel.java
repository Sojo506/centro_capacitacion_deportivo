package view.routine;

import controller.RoutineController;
import dao.routineSport.RoutineSportDAO;
import dao.routineSport.RoutineSportDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Routine;
import model.Sport;
import view.MainFrame;

public class RoutinePanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private List<Routine> routines;
    private RoutineController routineController = new RoutineController();
    private RoutineSportDAO routineSportDAO;

    public RoutinePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        routines = new ArrayList<>();
        routineSportDAO = new RoutineSportDAOImpl();

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
        model.addColumn("Description");
        model.addColumn("Duration in minutes");
        model.addColumn("Sports");

        routinesTable.setModel(model);

        try {
            routines = routineController.listRoutines();

            for (Routine r : routines) {
                List<Sport> sports = routineSportDAO.getSportsByRoutineId(r.getId());

                String sportNames = sports.stream()
                        .map(Sport::getName)
                        .reduce((a, b) -> a + " | " + b)
                        .orElse("None");

                model.addRow(new Object[]{
                    r.getId(),
                    r.getDescription(),
                    r.getDurationMinutes(),
                    sportNames
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There was an error.", "404", JOptionPane.ERROR_MESSAGE);
        }

        routinesTable.getColumnModel().getColumn(1).setPreferredWidth(400);

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
        routinesTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(74, 74, 72));

        routinesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        routinesTable.getTableHeader().setReorderingAllowed(false);
        routinesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                routinesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(routinesTable);

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

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 1, 26)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/routines.png"))); // NOI18N
        jLabel1.setText("Manage Routines");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(170, 170, 170)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editBtn)
                            .addComponent(deleteBtn)
                            .addComponent(addBtn)
                            .addComponent(refreshBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void routinesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_routinesTableMouseClicked
        int selectedRow = routinesTable.getSelectedRow();
        if (selectedRow != -1) {
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        }
    }//GEN-LAST:event_routinesTableMouseClicked

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        loadTable();
        JOptionPane.showMessageDialog(this, "Data refreshed.", "202", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        RoutineDialog routineDialog = new RoutineDialog(mainFrame, this, true, null);
        routineDialog.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int row = routinesTable.getSelectedRow();
        if (row != -1) {
            int id = (int) routinesTable.getValueAt(row, 0);
            Routine athlete = routineController.getRoutineById(id);
            RoutineDialog athleteDialog = new RoutineDialog(mainFrame, this, true, athlete);
            athleteDialog.setVisible(true);
            disableEditDeleteBtn();
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = routinesTable.getSelectedRow();

        if (row < 0) {
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to delete this routine?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) routinesTable.getValueAt(row, 0);
            List<Sport> sports = routineSportDAO.getSportsByRoutineId(id);

            if (sports.size() > 0) {
                routineSportDAO.unlinkAllByRoutine(id);
            } else {
                System.out.println("no tiene conexiones");
            }

            routineController.deactivateRoutine(id);
            JOptionPane.showMessageDialog(this, "Routine deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadTable();

        }

    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTable routinesTable;
    // End of variables declaration//GEN-END:variables
}
