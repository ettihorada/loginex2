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
public class newException extends Exception{
    String s;
    public newException(String s){
        this.s=s;
    }
    
    public void printError(){
                JOptionPane.showMessageDialog(null, s,"Error!", JOptionPane.ERROR_MESSAGE);

    }
    
}
