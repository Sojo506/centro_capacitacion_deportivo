package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import model.User;
import view.athlete.AthletePanel;
import view.panel.NavbarPanel;
import view.panel.SidebarPanel;

public class MainView extends javax.swing.JFrame {

    private User user;
    private int xMouse, yMouse;

    public MainView(User user) {
        setUndecorated(true);
        initComponents();
        this.user = user;
        initPanels();
        setLocationRelativeTo(null);
        showPanel(new AthletePanel(this));

    }

    public User getUser() {
        return user;
    }

    public void showPanel(JPanel newPanel) {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(newPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void initPanels() {
        sideBar.removeAll();
        sideBar.setLayout(new BorderLayout());
        sideBar.add(new SidebarPanel(this), BorderLayout.CENTER);
        sideBar.revalidate();
        sideBar.repaint();

        navBar.removeAll();
        navBar.setLayout(new BorderLayout());
        navBar.add(new NavbarPanel(this), BorderLayout.CENTER);
        navBar.revalidate();
        navBar.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dragBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        sideBar = new javax.swing.JPanel();
        navBar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dragBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dragdrop.png"))); // NOI18N
        dragBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        dragBtn.setBorderPainted(false);
        dragBtn.setContentAreaFilled(false);
        dragBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        dragBtn.setFocusPainted(false);
        dragBtn.setFocusable(false);
        dragBtn.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dragBtnMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                dragBtnMouseMoved(evt);
            }
        });
        getContentPane().add(dragBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        contentPanel.setBackground(new java.awt.Color(74, 74, 72));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 1000, 660));

        sideBar.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        getContentPane().add(sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 700));

        navBar.setBackground(new java.awt.Color(204, 204, 204));
        navBar.setPreferredSize(new java.awt.Dimension(1000, 40));

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dragBtnMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBtnMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_dragBtnMouseDragged

    private void dragBtnMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dragBtnMouseMoved
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_dragBtnMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dragBtn;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel sideBar;
    // End of variables declaration//GEN-END:variables
}
