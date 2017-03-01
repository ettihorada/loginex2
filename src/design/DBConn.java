/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;
import entity.*;
import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author Etti
 */
public class DBConn {
    private static Connection conn;
    private static artist artistConnected;
    private static reprsentativeMuza repConnected;
    private static freelancer freelancerConnected;


    
 public static Connection getConn() {
        return conn;
    }
    public static void setConn(Connection conn) {
        DBConn.conn = conn;
    }

    public static void setArtistConnected(artist artistConnected) {
        DBConn.artistConnected = artistConnected;
    }
    public static artist getArtistConnected() {
        return artistConnected;
    }
    
    public static void setRepConnected(reprsentativeMuza repConnected) {
        DBConn.repConnected = repConnected;
    }
    public static reprsentativeMuza getRepConnected(){
        return repConnected;
    }
   public static void setFreelancerConnected(freelancer freelancerConnected) {
        DBConn.freelancerConnected = freelancerConnected;
    }
    public static freelancer getFreelancerConnected(){
        return freelancerConnected;
    }
    
    
//add all
     
     
    public DBConn(String dburl) throws ClassNotFoundException{
        String driver="net.ucanaccess.jdbc.UcanaccessDriver";
        Class.forName(driver);
        try{
        conn=DriverManager.getConnection("jdbc:ucanaccess://"+dburl);
        } catch (SQLException ex) {
            try{
                conn=DriverManager.getConnection("jdbc:ucanaccess://src/"+dburl);
            }
            catch (SQLException ex2) {
                Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    public static ResultSet query(String SQL){
        ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return result;
    }
    
    
}
