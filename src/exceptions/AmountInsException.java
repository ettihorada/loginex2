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
public class AmountInsException extends Exception{
    
    public AmountInsException(){
        
    }
    public void printError(){
                        JOptionPane.showMessageDialog(null, "The amount of Instruments should be between 1 to 20.","Error!", JOptionPane.ERROR_MESSAGE);

    }
    
}
