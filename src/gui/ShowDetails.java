/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import design.DBConn;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author user
 */
public class ShowDetails extends javax.swing.JFrame {
        private static int showNum=0;
       private static String[][] st;
    /**
     * Creates new form ShowDetails
     */
    public ShowDetails(int showNum, String[][] st1) {
        this.showNum = showNum;
        setUndecorated(true);
        initComponents();
        this.st=st1;
         setLocationRelativeTo(null);
         
          try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            try (
                    PreparedStatement stmt = DBConn.getConn().prepareStatement("SELECT Show.showNumber, DatePart('d',[Show].[dateAndHourOfShow]) AS Expr1, Artist.stageName, Agent.firstName, Agent.lastName, showPlace.placeName, Show.minimumAge, Show.numberOfLeftTickets, showPlace.capacity, Show.ticketPrice, DatePart('m',[dateAndHourOfShow]) AS Expr2, DatePart('yyyy',[dateAndHourOfShow]) AS Expr3, DatePart('h',[dateAndHourOfShow]) AS Expr4, DatePart('n',[dateAndHourOfShow]) AS Expr5\n" +
"FROM showPlace INNER JOIN ((Agent INNER JOIN Artist ON Agent.agentId = Artist.agentId) INNER JOIN Show ON (Artist.alphanumericCode = Show.mainArtist) AND (Agent.agentId = Show.agentcreatedId)) ON showPlace.placeNumber = Show.placeNumber\n" +
"WHERE (((Show.showNumber)=?));")) {
                
                
                
                stmt.setLong(1,showNum);
               ResultSet rs= stmt.executeQuery();
                     
                while(rs.next()){
                
                    String date=rs.getString(2)+"/"+rs.getString(11)+"/"+rs.getString(12)+"  "+rs.getString(13)+":"+rs.getString(14);
                    jTextField13.setText(rs.getString(1));
                    jTextField2.setText(date);
                    jTextField6.setText(rs.getString(3));
                    jTextField9.setText(rs.getString(4)+" "+rs.getString(5));
                    jTextField7.setText(rs.getString(6));
                    jTextField3.setText(rs.getString(7));
                    jTextField5.setText(rs.getString(8));
                    jTextField8.setText(""+(Integer.parseInt(rs.getString(9))-Integer.parseInt(rs.getString(8))));
                    jTextField29.setText(rs.getString(10));
                    
                    try (
                    PreparedStatement stmt3 = DBConn.getConn().prepareStatement("SELECT ArtistInShow.ShowNumber, ArtistInShow.artistId, ArtistInShow.status, Artist.stageName\n" +
"FROM Show INNER JOIN (Artist INNER JOIN ArtistInShow ON Artist.alphanumericCode = ArtistInShow.artistId) ON Show.showNumber = ArtistInShow.ShowNumber\n" +
"WHERE (((ArtistInShow.ShowNumber)=?) AND ((ArtistInShow.status)=True))")){
                    
                         stmt3.setLong(1,showNum);
               ResultSet rs3= stmt3.executeQuery();
               ResultSet rs4= stmt3.executeQuery();
               int i=0;
               int count=0;
               
               while (rs4.next()){
                   count++;
               }
                String[] strings= new String[count];
                
                while (rs3.next()){
                        strings [i]=rs3.getString(4);
                        i++;
                }
               jList1.setModel(new javax.swing.AbstractListModel<String>() {
                       
                        public int getSize() { return strings.length; }
                        public String getElementAt(int i) { return strings[i]; }
                    });
               
               jScrollPane2.setViewportView(jList1);
               if(strings.length==0)
               {
            //       jList1.setVisible(false);
                   jTextField17.setVisible(false);
                   jScrollPane2.setVisible(false);
               }
               
               try(      PreparedStatement stmt5 = DBConn.getConn().prepareStatement("SELECT Sum(Orders.price) AS Sumfromprice\n" +
"FROM Show INNER JOIN Orders ON Show.showNumber = Orders.showNumber\n" +
"GROUP BY Orders.showNumber, Orders.presale\n" +
"HAVING (((Orders.showNumber)=?) AND ((Orders.presale)=True))") ){
                
                stmt5.setLong(1,showNum);
               ResultSet rs5= stmt5.executeQuery();
    
               String s=null;
                 while(rs5.next())
                   s=rs5.getString(1);
                 if(s==null)
                     s="0";
                 
                 try(      PreparedStatement stmt6 = DBConn.getConn().prepareStatement("SELECT Sum(Orders.price) AS Sumformprice\n" +
"FROM Orders\n" +
"GROUP BY Orders.showNumber, Orders.presale\n" +
"HAVING (((Orders.showNumber)=?) AND ((Orders.presale)=False))") ){
                
                stmt6.setLong(1,showNum);
               ResultSet rs6= stmt6.executeQuery();
               
               String s1=null;
                 while(rs6.next())
                   s1=rs6.getString(1);
                 if(s1==null)
                     s1="0";
                
                  double revenues=Double.parseDouble(s)+Double.parseDouble(s1);
                 double expenses=revenues*0.3;

                 jTextField26.setText(s);
                   jTextField11.setText(s1);
                    
                   jTextField10.setText(revenues+"");
                    jTextField22.setText(expenses+"");
                    jTextField24.setText(""+(revenues-expenses));
                
               }   }
                }
                }
                }
             catch (SQLException e) {
                e.printStackTrace();
            }
        }catch (ClassNotFoundException e) {
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

        lblheadForm = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblExit = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        bg2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblheadForm.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        lblheadForm.setForeground(new java.awt.Color(255, 255, 255));
        lblheadForm.setText("Show details");
        getContentPane().add(lblheadForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 40));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Date:");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 130, 30));

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-button.jpg"))); // NOI18N
        lblExit.setPreferredSize(new java.awt.Dimension(60, 60));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        getContentPane().add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 120, 50));

        title.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("show:");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        title1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("Revenues:");
        getContentPane().add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 150, 30));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 150, 30));

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setText("Mininum Age:");
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 130, 30));

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 150, 30));

        jTextField12.setBackground(new java.awt.Color(0, 0, 0));
        jTextField12.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));
        jTextField12.setText("Left Tickets:");
        getContentPane().add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 130, 30));

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 150, 30));

        jTextField14.setBackground(new java.awt.Color(0, 0, 0));
        jTextField14.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(255, 255, 255));
        jTextField14.setText("Show Number:");
        getContentPane().add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 130, 30));

        jTextField15.setBackground(new java.awt.Color(0, 0, 0));
        jTextField15.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(255, 255, 255));
        jTextField15.setText("Main Artist:");
        getContentPane().add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 130, 30));

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 150, 30));

        jTextField16.setBackground(new java.awt.Color(0, 0, 0));
        jTextField16.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(255, 255, 255));
        jTextField16.setText("place:");
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 130, 30));

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 150, 30));

        jTextField17.setBackground(new java.awt.Color(0, 0, 0));
        jTextField17.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setText("Other artists:");
        getContentPane().add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 130, 30));

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 150, 30));

        jTextField18.setBackground(new java.awt.Color(0, 0, 0));
        jTextField18.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setText("Agent:");
        getContentPane().add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 130, 30));

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 150, 30));

        jTextField19.setBackground(new java.awt.Color(0, 0, 0));
        jTextField19.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(255, 255, 255));
        jTextField19.setText("Total revenues:");
        getContentPane().add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 140, 30));

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 150, 30));

        jTextField20.setBackground(new java.awt.Color(0, 0, 0));
        jTextField20.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setText("Regular Sale:");
        getContentPane().add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 140, 30));

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 150, 30));

        jTextField21.setBackground(new java.awt.Color(0, 0, 0));
        jTextField21.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(255, 255, 255));
        jTextField21.setText("Expenses:");
        getContentPane().add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 140, 30));

        jTextField22.setEditable(false);
        jTextField22.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 150, 30));

        jTextField23.setBackground(new java.awt.Color(0, 0, 0));
        jTextField23.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(255, 255, 255));
        jTextField23.setText("Balance:");
        getContentPane().add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 140, 30));

        jTextField24.setEditable(false);
        jTextField24.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 150, 30));

        jTextField25.setBackground(new java.awt.Color(0, 0, 0));
        jTextField25.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(255, 255, 255));
        jTextField25.setText("Presale:");
        getContentPane().add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 140, 30));

        jTextField26.setEditable(false);
        jTextField26.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 150, 30));

        jTextField27.setBackground(new java.awt.Color(0, 0, 0));
        jTextField27.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField27.setForeground(new java.awt.Color(255, 255, 255));
        jTextField27.setText("Sold Tickets:");
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 130, 30));

        jTextField28.setBackground(new java.awt.Color(0, 0, 0));
        jTextField28.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(255, 255, 255));
        jTextField28.setText("Ticket Price:");
        getContentPane().add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 130, 30));

        jTextField29.setEditable(false);
        jTextField29.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        getContentPane().add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 30, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prev.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 30, -1));

        jList1.setBackground(new java.awt.Color(240, 240, 240));
        jList1.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 150, 90));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print-flat.png"))); // NOI18N
        jButton1.setText("print");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, -1, -1));

        bg2.setBackground(new java.awt.Color(0, 0, 0));
        bg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        bg2.setText("what ");
        bg2.setMaximumSize(new java.awt.Dimension(600, 540));
        bg2.setMinimumSize(new java.awt.Dimension(600, 540));
        bg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bg2MouseClicked(evt);
            }
        });
        getContentPane().add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void bg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bg2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bg2MouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        this.setVisible(false);
        new ReportForm().setVisible(true);
    }//GEN-LAST:event_lblExitMouseClicked

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setVisible(false);
        int num;
        int x=0;
        while (!(st[x][0].equals(Integer.toString(showNum))))
        {
        x++;
        }
        x++;
        if(!(x<st.length))
            x=0;
        
        num=Integer.parseInt(st[x][0]);
        
        new ShowDetails(num, st).setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        this.setVisible(false);
        int num;
        int x=0;
        while (!(st[x][0].equals(Integer.toString(showNum))))
        {
        x++;
        }
        x--;
        if(x<0)
            x=st.length-1;
        
        num=Integer.parseInt(st[x][0]);
        
        new ShowDetails(num, st).setVisible(true);
        
        
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(ShowDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowDetails(showNum, st).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblheadForm;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    // End of variables declaration//GEN-END:variables
}
