/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import design.DBConn;
import design.Design;
import entity.artist;
import entity.Show;
import entity.reprsentativeMuza;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Etti
 */
public class navigtionRepForm extends javax.swing.JFrame {
    
    Map<Integer, String> artistsIndex;
    ResultSet rs = null;
    public static final String dat = "yyyy-MM-dd HH:mm:ss";
    public static String thisDate = null;
    private static final String dbc = "jdbc:ucanaccess://src/DB.accdb;COLUMNORDER=DISPLAY";
    private String sql_UpdateUser;

    /**
     * Creates new form navigtionRepForm
     */
    public navigtionRepForm() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        artistsIndex = new HashMap<Integer, String>();
        
        try {
            ResultSet rs = DBConn.query("SELECT artist.* FROM artist");
            ArtistsListTbl.removeAllItems();
            ArtistsListTbl.addItem("SelectArtistToSuspend");
            int j = 1;
            while (rs.next()) {
                String alphnumericCode = rs.getString("alphnumericCode");
                String stageName = rs.getString("stageName");
                artistsIndex.put(j, alphnumericCode);
                j++;
                ArtistsListTbl.addItem(stageName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            
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

        jLabel1 = new javax.swing.JLabel();
        suspentArt = new javax.swing.JButton();
        bak = new javax.swing.JButton();
        addSoundmen = new javax.swing.JButton();
        addPla = new javax.swing.JButton();
        watchSoundmen = new javax.swing.JButton();
        addStudio = new javax.swing.JButton();
        watchStudio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ArtistsListTbl = new javax.swing.JComboBox<>();
        txtArtistName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtArtistId = new javax.swing.JTextField();
        watchPla = new javax.swing.JButton();
        vol = new javax.swing.JButton();
        report = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("reprsentative menu");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        suspentArt.setText("suspend artist");
        suspentArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suspentArtMouseClicked(evt);
            }
        });
        suspentArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspentArtActionPerformed(evt);
            }
        });
        getContentPane().add(suspentArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, -1));

        bak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button.jpg"))); // NOI18N
        bak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bakMouseClicked(evt);
            }
        });
        getContentPane().add(bak, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 100, 40));

        addSoundmen.setText("add soundmen");
        addSoundmen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSoundmenMouseClicked(evt);
            }
        });
        getContentPane().add(addSoundmen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));

        addPla.setText("add player");
        addPla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPlaMouseClicked(evt);
            }
        });
        getContentPane().add(addPla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, -1));

        watchSoundmen.setText("watch soundmen's");
        watchSoundmen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                watchSoundmenMouseClicked(evt);
            }
        });
        getContentPane().add(watchSoundmen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        addStudio.setText("add studio");
        addStudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStudioMouseClicked(evt);
            }
        });
        getContentPane().add(addStudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, -1));

        watchStudio.setText("watch studio's");
        watchStudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                watchStudioMouseClicked(evt);
            }
        });
        watchStudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchStudioActionPerformed(evt);
            }
        });
        getContentPane().add(watchStudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("freelancer's");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("studio's");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        ArtistsListTbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ArtistsListTbl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ArtistsListTblItemStateChanged(evt);
            }
        });
        getContentPane().add(ArtistsListTbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, -1));
        getContentPane().add(txtArtistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("artist's");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (3).jpg"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, 30));
        getContentPane().add(txtArtistId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, -1));

        watchPla.setText("watch player's");
        watchPla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                watchPlaMouseClicked(evt);
            }
        });
        getContentPane().add(watchPla, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, -1));

        vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (4).jpg"))); // NOI18N
        vol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volMouseClicked(evt);
            }
        });
        getContentPane().add(vol, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 30, 30));

        report.setText("create report");
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
        });
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        getContentPane().add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 130, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(640, 549));
        bg.setMinimumSize(new java.awt.Dimension(640, 549));
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volMouseClicked
        design.Design.player.close();
    }//GEN-LAST:event_volMouseClicked

    private void bakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakMouseClicked
        this.setVisible(false);
        new LoginForm().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bakMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void addSoundmenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSoundmenMouseClicked
        this.setVisible(false);
        new addSoundmen().setVisible(true);
    }//GEN-LAST:event_addSoundmenMouseClicked

    private void addPlaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPlaMouseClicked
        this.setVisible(false);
        new addPla().setVisible(true);
    }//GEN-LAST:event_addPlaMouseClicked

    private void watchStudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_watchStudioMouseClicked
        this.setVisible(false);
        new watchStudio(artistsIndex.values().toString()).setVisible(true);
    }//GEN-LAST:event_watchStudioMouseClicked

    private void addStudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStudioMouseClicked
        this.setVisible(false);
        new addStudio().setVisible(true);
    }//GEN-LAST:event_addStudioMouseClicked

    private void watchSoundmenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_watchSoundmenMouseClicked
        this.setVisible(false);
        new watchSoundmen().setVisible(true);
    }//GEN-LAST:event_watchSoundmenMouseClicked

    private void ArtistsListTblItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ArtistsListTblItemStateChanged
        if (evt.getStateChange() != ItemEvent.SELECTED) {
            return;
        }
        if (evt.getItem().equals("Select Main Artist")) {
            return;
        }
        txtArtistName.setText(ArtistsListTbl.getSelectedItem().toString());
        txtArtistId.setText("" + ArtistsListTbl.getSelectedIndex());
    }//GEN-LAST:event_ArtistsListTblItemStateChanged

    private void suspentArtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspentArtMouseClicked
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dat);
        thisDate = sdf.format(cal.getTime());
    }//GEN-LAST:event_suspentArtMouseClicked

    private void suspentArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspentArtActionPerformed
        String sn = txtArtistName.getText();
        String al = txtArtistId.getText();
        try {//insert new artist
            sql_UpdateUser = ("UPDATE artist SET artist.suspend=? WHERE ((artist.alphnumericCode=?));");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try {
                Connection conn = DriverManager.getConnection(dbc);
                CallableStatement stmt = conn.prepareCall("UPDATE artist SET artist.suspend=? WHERE ((artist.alphnumericCode=?));");
                stmt.setBoolean(1, false);
                stmt.setString(2, al);
                stmt.executeUpdate();
                int n = stmt.getUpdateCount();
                System.out.println(n + "artist suspend!");
                if (n == 1) {
                    JOptionPane.showMessageDialog(null, "artist suspend", "artist suspend", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "artist not suspend", "artist not suspend", JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_suspentArtActionPerformed

    private void watchStudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchStudioActionPerformed
        this.setVisible(false);
        new watchStudio(artistsIndex.values().toString()).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_watchStudioActionPerformed

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
    }//GEN-LAST:event_reportActionPerformed

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        this.dispose();
        new Report().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_reportMouseClicked

    private void watchPlaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_watchPlaMouseClicked
        this.setVisible(false);
        new watchPlayer().setVisible(true);
    }//GEN-LAST:event_watchPlaMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ArtistsListTbl;
    private javax.swing.JButton addPla;
    private javax.swing.JButton addSoundmen;
    private javax.swing.JButton addStudio;
    private javax.swing.JButton bak;
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton report;
    private javax.swing.JButton suspentArt;
    private javax.swing.JTextField txtArtistId;
    private javax.swing.JTextField txtArtistName;
    private javax.swing.JButton vol;
    private javax.swing.JButton watchPla;
    private javax.swing.JButton watchSoundmen;
    private javax.swing.JButton watchStudio;
    // End of variables declaration//GEN-END:variables
}
