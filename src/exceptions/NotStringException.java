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
public class NotStringException extends Exception{
    
    private String str;
    public NotStringException(String s){
        str=s;
    }
    
    public void printError(){
                JOptionPane.showMessageDialog(null, "The field "+str+" is incorrect!","Error!", JOptionPane.ERROR_MESSAGE);

    }
}
