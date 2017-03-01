/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class NoObjectsException extends Exception{
    private String s;
    public NoObjectsException(String s) {
        
        this.s=s;
        }
  
    
    public void printError(){
                 JOptionPane.showMessageDialog(null, "There are no "+s+"!","Error!", JOptionPane.ERROR_MESSAGE);
    }
    }
