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
public class NotNumberException extends Exception{
     private String str;
    public NotNumberException(String s){
        str=s;
    }
    
    public void printError(){
                JOptionPane.showMessageDialog(null, "The field "+str+" must contain only digits!","Error!", JOptionPane.ERROR_MESSAGE);

    }
    
}
