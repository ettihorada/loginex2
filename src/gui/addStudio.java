/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Validators.CharValidator;
import Validators.NumbersInStringValidator;
import design.DBConn;
import exceptions.PhoneNumException;
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Etti
 */
public class addStudio extends javax.swing.JFrame {
    private String sql_InsertToRecordingStudio;
private static final String dbc ="jdbc:ucanaccess://src/DB.accdb;COLUMNORDER=DISPLAY";
    public static String num=null;
    public static String rows=null;

    /**
     * Creates new form addStudio
     */
    public addStudio() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);  
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studioName = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        about = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        photo = new javax.swing.JButton();
        imgLink = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        waze = new javax.swing.JButton();
        bak = new javax.swing.JButton();
        add = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studioName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                studioNameKeyTyped(evt);
            }
        });
        getContentPane().add(studioName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 90, -1));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 90, -1));

        phone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                phoneMousePressed(evt);
            }
        });
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 90, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        about.setViewportView(jTextArea1);

        getContentPane().add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        photo.setText("studio picture");
        photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoMouseClicked(evt);
            }
        });
        getContentPane().add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));
        getContentPane().add(imgLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 100, -1));
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 90, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("show picture here");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 140, 120));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("studioName");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("address");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("phoneNumber");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        waze.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/waze.jpg"))); // NOI18N
        waze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wazeActionPerformed(evt);
            }
        });
        getContentPane().add(waze, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 40, 40));

        bak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button_1.jpg"))); // NOI18N
        bak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bakMouseClicked(evt);
            }
        });
        getContentPane().add(bak, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 100, 40));

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/106-128.png"))); // NOI18N
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 70, 70));

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (4).jpg"))); // NOI18N
        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 30, 30));

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (3).jpg"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-mail");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("about us");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("add studio form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wazeActionPerformed
        try {
            String URL ="https://www.waze.com/he/livemap";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_wazeActionPerformed

    private void photoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoMouseClicked
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
               imgLink.setText(file.getPath());
               photo.setIcon(new ImageIcon(bi));
        }
        catch(IOException e)
        {

        }
    }           // TODO add your handling code here:
    }//GEN-LAST:event_photoMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        String studioName=this.studioName.getText();
        String address=this.address.getText();
        String mail=this.mail.getText();     
        String phone=this.phone.getText();     
        String about= this.about.toString();
        BufferedImage image=null;
        File file=new File(imgLink.getText());  
        
        sql_InsertToRecordingStudio= "INSERT INTO RecordingStudio ([studioName],[address],[mail],[phoneNumber],[about],[photo]) VALUES (?, ?,?, ?,?, ?)";
    FileInputStream fin=null;
        try {
           fin = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

      try {//insert new artist
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection conn = DriverManager.getConnection(dbc);
                        PreparedStatement stmt = conn.prepareStatement(sql_InsertToRecordingStudio);
                        
                        ){{
                        stmt.setString(1,studioName);
                        stmt.setString(2,address);
                        stmt.setString(3,mail);
                        stmt.setString(4,phone);
                        stmt.setString(5,about);
                        stmt.setBinaryStream(6,(InputStream)fin,(int)file.length());
                        stmt.executeUpdate();
                        int n= stmt.getUpdateCount();
                        conn.close();
                    System.out.println(n+"  recoared inserted");
                            if(n==1)
                                JOptionPane.showMessageDialog(null,"Recoared Inserted","Insert",JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null,"Recoared is Not Inserted","Not Insert",JOptionPane.INFORMATION_MESSAGE);
                                }
                        if(phone.length()<9){
                            throw new PhoneNumException();
                        }
                        } 
                     catch (SQLException e) {
                        e.printStackTrace();
                     } catch (PhoneNumException ex) {
                ex.printEerror();
            }
                
                 } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

    }//GEN-LAST:event_addMouseClicked

    private void bakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bakMouseClicked
       this.setVisible(false);
       new navigtionRepForm().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_bakMouseClicked

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        design.Design.player.close();  
        // TODO add your handling code here:
    }//GEN-LAST:event_stopMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseClicked

    private void phoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneMousePressed
      if(!phone.getText().isEmpty())
           Validators.IdValldator.inTerface(phone.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_phoneMousePressed

    private void studioNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studioNameKeyTyped
         if (!studioName.getText().isEmpty()) {
            Validators.CharValidator s = new CharValidator();
            s.isWord(studioName.getText());
        }           
    }//GEN-LAST:event_studioNameKeyTyped

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
            java.util.logging.Logger.getLogger(addStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addStudio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane about;
    private javax.swing.JButton add;
    private javax.swing.JTextField address;
    private javax.swing.JButton bak;
    private javax.swing.JLabel bg;
    private javax.swing.JButton exit;
    private javax.swing.JTextField imgLink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField phone;
    private javax.swing.JButton photo;
    private javax.swing.JButton stop;
    private javax.swing.JTextField studioName;
    private javax.swing.JButton waze;
    // End of variables declaration//GEN-END:variables
}
