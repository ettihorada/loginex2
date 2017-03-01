/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import design.DBConn;
import static entity.CreateXML.time;
import static gui.createSessionForm.studioNumber;
import static gui.watchStudio.next;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Etti
 */
public class watchSoundmen extends javax.swing.JFrame {

    public static String freeId = null;
    public static int next = 0;
    private static final String dbc = "jdbc:ucanaccess://src/DB.accdb;COLUMNORDER=DISPLAY";
    private static final String SoundMan = "SELECT professionalSoundMan.ID, professionalSoundMan.mixTechnician, professionalSoundMan.masterTechnician, professionalSoundMan.recordProducer, professionalSoundMan.imprest\n"
            + "FROM professionalSoundMan;";
    private static final String freelancer = null;
    public static String studioName;
    public static Integer studioNumber;
    Map<Integer, String> studioIndex;
    public static String grd;
    private static String sql=null;

    /**
     * Creates new form watchSoundmen
     */
    public watchSoundmen() {
            setUndecorated(true);
            initComponents();
            setLocationRelativeTo(null);
            showSoundmen();
            
        studioList.removeAllItems();
        studioList.addItem("Select studio");
        System.err.println("Activated watchSoundmenForm");
            
    }

    public int numberOfSoundmens() {
        int num = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(SoundMan);
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

    public void showSoundmen() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(SoundMan);
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.ID.setText(rs.getString(1));
                    this.mixTechnician.setText(rs.getString(2));
                    this.masterTechnician.setText(rs.getString(3));
                    this.recordProducer.setText(rs.getString(4));
                    this.imprest.setText(rs.getString(5));
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
                            + "FROM freelancer INNER JOIN professionalSoundMan ON freelancer.freelancerId = professionalSoundMan.ID\n"
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

    public void showNextSound() {
        int count = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(SoundMan);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    this.ID.setText(rs.getString(1));
                    this.mixTechnician.setText(rs.getString(2));
                    this.masterTechnician.setText(rs.getString(3));
                    this.recordProducer.setText(rs.getString(4));
                    this.imprest.setText(rs.getString(5));

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
                            + "FROM freelancer INNER JOIN professionalSoundMan ON freelancer.freelancerId = professionalSoundMan.ID\n"
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
        jLabel2 = new javax.swing.JLabel();
        prev = new javax.swing.JButton();
        mixTechnician = new javax.swing.JTextField();
        bak = new javax.swing.JButton();
        ne = new javax.swing.JButton();
        masterTechnician = new javax.swing.JTextField();
        stop = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        firstName = new javax.swing.JTextField();
        imprest = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        recordProducer = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        studioList = new javax.swing.JComboBox<>();
        gra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        send = new javax.swing.JButton();
        stageName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("soundmen's details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prev.png"))); // NOI18N
        prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevMouseClicked(evt);
            }
        });
        getContentPane().add(prev, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 30, 30));
        getContentPane().add(mixTechnician, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 90, -1));

        bak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button.jpg"))); // NOI18N
        bak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bakMouseClicked(evt);
            }
        });
        getContentPane().add(bak, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 100, 40));

        ne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        ne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                neMouseClicked(evt);
            }
        });
        getContentPane().add(ne, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 30, 30));
        getContentPane().add(masterTechnician, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 90, 20));

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (4).jpg"))); // NOI18N
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 30, 30));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (3).jpg"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 30, 30));
        getContentPane().add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 90, -1));
        getContentPane().add(imprest, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("firstName");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("lastName");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("mail");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 40, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("mixTechnician");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("recordProducer");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("stageName");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("imprest");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("masterTechnician");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));
        getContentPane().add(recordProducer, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 90, -1));
        getContentPane().add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 90, -1));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 30, -1));

        studioList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studioList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studioListItemStateChanged(evt);
            }
        });
        getContentPane().add(studioList, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 90, -1));
        getContentPane().add(gra, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 90, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("enterGrade");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jButton1.setText("give grade");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 90, -1));

        send.setText("send grade");
        send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendMouseClicked(evt);
            }
        });
        getContentPane().add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 90, -1));
        getContentPane().add(stageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void neMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_neMouseClicked
        if (next < numberOfSoundmens() - 1) {
            next++;
        }
        showNextSound();
    }//GEN-LAST:event_neMouseClicked

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        if (next > 0) {
            next--;
        }
        showNextSound();
    }//GEN-LAST:event_prevMouseClicked

    private void bakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakMouseClicked
        this.setVisible(false);
        new navigtionRepForm().setVisible(true);
    }//GEN-LAST:event_bakMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stopMouseClicked

    private void studioListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studioListItemStateChanged

    }//GEN-LAST:event_studioListItemStateChanged

    private void sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendMouseClicked
        String grd = gra.getText();
        String ID = this.ID.getText();
        sql = "INSERT INTO freelancerInStudio ([freelancerId],[grade]) VALUES (?,?)";
        try {//insert grades
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql);) {{
                    stmt.setString(1,ID);
                    stmt.setString(2,grd);
                    stmt.executeUpdate();
                    int n = stmt.getUpdateCount();
                    conn.close();
                    System.out.println(n + " grade inserted");
                    if (n == 1) {
                        JOptionPane.showMessageDialog(null, "grade Inserted", "Insert", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "grade is Not Inserted", "Not Insert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_sendMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      try {
            ResultSet res = DBConn.query("SELECT recordingStudio.studioNumber, recordingStudio.studioName\n"
                    + "FROM recordingStudio");
            while (res.next()) {
                String stageName = res.getString("studioName");
                studioList.addItem(stageName);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JButton bak;
    private javax.swing.JButton exit;
    private javax.swing.JTextField firstName;
    private javax.swing.JTextField gra;
    private javax.swing.JTextField imprest;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField masterTechnician;
    private javax.swing.JTextField mixTechnician;
    private javax.swing.JButton ne;
    private javax.swing.JButton prev;
    private javax.swing.JTextField recordProducer;
    private javax.swing.JButton send;
    private javax.swing.JTextField stageName;
    private javax.swing.JButton stop;
    private javax.swing.JComboBox<String> studioList;
    // End of variables declaration//GEN-END:variables
}
