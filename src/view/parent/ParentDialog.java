package view.parent;

import controller.AthleteController;
import controller.ParentController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Athlete;
import model.Parent;
import util.Colors;
import util.Validate;

public class ParentDialog extends javax.swing.JDialog {

    ParentPanel parentPanel;
    ParentController parentController;
    Parent parent;
    private List<Athlete> athletes;
    private List<Athlete> selectedAthletes;
    private AthleteController athleteController;

    public ParentDialog(java.awt.Frame parentFrame, ParentPanel parentPanel, boolean modal, Parent parent) {
        super(parentFrame, modal);

        this.parentPanel = parentPanel;
        this.parent = parent;
        parentController = new ParentController();
        athleteController = new AthleteController();
        athletes = new ArrayList<>();
        selectedAthletes = new ArrayList<>();

        setUndecorated(true);
        initComponents();

        initSettings();
        setupTableRenderer();
        setupTableClickListener();

        if (parent == null) {
            saveBtn.setText("Create");
        } else {
            saveBtn.setText("Edit");
            fillInputs();
        }

        loadTable();
        restoreSelectionState();
    }

    private void createParent() {
        String name = inputName.getText();
        String lastName = inputLastname.getText();
        String city = inputCity.getText();
        String address = inputAddress.getText();
        String phone = inputPhone.getText();
        String email = inputEmail.getText();

        boolean isValid = Validate.validateAthleteParentForm(
                this,
                name,
                lastName,
                city,
                address,
                phone,
                email
        );

        if (isValid) {
            Parent verifyParent = parentController.getParentByEmail(email);

            if (verifyParent != null) {
                JOptionPane.showMessageDialog(this, "That email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Parent p = new Parent(name, lastName, city, address, phone, email, true);
                int id = parentController.registerParent(p);

                linkParentIdAthletes(id);

                parentPanel.loadTable();
                JOptionPane.showMessageDialog(this, "Parent created.", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }

    private void updateParent() {
        String name = inputName.getText();
        String lastName = inputLastname.getText();
        String city = inputCity.getText();
        String address = inputAddress.getText();
        String phone = inputPhone.getText();
        String email = inputEmail.getText();

        boolean isValid = Validate.validateAthleteParentForm(
                this,
                name,
                lastName,
                city,
                address,
                phone,
                email
        );

        if (isValid) {

            boolean canUpdate = true;

            if (!parent.getEmail().equalsIgnoreCase(email)) {
                if ((parentController.getParentByEmail(email)) != null) {
                    JOptionPane.showMessageDialog(this, "That email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to update this athlete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    parent.setName(name);
                    parent.setLastName(lastName);
                    parent.setCity(city);
                    parent.setAddress(address);
                    parent.setPhone(phone);
                    parent.setEmail(email);

                    parentController.updateParent(parent);

                    unlinkDeselectedAthletes(parent.getId());

                    linkParentIdAthletes(parent.getId());

                    parentPanel.loadTable();
                    JOptionPane.showMessageDialog(this, "Parent updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }

    }

    private void fillInputs() {
        inputName.setText(parent.getName());
        inputLastname.setText(parent.getLastName());
        inputCity.setText(parent.getCity());
        inputAddress.setText(parent.getAddress());
        inputPhone.setText(parent.getPhone());
        inputEmail.setText(parent.getEmail());
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

        athletesTable.setModel(model);

        athletes = athleteController.getAvailableAthletes();

        if (parent != null) {

            List<Athlete> parentAthletes = athleteController.getByParentId(parent.getId());

            if (parentAthletes.size() > 0) {

                for (int i = 0; i < parentAthletes.size(); i++) {
                    athletes.add(parentAthletes.get(i));
                    selectedAthletes.add(parentAthletes.get(i));
                }
            }

        }

        for (Athlete a : athletes) {
            model.addRow(new Object[]{
                a.getId(),
                a.getName(),
                a.getLastName()
            });
        }

    }

    private void initSettings() {
        setSize(776, 440);
        setLocationRelativeTo(null);
        athletesTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void setupTableRenderer() {
        athletesTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int modelRow = table.convertRowIndexToModel(row);
                Athlete a = athletes.get(modelRow);

                if (selectedAthletes.contains(a)) {
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
        athletesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int viewRow = athletesTable.rowAtPoint(evt.getPoint());
                if (viewRow == -1) {
                    return;
                }

                int modelRow = athletesTable.convertRowIndexToModel(viewRow);
                Athlete a = athletes.get(modelRow);

                if (selectedAthletes.contains(a)) {
                    selectedAthletes.remove(a);
                    athletesTable.removeRowSelectionInterval(viewRow, viewRow);
                } else {
                    selectedAthletes.add(a);
                    athletesTable.addRowSelectionInterval(viewRow, viewRow);
                }

                athletesTable.repaint();
            }
        });
    }

    private void restoreSelectionState() {
        for (int i = 0; i < athletes.size(); i++) {
            for (Athlete a : selectedAthletes) {
                if (athletes.get(i).getId() == a.getId()) {
                    athletesTable.addRowSelectionInterval(i, i);
                    break;
                }
            }
        }

        athletesTable.repaint();
    }

    public void linkParentIdAthletes(int id) {
        if (selectedAthletes.size() > 0) {
            for (int i = 0; i < selectedAthletes.size(); i++) {
                Athlete a = selectedAthletes.get(i);
                a.setParentId(id);

                athleteController.updateAthlete(a);
            }
        }
    }

    private void unlinkDeselectedAthletes(int parentId) {

        List<Integer> selectedIds = new ArrayList<>();
        for (Athlete a : selectedAthletes) {
            selectedIds.add(a.getId());
        }

        List<Athlete> currentAssigned = athleteController.getByParentId(parentId);

        for (Athlete a : currentAssigned) {
            if (!selectedIds.contains(a.getId())) {
                a.setParentId(null);
                athleteController.updateAthlete(a);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        inputEmail = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        inputPhone = new javax.swing.JTextField();
        inputAddress = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        inputCity = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        lastnameLabel = new javax.swing.JLabel();
        inputLastname = new javax.swing.JTextField();
        inputName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        athletesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        titleLabel.setText("Parent Data");

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

        emailLabel.setText("Email:");

        phoneLabel.setText("Phone:");

        addressLabel.setText("Address:");

        cityLabel.setText("City:");

        lastnameLabel.setText("Last name:");

        inputLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputLastnameActionPerformed(evt);
            }
        });

        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });

        nameLabel.setText("Name:");

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

        athletesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        athletesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(athletesTable);

        jLabel1.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/triathlon.png"))); // NOI18N
        jLabel1.setText("Select Athlete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cancelBtn)
                                .addGap(129, 129, 129)
                                .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressLabel)
                                    .addComponent(emailLabel)
                                    .addComponent(phoneLabel)
                                    .addComponent(cityLabel)
                                    .addComponent(nameLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lastnameLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titleLabel)
                        .addComponent(jLabel1))
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastnameLabel)
                            .addComponent(inputLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityLabel)
                            .addComponent(inputCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
        if (parent == null) {
            inputName.setText("");
            inputLastname.setText("");
            inputCity.setText("");
            inputAddress.setText("");
            inputPhone.setText("");
            inputEmail.setText("");
        } else {
            fillInputs();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (parent == null) {
            createParent();
        } else {
            updateParent();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void inputLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputLastnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTable athletesTable;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField inputAddress;
    private javax.swing.JTextField inputCity;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputLastname;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputPhone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
