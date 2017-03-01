package mp3;


import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Etti
 */
public class mp3Player {
    
    public static void main(String[] args){
        try {
           File file = new File("C:\\Users\\Etti\\Documents\\NetBeansProjects\\Login - Copy\\src\\mp3\\song.MP3");
           FileInputStream fis = new FileInputStream(file);
           BufferedInputStream bis = new BufferedInputStream(fis);
            try {
                Player player = new Player(bis);
                player.play();
            } catch (JavaLayerException ex ) {
            }
           
        } catch (Exception e) {
            
            
        }
    }
    
}
