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
public class InvalidException extends Exception{
    String s;
    public InvalidException(String s){
        this.s=s;
    }
    
    public void printEerror(){
                JOptionPane.showMessageDialog(null, "Your "+s+" is invalid","Error!", JOptionPane.ERROR_MESSAGE);

    }
    public void printError2(){
                        JOptionPane.showMessageDialog(null, "Your Date has passed","Error!", JOptionPane.ERROR_MESSAGE);

    }
    public void printError3(){
                        JOptionPane.showMessageDialog(null, "Customer's subscription invalid at this "+s,"Error!", JOptionPane.ERROR_MESSAGE);

    }
}
