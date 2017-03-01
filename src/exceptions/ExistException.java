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
public class ExistException extends Exception{
    
    public ExistException(){
        }
  
    
    public void printError2(){
                 JOptionPane.showMessageDialog(null, "The Customer already exist","Error!", JOptionPane.ERROR_MESSAGE);
    }
    
}
