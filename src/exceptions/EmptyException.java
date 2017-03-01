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
public class EmptyException extends Exception{
    private String s;
    public EmptyException(String s) {
        
        this.s=s;
        }
  
    
    public void printError2(){
                 JOptionPane.showMessageDialog(null, "The field "+s+" is empty!","Error!", JOptionPane.ERROR_MESSAGE);
    }
    }
