/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import design.DBConn;
import entity.CreateXML;
import static entity.CreateXML.time;
import entity.XML;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Etti
 */
public class createSessionForm extends javax.swing.JFrame {

    private static final String sql1 = "SELECT recordingStudio.studioNumber, recordingStudio.studioName\n"
            + "FROM recordingStudio;";
    JFrame form;
    public static String studioNumber;
    String pr;
    Integer numSession;
    String studioName;
    Integer numberStudio;
    Integer roomNumber;
    Integer numSes;
    String ag;
    java.sql.Date dte;
    String time;
    Integer freeId;
    java.util.Date dateForSession;
    ResultSet rs = null;
    //   Map<Integer, String> locationIndex;
    private static final String dbc = "jdbc:ucanaccess://src/DB.accdb;COLUMNORDER=DISPLAY";
    private String sql_InsertToRecordingSessions;
    private String sql2;
    private String sql7;
    private String sql8;
    Date oDate = null;
    Map<Integer, String> studioIndex;
    String artId = null;

    /**
     * Creates new form createShow
     */
    public createSessionForm(JFrame form, String ANumber) {
        this.form = form;
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.artId = ANumber;
        //call to date tata

        Date[] dates = XML.xmlImport(DBConn.getArtistConnected().getAlphanumericCode());
        int t = 0;
        for (Date d : dates) {
            if (d != null) {
                System.err.println(t++ + " - " + d.toGMTString());
            }
        }
        DateForArtists.getMonthView().setUnselectableDates(dates);
        //end call to date
        //  locationIndex = new HashMap<Integer, String>();
        studioIndex = new HashMap<Integer, String>();
        studioList.removeAllItems();
        studioList.addItem("Select studio");
        players.removeAllItems();
        players.addItem("Select player");
        roomsForPlayer.removeAllItems();
        roomsForPlayer.addItem("Select room for player");
        soundmens.removeAllItems();
        soundmens.addItem("Select soundmen");
        System.err.println("Activated createSessionForm");

        try {
            ResultSet rs = DBConn.query("SELECT recordingStudio.studioNumber, recordingStudio.studioName\n"
                    + "FROM recordingStudio");
            studioList.removeAllItems();
            studioList.addItem("Select studio");
            System.err.println("studioName" + studioName);
            while (rs.next()) {
                studioNumber = rs.getString("studioNumber");
                studioName = rs.getString("studioName");
                System.out.println("studioName" + studioName);
                System.out.println("studioNumber" + studioNumber);
                studioList.addItem(studioName);
            }

            /*       ResultSet resRow = DBConn.query("SELECT COUNT(*) FROM recordingSessions");
            // get the number of rows from the result set
            resRow.next();
            int rowCount = resRow.getInt(1);
            numSession = rowCount;
            System.out.println("numOfSession"+numSession);*/
 /*   ResultSet rees = DBConn.query("SELECT studioRoomes.roomNumber\n"
                    + "FROM studioRoomes");
            roomsForPlayer.removeAllItems();
            roomsForPlayer.addItem("Select room");
            while (rees.next()) {
                roomNumber = rees.getInt("roomNumber");
                roomsForPlayer.addItem(roomNumber.toString());
            }*/
            ResultSet res = DBConn.query("SELECT freelancer.stageName\n"
                    + "FROM freelancer INNER JOIN player ON freelancer.freelancerId = player.freelancerId\n");
            players.removeAllItems();
            players.addItem("Select player");
            while (res.next()) {
                String stageName = res.getString("stageName");
                players.addItem(stageName);
            }

            ResultSet resultt = DBConn.query("SELECT freelancer.stageName\n"
                    + "FROM freelancer INNER JOIN professionalSoundMan ON freelancer.freelancerId = professionalSoundMan.ID\n");
            soundmens.removeAllItems();
            soundmens.addItem("Select SoundMan");
            while (resultt.next()) {
                String stageName = resultt.getString("stageName");
                soundmens.addItem(stageName);
            }

        } catch (SQLException ex) {
            Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        bg = new javax.swing.JLabel();
        lblheadForm = new javax.swing.JLabel();
        mainArtist = new javax.swing.JLabel();
        studioList = new javax.swing.JComboBox<>();
        showPlace = new javax.swing.JLabel();
        players = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        back = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        lblhour = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rooms = new javax.swing.JButton();
        min2 = new com.toedter.components.JSpinField();
        roomsForPlayer = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        studioDetails = new javax.swing.JButton();
        soundmens = new javax.swing.JComboBox<>();
        addSoundmenRole = new javax.swing.JButton();
        hour2 = new com.toedter.components.JSpinField();
        min = new javax.swing.JSpinner();
        hour = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        soundmenTbl = new javax.swing.JTable();
        role1 = new javax.swing.JCheckBox();
        role2 = new javax.swing.JCheckBox();
        role3 = new javax.swing.JCheckBox();
        addPla = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        plaAndRoom = new javax.swing.JTable();
        DateForArtists = new org.jdesktop.swingx.JXDatePicker();
        rooms1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblheadForm.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblheadForm.setForeground(new java.awt.Color(255, 255, 255));
        lblheadForm.setText("create session form");
        getContentPane().add(lblheadForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 40));

        mainArtist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mainArtist.setForeground(new java.awt.Color(255, 255, 255));
        mainArtist.setText("choose studio  ");
        getContentPane().add(mainArtist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 30));

        studioList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studioList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                studioListItemStateChanged(evt);
            }
        });
        studioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studioListMouseClicked(evt);
            }
        });
        studioList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studioListActionPerformed(evt);
            }
        });
        getContentPane().add(studioList, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 100, 20));

        showPlace.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showPlace.setForeground(new java.awt.Color(255, 255, 255));
        showPlace.setText("choose player in room");
        getContentPane().add(showPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 170, 30));

        players.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        players.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                playersItemStateChanged(evt);
            }
        });
        players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersActionPerformed(evt);
            }
        });
        getContentPane().add(players, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 90, -1));

        add.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        add.setText("add session");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button.jpg"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 100, 30));

        date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("choose Session Date");
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, -1));

        lblhour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblhour.setForeground(new java.awt.Color(255, 255, 255));
        lblhour.setText("choose Session start hour(HH:MM)");
        getContentPane().add(lblhour, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("choose session end hour(hh:mm)");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        rooms.setText("show room details ");
        rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsMouseClicked(evt);
            }
        });
        getContentPane().add(rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));
        getContentPane().add(min2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 40, -1));

        roomsForPlayer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roomsForPlayer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                roomsForPlayerItemStateChanged(evt);
            }
        });
        roomsForPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsForPlayerActionPerformed(evt);
            }
        });
        getContentPane().add(roomsForPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 90, -1));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("choose soundmen");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        studioDetails.setText("show studio details");
        studioDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studioDetailsMouseClicked(evt);
            }
        });
        studioDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studioDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(studioDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 170, -1));

        soundmens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(soundmens, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 90, -1));

        addSoundmenRole.setText("add");
        addSoundmenRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSoundmenRoleMouseClicked(evt);
            }
        });
        getContentPane().add(addSoundmenRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 80, -1));
        getContentPane().add(hour2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 40, -1));
        getContentPane().add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 40, -1));
        getContentPane().add(hour, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 40, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (4).jpg"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (3).jpg"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 30, 30));

        soundmenTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "mixTechnician", "masterTechnician", "recordProducer"
            }
        ));
        jScrollPane4.setViewportView(soundmenTbl);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 240, 50));

        role1.setText("mixTechnician");
        getContentPane().add(role1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        role2.setText("masterTechnician");
        getContentPane().add(role2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, -1, -1));

        role3.setText("recordProducer");
        getContentPane().add(role3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        addPla.setText("add");
        addPla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPlaMouseClicked(evt);
            }
        });
        getContentPane().add(addPla, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 120, -1));

        plaAndRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "room"
            }
        ));
        jScrollPane2.setViewportView(plaAndRoom);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 130, 50));
        getContentPane().add(DateForArtists, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        rooms1.setText("show and choose rooms");
        rooms1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rooms1MouseClicked(evt);
            }
        });
        getContentPane().add(rooms1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(640, 500));
        jLabel3.setMinimumSize(new java.awt.Dimension(640, 500));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 620, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studioListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studioListActionPerformed

    }//GEN-LAST:event_studioListActionPerformed

    public int getStudioNum(String name) {
        int num = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql1);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    if (rs.getString(1).equals(name)) {
                        num = rs.getInt(2);
                        studioNumber = num + "";
                        System.err.println("" + studioNumber);
                        break;
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
    private void studioListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studioListItemStateChanged
        /*  roomsForPlayer.removeAllItems();
        sql2 = "SELECT studioRoomes.roomNumber, recordingStudio.studioNumber\n"
                + "FROM recordingStudio INNER JOIN studioRoomes ON recordingStudio.studioNumber = studioRoomes.studioNumber\n"
                + "WHERE ((recordingStudio.studioNumber=" + getStudioNum(studioList.getSelectedItem().toString()) + "));";

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql2);
                    ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    roomsForPlayer.addItem(Integer.valueOf(rs.getInt(1)).toString());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        DefaultComboBoxModel model = (DefaultComboBoxModel) roomsForPlayer.getModel();
        model.removeAllElements();
        /*  ResultSet res = DBConn.query("SELECT recordingStudio.studioNumber\n"
        + "FROM recordingStudio\n"
        + "WHERE (((recordingStudio.studioName)=\"song\"));");*/
        ResultSet rs = DBConn.query("SELECT studioRoomes.roomNumber\n"
                + "FROM studioRoomes\n"
                + "WHERE (((studioRoomes.studioNumber)=\"" + studioList.getSelectedIndex() + "\"));");
        roomsForPlayer.addItem("ROOM");
        System.out.println("studio" + studioList.getSelectedIndex());
        try {
            while (rs.next()) {
                roomsForPlayer.addItem(Integer.valueOf(rs.getInt(1)).toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studioListItemStateChanged

    private void playersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playersActionPerformed

    private void playersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_playersItemStateChanged


    }//GEN-LAST:event_playersItemStateChanged

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked

    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {                                    
            String studio = this.studioList.getSelectedItem().toString();
            LocalDate localDate = LocalDate.now();
            System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
            System.err.println("" + localDate);
            time = localDate.toString();
            System.err.println("time" + time);
            time = "#" + DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate) + "#";
            sql_InsertToRecordingSessions = "INSERT INTO recordingSessions ([startDateAndHour],[endDateAndHour],[artistId]) VALUES (?,?,?)";
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (Connection conn = DriverManager.getConnection(dbc);
                    PreparedStatement stmt = conn.prepareStatement(sql_InsertToRecordingSessions);) {
                {
                    stmt.setString(1, time);
                    stmt.setString(2, time);
                    stmt.setString(3, artId);
                    stmt.executeUpdate();
                    int n = stmt.getUpdateCount();
                    conn.close();
                    System.out.println(n + "  recordingSessions recoared inserted");
                    if (n == 1) {
                        JOptionPane.showMessageDialog(null, "recordingSessions Recoared Inserted", "Insert", JOptionPane.INFORMATION_MESSAGE);
                        //    ResultSet r = DBConn.query("SELECT recordingSessions.sessionNumber FROM recordingSessions WHERE recordingSessions.artistId=\"" + artId + "\" AND startDateAndHour=\"" + time + "\"");
                        // get the number of rows from the result set
                        //    r.next();
                        //    numSes = r.getInt(1);
                        //    System.err.println("numSes" + numSes);
                    } else {
                        JOptionPane.showMessageDialog(null, "Recoared is Not Inserted", "Not Insert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet resRow = DBConn.query("SELECT COUNT(*) FROM recordingSessions");
            // get the number of rows from the result set
            resRow.next();
            int rowCount = resRow.getInt(1);
            numSes = rowCount;
            System.out.println("numOfSession"+numSes);
            ResultSet result1 = DBConn.query("SELECT freelancer.freelancerId\n"
                    + "FROM freelancer\n"
                    + "WHERE (((freelancer.firstName)=\"" + soundmens.getSelectedItem() + "\"));");
            try {
                result1.next();
            } catch (SQLException ex) {
                Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                freeId = result1.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.err.println("" + freeId);
            System.err.println("" + numSes);
            sql7 = "INSERT INTO soundMenInSession ([freelancerId],[sessionNumber],[mixTechnician],[masterTechnician],[recordProducer]) VALUES (?,?,?,?,?)";
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection conn = DriverManager.getConnection(dbc);
                        PreparedStatement stmt1 = conn.prepareStatement(sql7);) {
                    {
                        stmt1.setInt(1, freeId);
                        stmt1.setInt(2, numSes);
                        stmt1.setBoolean(3, role1.isSelected());
                        stmt1.setBoolean(4, role2.isSelected());
                        stmt1.setBoolean(5, role3.isSelected());
                        stmt1.executeUpdate();
                        
                        int n = stmt1.getUpdateCount();
                        System.out.println(n + "  soundMenInSession inserted");
                        if (n == 1) {
                            
                            JOptionPane.showMessageDialog(null, "soundMenInSession Inserted", "Insert", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "soundMenInSession are Not Inserted", "Not Insert", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.err.println("" + freeId);
            System.err.println("" + studioList.getSelectedIndex());
            System.err.println("" + numSes);
            System.err.println("" + roomsForPlayer.getSelectedIndex());
            
            sql8= "INSERT INTO playerInSessionInRoom ([freelancerId], [studioNumber],[sessionNumber],[roomNumber]) VALUES (?,?,?,?)";
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection conn = DriverManager.getConnection(dbc);
                        PreparedStatement stmt1 = conn.prepareStatement(sql8);
                        ){{
                            stmt1.setInt(1,freeId);
                            stmt1.setInt(2,studioList.getSelectedIndex());
                            stmt1.setInt(3,numSes);
                            stmt1.setInt(4,roomsForPlayer.getSelectedIndex());
                            
                            stmt1.executeUpdate();
                            
                            int n= stmt1.getUpdateCount();
                            System.out.println(n+"  playerInSessionInRoom inserted");
                            if(n==1){
                                
                                JOptionPane.showMessageDialog(null,"playerInSessionInRoom Inserted","Insert",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else
                                JOptionPane.showMessageDialog(null,"playerInSessionInRoom are Not Inserted","Not Insert",JOptionPane.INFORMATION_MESSAGE);
                        }
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(createSessionForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_addActionPerformed


    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        this.dispose();
        form.setVisible(true);
    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_backActionPerformed

    private void roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsMouseClicked
        this.setVisible(false);
        new roomsDetails(this, studioList.getSelectedIndex() + 1, 1).setVisible(true);
    }//GEN-LAST:event_roomsMouseClicked

    private void studioDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studioDetailsMouseClicked
        this.setVisible(false);
        new studioDetails(this, studioList.getSelectedIndex()).setVisible(true);
    }//GEN-LAST:event_studioDetailsMouseClicked

    private void rooms1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rooms1MouseClicked
        this.setVisible(false);
        System.out.println("numSes " + numSes);
        new roomsDetails(this, studioList.getSelectedIndex() + 1, 1).setVisible(true);
    }//GEN-LAST:event_rooms1MouseClicked

    private void roomsForPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsForPlayerActionPerformed

    }//GEN-LAST:event_roomsForPlayerActionPerformed

    private void roomsForPlayerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_roomsForPlayerItemStateChanged

    }//GEN-LAST:event_roomsForPlayerItemStateChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        design.Design.player.close();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void studioDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studioDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studioDetailsActionPerformed

    private void addPlaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPlaMouseClicked
        DefaultTableModel model = (DefaultTableModel) plaAndRoom.getModel();
        if (!players.getSelectedItem().equals("")) {
            model.addRow(new Object[]{players.getSelectedItem(), roomsForPlayer.getSelectedItem()});
        } else {
            JOptionPane.showMessageDialog(null, "please fill", "please fill", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addPlaMouseClicked

    private void addSoundmenRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSoundmenRoleMouseClicked
        DefaultTableModel model = (DefaultTableModel) soundmenTbl.getModel();
        if (!soundmens.getSelectedItem().equals("")) {
            model.addRow(new Object[]{soundmens.getSelectedItem(), role1.isSelected(), role2.isSelected(), role3.isSelected()});
        } else {
            JOptionPane.showMessageDialog(null, "please fill", "please fill", JOptionPane.INFORMATION_MESSAGE);
        }   // TODO add your handling code here:
    }//GEN-LAST:event_addSoundmenRoleMouseClicked

    private void studioListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studioListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_studioListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker DateForArtists;
    private javax.swing.JButton add;
    private javax.swing.JButton addPla;
    private javax.swing.JButton addSoundmenRole;
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel date;
    private javax.swing.JSpinner hour;
    private com.toedter.components.JSpinField hour2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblheadForm;
    private javax.swing.JLabel lblhour;
    private javax.swing.JLabel mainArtist;
    private javax.swing.JSpinner min;
    private com.toedter.components.JSpinField min2;
    private javax.swing.JTable plaAndRoom;
    private javax.swing.JComboBox<String> players;
    private javax.swing.JCheckBox role1;
    private javax.swing.JCheckBox role2;
    private javax.swing.JCheckBox role3;
    private javax.swing.JButton rooms;
    private javax.swing.JButton rooms1;
    private javax.swing.JComboBox<String> roomsForPlayer;
    private javax.swing.JLabel showPlace;
    private javax.swing.JTable soundmenTbl;
    private javax.swing.JComboBox<String> soundmens;
    private javax.swing.JButton studioDetails;
    private javax.swing.JComboBox<String> studioList;
    // End of variables declaration//GEN-END:variables
}
