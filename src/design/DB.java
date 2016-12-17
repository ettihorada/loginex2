/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;
import entity.Agent;
import entity.Artist;
import entity.Customer;
import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author Etti
 */
public class DB {
    private static Connection conn;
    private static Customer customerConnected;
    private static Agent agentConnected;
    private static Artist artistConnected;

    
 public static Connection getConn() {
        return conn;
    }
    public static void setConn(Connection conn) {
        DB.conn = conn;
    }

    public static void setArtistConnected(Artist artistConnected) {
        DB.artistConnected = artistConnected;
    }
    public static Artist getArtistConnected() {
        return artistConnected;
    }
   
    public static Agent getAgentConnected() {
        return agentConnected;
    }
    public static void setAgentConnected(Agent agentConnected) {
        DB.agentConnected = agentConnected;
    }
    
    public static void setCustomerConnected(Customer customerConnected) {
        DB.customerConnected = customerConnected;
    }
    public static Customer getCustomerConnected() {
        return customerConnected;
    }
//add all
     
     
    public DB(String dburl) throws ClassNotFoundException, SQLException{
        String driver="net.ucanaccess.jdbc.UcanaccessDriver";
        Class.forName(driver);
        conn=DriverManager.getConnection("jdbc:ucanaccess://"+dburl);
    } 
    
    public static ResultSet query(String SQL){
        ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return result;
    }
    
    
}
