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
import design.DBConn;
import gui.LoginForm;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import mp3.mp3Player;
/**
 *
 * @author Etti
 */
public abstract class Design extends Application{
    static DBConn dbc;
    public static Player player = null;

    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
            // TODO code application logic here
            System.err.println("Attempting to load DB");
            connectDB();
            System.err.println("DB Successfully loaded");

            
           LoginForm login = new LoginForm();
           login.setVisible(true);
           try {
           File file = new File("C:\\Users\\Etti\\Documents\\NetBeansProjects\\Login - Copy\\src\\design\\song4.MP3");
           FileInputStream fis = new FileInputStream(file);
           BufferedInputStream bis = new BufferedInputStream(fis);
            try {
                player = new Player(bis);
                player.play();
            } catch (JavaLayerException ex ) {
            }
           
        } catch (Exception e) {
        } 
    }
   
    
    
    public static void connectDB(){
        try { //
            dbc = new DBConn("C:\\Users\\Etti\\Documents\\NetBeansProjects\\Login - Copy\\src\\DB.accdb"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static DBConn getCon(){
        return dbc;
    }
}
