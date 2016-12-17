/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import design.DB;
/**
 *
 * @author Etti
 */
public class Design {
    static DB dbc;
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
            // TODO code application logic here
            System.err.println("Attempting to load DB");
            connectDB();
            System.err.println("DB Successfully loaded");
            
            
            System.err.println("Example Query");
            
            //Initiate a query and return to ResultSet tmp
            ResultSet tmp = DB.query("select * from customer");
            
            //While has rows
            while(tmp.next()){
                //Each itiration is a row
                String id = tmp.getString(1);
                String firstName = tmp.getString("firstName");
                String lastName = tmp.getString("lastName");
                
                System.err.println("Customer #"+id+" "+firstName+" "+lastName);
            }
        
    }
    
    
    public static void connectDB(){
        try {
            dbc = new DB("C:\\Users\\Etti\\Desktop\\Univ\\design\\Ex2\\DB.accdb"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
