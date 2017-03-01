/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MyException extends Exception{
    private String s;
    public MyException(String s) {
        
        this.s=s;
        }
    public void printError(){
        JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(null,"The field "+s+" is incorrect!");
    }
    
    public void printError2(){
         JDialog.setDefaultLookAndFeelDecorated(true);
            JOptionPane.showMessageDialog(null,"The field "+s+" is empty!");
    }
    }
