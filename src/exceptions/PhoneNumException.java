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
public class PhoneNumException extends Exception{
    
    public PhoneNumException(){
        
    }
    
    public void printEerror(){
                JOptionPane.showMessageDialog(null, "Your phone number is invalid","Error!", JOptionPane.ERROR_MESSAGE);

    }
}
