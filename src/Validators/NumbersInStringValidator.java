/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validators;

import javax.swing.JOptionPane;

/**
 *
 * @author Enav Kasaon
 */
public class NumbersInStringValidator {
    
    public void isTrue(String st){
        String regex = "[0-9]+";
        if(!st.matches(regex))
           JOptionPane.showMessageDialog(null,null,"the Field contains only numbers", JOptionPane.ERROR_MESSAGE);

    }
}
