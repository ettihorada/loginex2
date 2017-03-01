/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3_IShape_204560528_305218943.src.exceptions;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DateException extends Exception{
    private String d1;
    private String d2;
    
    public DateException(String d1,String d2){
        this.d1=d1;
        this.d2=d2;
    }
    
    public void printError(){
                JOptionPane.showMessageDialog(null, d1+" can't be before "+d2,"Error!", JOptionPane.ERROR_MESSAGE);

    }
    
}
