package view.athlete;

import controller.AthleteController;
import javax.swing.JOptionPane;
import model.Athlete;
import util.Validate;

public class AthleteDialog extends javax.swing.JDialog {

    private AthletePanel athletePanel;
    private AthleteController athleteController;
    Athlete athlete;

    public AthleteDialog(java.awt.Frame parent, AthletePanel athletePanel, boolean modal, Athlete athlete) {
        super(parent, modal);

        this.athletePanel = athletePanel;
        athleteController = new AthleteController();
        setUndecorated(true);

        initComponents();

        setSize(300, 400);
        setLocationRelativeTo(null);

        if (athlete == null) {
            saveBtn.setText("Create");
        } else {
            saveBtn.setText("Edit");
            this.athlete = athlete;
            fillInputs();
        }
    }

    private void createAthlete() {
        String name = inputName.getText();
        String lastName = inputLastname.getText();
        String city = inputCity.getText();
        String address = inputAddress.getText();
        String phone = inputPhone.getText();
        String email = inputEmail.getText();

        boolean isValid = Validate.validateAthleteForm(
                this,
                name,
                lastName,
                city,
                address,
                phone,
                email
        );

        if (isValid) {
            Athlete verifyAthlete = athleteController.getAthleteByEmail(email);

            if (verifyAthlete != null) {
                JOptionPane.showMessageDialog(this, "That email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Athlete a = new Athlete(name, lastName, city, address, phone, email, true);
                athleteController.registerAthlete(a);
                athletePanel.loadTable();
                JOptionPane.showMessageDialog(this, "Athlete created.", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }

    private void updateAthlete() {
        String name = inputName.getText();
        String lastName = inputLastname.getText();
        String city = inputCity.getText();
        String address = inputAddress.getText();
        String phone = inputPhone.getText();
        String email = inputEmail.getText();

        boolean isValid = Validate.validateAthleteForm(
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

            if (!athlete.getEmail().equalsIgnoreCase(email)) {
                if ((athleteController.getAthleteByEmail(email)) != null) {
                    JOptionPane.showMessageDialog(this, "That email already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                int confirmacion = JOptionPane.showConfirmDialog(this, "Do you wish to update this athlete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    athlete.setName(name);
                    athlete.setLastName(lastName);
                    athlete.setCity(city);
                    athlete.setAddress(address);
                    athlete.setPhone(phone);
                    athlete.setEmail(email);

                    athleteController.updateAthlete(athlete);
                    athletePanel.loadTable();
                    JOptionPane.showMessageDialog(this, "User updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Canceled.", "Canceled", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private void fillInputs() {
        inputName.setText(athlete.getName());
        inputLastname.setText(athlete.getLastName());
        inputCity.setText(athlete.getCity());
        inputAddress.setText(athlete.getAddress());
        inputPhone.setText(athlete.getPhone());
        inputEmail.setText(athlete.getEmail());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        inputName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        lastnameLabel = new javax.swing.JLabel();
        inputLastname = new javax.swing.JTextField();
        inputCity = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        inputAddress = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        inputPhone = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Adwaita Sans", 1, 24)); // NOI18N
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        titleLabel.setText("Athlete Profile");

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

        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });

        nameLabel.setText("Name:");

        lastnameLabel.setText("Last name:");

        cityLabel.setText("City:");

        addressLabel.setText("Address:");

        phoneLabel.setText("Phone:");

        emailLabel.setText("Email:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneLabel)
                            .addComponent(emailLabel))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addGap(129, 129, 129)
                        .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastnameLabel)
                            .addComponent(cityLabel)
                            .addComponent(addressLabel)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputCity, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameLabel)
                    .addComponent(inputLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(inputCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (athlete == null) {
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
        if (athlete == null) {
            createAthlete();
        } else {
            updateAthlete();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
