/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class LengthException extends Exception{
    private String s;
        private String s2;

    public LengthException(String s, String s2) {
        
        this.s=s;
        this.s2=s2;
        
        }
  
    
    public void printError2(){
                 JOptionPane.showMessageDialog(null, s+" must contains "+s2,"Error!", JOptionPane.ERROR_MESSAGE);
    }
}
