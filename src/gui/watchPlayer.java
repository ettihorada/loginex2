/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.watchSoundmen.next;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Etti
 */
public class watchPlayer extends javax.swing.JFrame {

    public static String freeId = null;
    public static int next = 0;
    private static final String dbc = "jdbc:ucanaccess://src/DB.accdb;COLUMNORDER=DISPLAY";
    private static final String player = "SELECT player.freelancerId, player.commission, player.instrumentNumber\n"
            + "FROM player;";
    private static final String freelancer = null;

    /**
     * Creates new form watchPla
     */
    public watchPlayer() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        showPlayer();
    }

    public int numberOfPlayers() {
        int num = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(player);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    num++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }

    public void showPlayer() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(player);
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.ID.setText(rs.getString(1));
                    this.commissio.setText(rs.getString(2));
                    this.instrumentNumber.setText(rs.getString(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String ID = this.ID.getText();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement("SELECT freelancer.firstName,freelancer.lastName,freelancer.mail, freelancer.stageName\n"
                            + "FROM freelancer INNER JOIN player ON freelancer.freelancerId = player.freelancerId\n"
                            + "WHERE (((freelancer.freelancerId)=\"" + ID + "\"));");
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.firstName.setText(rs.getString(1));
                    this.lastName.setText(rs.getString(2));
                    this.mail.setText(rs.getString(3));
                    this.stageName.setText(rs.getString(4));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
        }

    }

    public void showNextPlayer() {
        int count = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(player);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    this.ID.setText(rs.getString(1));
                    this.commissio.setText(rs.getString(2));
                    this.instrumentNumber.setText(rs.getString(3));

                    if (count == next) {
                        break;
                    }
                    count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String ID = this.ID.getText();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement("SELECT freelancer.firstName,freelancer.lastName,freelancer.mail, freelancer.stageName\n"
                            + "FROM freelancer INNER JOIN player ON freelancer.freelancerId = player.freelancerId\n"
                            + "WHERE (((freelancer.freelancerId)=\"" + ID + "\"));");
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.firstName.setText(rs.getString(1));
                    this.lastName.setText(rs.getString(2));
                    this.mail.setText(rs.getString(3));
                    this.stageName.setText(rs.getString(4));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ID = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        commissio = new javax.swing.JTextField();
        instrumentNumber = new javax.swing.JTextField();
        stageName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 70, -1));
        getContentPane().add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 70, -1));
        getContentPane().add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 70, 20));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 70, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 20, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("firstName");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("lastName");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        lbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 255, 255));
        lbl.setText("commission");
        getContentPane().add(lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("mail");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("stageName");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prev.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 30, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("instrumentNumber");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button_1.jpg"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 100, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 30, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (4).jpg"))); // NOI18N
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 30, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (3).jpg"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, 30));
        getContentPane().add(commissio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 70, -1));
        getContentPane().add(instrumentNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 70, -1));
        getContentPane().add(stageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 70, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("players detail's");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (next < numberOfPlayers() - 1) {
            next++;
        }
        showNextPlayer();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if (next > 0) {
            next--;
        }
        showNextPlayer();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        this.setVisible(false);
        new navigtionRepForm().setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField commissio;
    private javax.swing.JTextField firstName;
    private javax.swing.JTextField instrumentNumber;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lbl;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField stageName;
    // End of variables declaration//GEN-END:variables
}
