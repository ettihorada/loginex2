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
public class PasswordException extends Exception{
    
    public PasswordException(){
        
    }
    
    public void printError(){
        JOptionPane.showMessageDialog(null, "Your password is invalid. Please write at least 5 charecters","Error!", JOptionPane.ERROR_MESSAGE);

    }
    
    
}
