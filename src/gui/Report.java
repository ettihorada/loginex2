/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static entity.CreateXML.time;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Etti
 */
public class Report extends javax.swing.JFrame {

    public static int next = 0;
    public static int next1 = 0;
    public static int ArtistNum = 0;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static String time;

    private static final String dbc = "jdbc:ucanaccess://src/DB.accdb;COLUMNORDER=DISPLAY";

    private static final String artist = ("SELECT artist.alphnumericCode\n" +
"FROM (artist INNER JOIN recordingSessions ON artist.alphnumericCode = recordingSessions.artistId) INNER JOIN record ON recordingSessions.sessionNumber = record.sessionNumber\n" +
"GROUP BY artist.alphnumericCode, recordingSessions.startDateAndHour\n" +
"HAVING (((recordingSessions.startDateAndHour) Between #01/03/2016# And #01/03/2017#) AND ((Count(record.recordNum))>0));");

    private static String sql_ArtistRecordings = "";
    private static String sql_RecordingsNum = "";
    private static String sql_masteredRecordingsNum = "";

    /**
     * Creates new form Report
     */
    public Report() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        ShowDate();
        showArtist();
        showArtistRec();
    }

    void ShowDate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        date.setText(sdf.format(d));
        LocalDate localDate = LocalDate.now();
        time = localDate.toString();
        time = "#" + DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate) + "#";
    }

    public int numberOfArtists() {
        int num = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(artist);
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

    public void showArtist() {
        try {//show artists
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(artist);
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    this.artistNum.setText(rs.getString(1));
                    ArtistNum = Integer.parseInt(this.artistNum.getText());
                    sql_ArtistRecordings = "SELECT record.recordNumber, record.status, record.recordName, Qry_ArtistsInLastHalfYear.artistId\n"
                            + "FROM (recordingSessions INNER JOIN Qry_ArtistsInLastHalfYear ON recordingSessions.artistId = Qry_ArtistsInLastHalfYear.artistId) INNER JOIN record ON recordingSessions.sessionNumber = record.sessionNumber\n"
                            + "WHERE (((Qry_ArtistsInLastHalfYear.artistId)=" + ArtistNum + "));";

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void showNextArtist() {
        int count = 0;
        try {//show artists
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(artist);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    this.artistNum.setText(rs.getString(1));
                    ArtistNum = Integer.parseInt(this.artistNum.getText());
                    sql_ArtistRecordings = "SELECT record.recordNum, record.status, record.recordName, Qry_ArtistsInLastHalfYear.artistId\n"
                            + "FROM (recordingSessions INNER JOIN Qry_ArtistsInLastHalfYear ON recordingSessions.artistId = Qry_ArtistsInLastHalfYear.artistId) INNER JOIN record ON recordingSessions.sessionNumber = record.sessionNumber\n"
                            + "WHERE (((Qry_ArtistsInLastHalfYear.artistId)=" + ArtistNum + "));";
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
    }

    public int numberOfArtistRec() {
        int num = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql_ArtistRecordings);
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

    public int numberOfArtistMasteredRec() {
        int num = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql_ArtistRecordings);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    if (rs.getString(2).equals("mastered")) {
                        num++;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return num;
    }

    public void showArtistRec() {
        int precent;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql_ArtistRecordings);
                    ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.rNum.setText(rs.getString(1));
                    this.status.setText(rs.getString(2));
                    this.rNam.setText(rs.getString(3));
                    this.numRe.setText(numberOfArtistRec() + "");
                    precent = (numberOfArtistMasteredRec() / numberOfArtistRec()) * 100;
                    this.masterPre.setText(precent + "%");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void showNextArtistRec() {
        int precent;
        int count = 0;
        try {//show artists
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql_ArtistRecordings);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    this.rNum.setText(rs.getString(1));
                    this.status.setText(rs.getString(2));
                    this.rNam.setText(rs.getString(3));
                    this.numRe.setText(numberOfArtistRec() + "");
                    precent = (numberOfArtistMasteredRec() / numberOfArtistRec()) * 100;
                    this.masterPre.setText(precent + "%");
                    if (count == next1) {
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new javax.swing.JTextField();
        artistNum = new javax.swing.JTextField();
        rNum = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        rNam = new javax.swing.JTextField();
        numRe = new javax.swing.JTextField();
        masterPre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        artNext = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 108, -1));
        getContentPane().add(artistNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 90, -1));
        getContentPane().add(rNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, -1));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 80, -1));
        getContentPane().add(rNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 70, -1));
        getContentPane().add(numRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 108, -1));
        getContentPane().add(masterPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 108, -1));

        jButton1.setText("prev");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        artNext.setText("next");
        artNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artNextActionPerformed(evt);
            }
        });
        getContentPane().add(artNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));

        jButton4.setText("next");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Artist Number");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("recordName");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("record Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("status");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("record amount");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("masterd %");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        jButton2.setText("prev");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button_1.jpg"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 110, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void artNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artNextActionPerformed
        if (next < numberOfArtists() - 1) {
            next++;
        }
        showNextArtist();
        showArtistRec();
    }//GEN-LAST:event_artNextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (next > 0) {
            next--;
        }
        showNextArtist();
        showArtistRec();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (next1 < numberOfArtistRec() - 1) {
            next1++;
        }
        showNextArtistRec();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (next1 > 0) {
            next1--;
        }
        showNextArtistRec();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        this.dispose();
        new navigtionRepForm().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton artNext;
    private javax.swing.JTextField artistNum;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField masterPre;
    private javax.swing.JTextField numRe;
    private javax.swing.JTextField rNam;
    private javax.swing.JTextField rNum;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
