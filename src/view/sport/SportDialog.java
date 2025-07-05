package view.sport;

import controller.SportController;
import javax.swing.JOptionPane;
import model.Sport;
import util.Validate;

public class SportDialog extends javax.swing.JDialog {

    private SportPanel sportPanel;
    private SportController sportController;
    Sport sport;

    public SportDialog(java.awt.Frame parent, SportPanel sportPanel, boolean modal, Sport sport) {
        super(parent, modal);

        this.sportPanel = sportPanel;
        sportController = new SportController();
        setUndecorated(true);

        initComponents();

        inputCharacteristics.setLineWrap(true);
        setSize(300, 300);
        setLocationRelativeTo(sportPanel);

        if (sport == null) {
            saveBtn.setText("Create");
        } else {
            saveBtn.setText("Edit");
            this.sport = sport;
            fillInputs();
        }
    }

    private void createSport() {
        String name = inputName.getText().trim();
        String characteristics = inputCharacteristics.getText().trim();
        boolean isValid = Validate.validateSport(
                this,
                name,
                characteristics
        );

        if (isValid) {
            Sport s = new Sport(name, characteristics, true);

            if (sportController.registerSport(s)) {
                sportPanel.loadTable();
                JOptionPane.showMessageDialog(this, "Sport created.", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "That sport already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    private void updateSport() {
        String name = inputName.getText().trim();
        String characteristics = inputCharacteristics.getText().trim();
        boolean isValid = Validate.validateSport(
                this,
                name,
                characteristics
        );

        if (isValid) {
            boolean canUpdate = true;

            if (!sport.getName().equalsIgnoreCase(name)) {
                if ((sportController.getSportByName(name)) != null) {
                    JOptionPane.showMessageDialog(this, "That sport already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to update this sport?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    sport.setName(name);
                    sport.setCharacteristics(characteristics);

                    sportController.updateSport(sport);
                    sportPanel.loadTable();
                    JOptionPane.showMessageDialog(this, "Sport updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    private void fillInputs() {
        inputName.setText(sport.getName());
        inputCharacteristics.setText(sport.getCharacteristics());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputCharacteristics = new javax.swing.JTextArea();
        characteristicsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sports24.png"))); // NOI18N
        titleLabel.setText("Sport Data");

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

        nameLabel.setText("Name:");

        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });

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

        inputCharacteristics.setColumns(20);
        inputCharacteristics.setRows(5);
        jScrollPane1.setViewportView(inputCharacteristics);

        characteristicsLabel.setText("Characteristics:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addGap(129, 129, 129)
                        .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(characteristicsLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(characteristicsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (sport == null) {
            inputName.setText("");
            inputCharacteristics.setText("");
        } else {
            fillInputs();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (sport == null) {
            createSport();
        } else {
            updateSport();
        }
    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel characteristicsLabel;
    private javax.swing.JButton closeBtn;
    private javax.swing.JTextArea inputCharacteristics;
    private javax.swing.JTextField inputName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
