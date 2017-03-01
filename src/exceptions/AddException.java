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
public class AddException extends Exception{
    
    String a;
    String b;
    
    public AddException(String a, String b){
        this.a=a;
        this.b=b;
    }
    public void printError(){
                JOptionPane.showMessageDialog(null, "You can't add "+a+" before you add "+b,"Error!", JOptionPane.ERROR_MESSAGE);

    }
}
