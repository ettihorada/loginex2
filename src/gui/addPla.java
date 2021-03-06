/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import design.DBConn;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Etti
 */
public class addPla extends javax.swing.JFrame {
    private static final String dbc ="jdbc:ucanaccess://src/DB.accdb;COLUMNORDER=DISPLAY";
        private String sql_InsertToFreelancer;
        private String sql_InsertToPlayer;
        Map<Integer, String> insIndex;

    /**
     * Creates new form addPla
     */
    public addPla() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null); 
        insIndex = new HashMap<Integer, String>();
        instrumentList.removeAllItems();
        instrumentList.addItem("Select instrument");
        
          try
    {    
        ResultSet rs = DBConn.query("SELECT musicalInstrument.* \n"+ 
                "FROM musicalInstrument");
        instrumentList.removeAllItems();
        instrumentList.addItem("Select instrument");
        int j=1;
        while(rs.next()){
            String instrumentName = rs.getString("instrumentName");
            String instrumentNumber = rs.getString("instrumentNumber");
            insIndex.put(j, instrumentName);
            j++;
            instrumentList.addItem(instrumentName);
        }
    }
         catch (SQLException ex){
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

        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        freelancerId = new javax.swing.JTextField();
        commission = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        stageName = new javax.swing.JTextField();
        imageLink = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        instrumentList = new javax.swing.JComboBox<>();
        birthDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        file = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 90, -1));
        getContentPane().add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 90, -1));
        getContentPane().add(freelancerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 90, -1));
        getContentPane().add(commission, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 100, -1));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 90, -1));
        getContentPane().add(stageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 90, -1));
        getContentPane().add(imageLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 70, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("instrument");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("freelancerId");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("lastName");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("firstName");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        photo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        photo.setForeground(new java.awt.Color(255, 255, 255));
        photo.setText("show photo here");
        getContentPane().add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 180, 130));

        instrumentList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(instrumentList, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 100, -1));
        getContentPane().add(birthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 60, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("stageName");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button_1.jpg"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 100, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("commission");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adds.png"))); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 80, 80));

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (4).jpg"))); // NOI18N
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 30, 30));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (3).jpg"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 30, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("birthDate");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        file.setText("choose file");
        file.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileMouseClicked(evt);
            }
        });
        getContentPane().add(file, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("add player form");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 3, 520, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         this.setVisible(false);
       new navigtionRepForm().setVisible(true);  
    }//GEN-LAST:event_jButton1MouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String freelancerId=this.freelancerId.getText();
        String firstName=this.firstName.getText();
        String lastName=this.lastName.getText();
        Date birthDate = this.birthDate.getDate();
        String mail=this.mail.getText();     
        String stageName= this.stageName.getText();
        BufferedImage image=null;
        File file=new File(imageLink.getText());  
        
        sql_InsertToFreelancer= "INSERT INTO freelancer([freelancerId],[firstName],[lastName],[birthDate],[mail],[stageName],[photo]) VALUES (?, ?,?, ?,?, ?,?)";
    FileInputStream fin=null;
        try {
           fin = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

      try {//insert new artist
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection conn = DriverManager.getConnection(dbc);
                        PreparedStatement stmt = conn.prepareStatement(sql_InsertToFreelancer);
                        
                        ){{
                        stmt.setString(1,freelancerId);
                        stmt.setString(2,firstName);
                        stmt.setString(3,lastName);
                        stmt.setString(4,birthDate.toString());
                        stmt.setString(5,mail);
                        stmt.setString(6,stageName);
                        stmt.setBinaryStream(7,(InputStream)fin,(int)file.length());
                        stmt.executeUpdate();
                        int n= stmt.getUpdateCount();
                        conn.close();
                    System.out.println(n+"  recoared inserted");
                            if(n==1)
                                JOptionPane.showMessageDialog(null,"Recoared Inserted","Insert",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null,"Recoared is Not Inserted","Not Insert",JOptionPane.INFORMATION_MESSAGE);
                                }
                        } 
                     catch (SQLException e) {
                        e.printStackTrace();
                     }
                
                 } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        String ID=this.freelancerId.getText();
        String commission=this.commission.getText();
        //String instrumentNumber=this.instrumentNumber.getText();
        sql_InsertToPlayer= "INSERT INTO player ([freelancerId],[commission],[instrumentNumber]) VALUES (?, ?,?)";
      try {//insert new soundmen
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection conn = DriverManager.getConnection(dbc);
                        PreparedStatement stmt = conn.prepareStatement(sql_InsertToPlayer);
                        
                        ){{
                        stmt.setString(1,ID);
                        stmt.setString(2,commission);
                        stmt.setInt(3,instrumentList.getSelectedIndex());
                        stmt.executeUpdate();
                        int n= stmt.getUpdateCount();
                        conn.close();
                    System.out.println(n+"  recoared inserted");
                            if(n==1)
                                JOptionPane.showMessageDialog(null,"Recoared Inserted","Insert",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null,"Recoared is Not Inserted","Not Insert",JOptionPane.INFORMATION_MESSAGE);
                                }
                        } 
                     catch (SQLException e) {
                        e.printStackTrace();
                     }
                
                 } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }          // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void fileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileMouseClicked
         JFileChooser filechooser= new JFileChooser();
         filechooser.setDialogTitle("Choose Your File");
         filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                 //below codes for select  the file 
           int returnval=filechooser.showOpenDialog(this);
          if(returnval==JFileChooser.APPROVE_OPTION)
         {
               File file = filechooser.getSelectedFile();
               BufferedImage bi;
          try
              {   //display the image in jlabel
                bi=ImageIO.read(file);
               photo.setText("");
               imageLink.setText(file.getPath());
               photo.setIcon(new ImageIcon(bi));
        }
        catch(IOException e)
        {

        }
    }
    }//GEN-LAST:event_fileMouseClicked

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
         design.Design.player.close();
        // TODO add your handling code here:
    }//GEN-LAST:event_stopMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
            this.dispose();        
    }//GEN-LAST:event_exitMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addPla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addPla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addPla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addPla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addPla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private org.jdesktop.swingx.JXDatePicker birthDate;
    private javax.swing.JTextField commission;
    private javax.swing.JButton exit;
    private javax.swing.JButton file;
    private javax.swing.JTextField firstName;
    private javax.swing.JTextField freelancerId;
    private javax.swing.JTextField imageLink;
    private javax.swing.JComboBox<String> instrumentList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel photo;
    private javax.swing.JTextField stageName;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables
}
