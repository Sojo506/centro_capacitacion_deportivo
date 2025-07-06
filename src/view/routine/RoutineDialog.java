package view.routine;

import controller.RoutineController;
import controller.SportController;
import dao.routineSport.RoutineSportDAO;
import dao.routineSport.RoutineSportDAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Routine;
import model.Sport;
import util.Colors;
import util.Validate;

public class RoutineDialog extends javax.swing.JDialog {

    RoutinePanel routinePanel;
    RoutineController routineController;
    SportController sportController;
    Routine routine;
    private List<Sport> sports;
    private List<Sport> selectedSports;
    private RoutineSportDAO routineSportDAO;

    public RoutineDialog(java.awt.Frame parent, RoutinePanel routinePanel, boolean modal, Routine routine) {
        super(parent, modal);
        this.routinePanel = routinePanel;
        this.routine = routine;
        routineController = new RoutineController();
        sportController = new SportController();
        routineSportDAO = new RoutineSportDAOImpl();
        sports = new ArrayList<>();
        selectedSports = new ArrayList<>();

        setUndecorated(true);
        initComponents();
        inputDescription.setLineWrap(true);

        initSettings();
        setupTableRenderer();
        setupTableClickListener();

        if (routine == null) {
            saveBtn.setText("Create");
        } else {
            saveBtn.setText("Edit");
            fillInputs();
        }

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
        model.addColumn("Name");
        model.addColumn("Characteristics");

        sportsTable.setModel(model);

        sports = sportController.listSports();

        if (routine != null) {
            selectedSports = routineSportDAO.getByRoutineId(routine.getId());
        }

        for (Sport s : sports) {
            model.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getCharacteristics()
            });
        }

    }

    private void fillInputs() {
        inputDescription.setText(routine.getDescription());
        inputDuration.setText(String.valueOf(routine.getDurationMinutes()));
    }

    private void createRoutine() {
        String description = inputDescription.getText().trim();
        String duration = inputDuration.getText().trim();

        boolean isValid = Validate.validateRoutine(
                this,
                description,
                duration
        );

        if (isValid) {
            Routine verifyRoutine = routineController.getRoutineByDescription(description);

            if (verifyRoutine != null) {
                JOptionPane.showMessageDialog(this, "That routine already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Routine r = new Routine(description, Integer.parseInt(duration), true);
                int id = routineController.registerRoutine(r);

                linkRoutineToSports(id);

                routinePanel.loadTable();
                JOptionPane.showMessageDialog(this, "Routine created.", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }

    private void updateRoutine() {
        String description = inputDescription.getText().trim();
        String duration = inputDuration.getText().trim();

        boolean isValid = Validate.validateRoutine(
                this,
                description,
                duration
        );

        if (isValid) {

            boolean canUpdate = true;

            if (!routine.getDescription().equalsIgnoreCase(description)) {
                if ((routineController.getRoutineByDescription(description)) != null) {
                    JOptionPane.showMessageDialog(this, "That routine already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to update this routine?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    routine.setDescription(description);
                    routine.setDurationMinutes(Integer.parseInt(duration));

                    routineController.updateRoutine(routine);

                    updateRoutineSports(routine.getId());

                    routinePanel.loadTable();
                    JOptionPane.showMessageDialog(this, "Routine updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
    }

    private void initSettings() {
        setSize(776, 440);
        setLocationRelativeTo(routinePanel);
        sportsTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void setupTableRenderer() {
        sportsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int modelRow = table.convertRowIndexToModel(row);
                Sport s = sports.get(modelRow);

                if (selectedSports.contains(s)) {
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

    private void setupTableClickListener() {
        sportsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int viewRow = sportsTable.rowAtPoint(evt.getPoint());
                if (viewRow == -1) {
                    return;
                }

                int modelRow = sportsTable.convertRowIndexToModel(viewRow);
                Sport s = sports.get(modelRow);

                if (selectedSports.contains(s)) {
                    selectedSports.remove(s);
                    sportsTable.removeRowSelectionInterval(viewRow, viewRow);
                } else {
                    selectedSports.add(s);
                    sportsTable.addRowSelectionInterval(viewRow, viewRow);
                }

                sportsTable.repaint();
            }
        });
    }

    public void linkRoutineToSports(int id) {
        if (!selectedSports.isEmpty()) {
            routineSportDAO.add(id, selectedSports);
        }
    }

    private void updateRoutineSports(int routineId) {
        routineSportDAO.deleteByRoutineId(routineId);
        routineSportDAO.add(routineId, selectedSports);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sportsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputDuration = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputDescription = new javax.swing.JTextArea();
        titleLabel = new javax.swing.JLabel();
        titleLabel2 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(sportsTable);

        jLabel1.setText("Description");

        jLabel2.setText("Duration in minutes:");

        inputDescription.setColumns(20);
        inputDescription.setRows(5);
        jScrollPane2.setViewportView(inputDescription);

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/data.png"))); // NOI18N
        titleLabel.setText("Routine Data");

        titleLabel2.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        titleLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sports24.png"))); // NOI18N
        titleLabel2.setText("Select Sport");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cancelBtn)
                                .addGap(129, 129, 129)
                                .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(inputDuration))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleLabel2)
                        .addGap(114, 114, 114)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titleLabel)
                        .addComponent(titleLabel2)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (routine == null) {
            inputDescription.setText("");
            inputDuration.setText("");
        } else {
            loadTable();
            fillInputs();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (routine == null) {
            createRoutine();
        } else {
            updateRoutine();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        routinePanel.disableEditDeleteBtn();
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextArea inputDescription;
    private javax.swing.JTextField inputDuration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable sportsTable;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleLabel2;
    // End of variables declaration//GEN-END:variables
}
