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
public class AgeException extends Exception{
    
    private String s1;
    private String s2;
    public AgeException(String s1, String s2){
        this.s1=s1;
        this.s2=s2;
    }
    
    public void printError(){
         JOptionPane.showMessageDialog(null, s1+" can't be under "+s2+ " years old","Error!", JOptionPane.ERROR_MESSAGE);

    }
}
