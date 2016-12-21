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
public class DBConn {
    private static Connection conn;
    private static Customer customerConnected;
    private static Agent agentConnected;
    private static Artist artistConnected;

    
 public static Connection getConn() {
        return conn;
    }
    public static void setConn(Connection conn) {
        DBConn.conn = conn;
    }

    public static void setArtistConnected(Artist artistConnected) {
        DBConn.artistConnected = artistConnected;
    }
    public static Artist getArtistConnected() {
        return artistConnected;
    }
   
    public static Agent getAgentConnected() {
        return agentConnected;
    }
    public static void setAgentConnected(Agent agentConnected) {
        DBConn.agentConnected = agentConnected;
    }
    
    public static void setCustomerConnected(Customer customerConnected) {
        DBConn.customerConnected = customerConnected;
    }
    public static Customer getCustomerConnected() {
        return customerConnected;
    }
//add all
     
     
    public DBConn(String dburl) throws ClassNotFoundException, SQLException{
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
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return result;
    }
    
    
}
