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
public class IdValldator {
        public static void inTerface(String stCh) {
        String id;
        int sum, bikoret;
        
        id = stCh;
        
        if(id.length()==9)
        {    
            sum = idVerification(id);
            bikoret = Character.getNumericValue(id.charAt(8));
        
            if((sum+bikoret)%10==0)
                System.out.println("The ID is legal");
            else
                JOptionPane.showMessageDialog(null,null,"The ID is ilegal!!", JOptionPane.ERROR_MESSAGE);
               
        }
        else
        {
            JOptionPane.showMessageDialog(null,null,"An Israeli ID must contain 9 numbers.", JOptionPane.ERROR_MESSAGE);
    
        }
        
    }
    
    public static int idVerification(String id) {
        String a;
        int sum=0, i, j, num;
        
        for(i=0; i<8; i++)
        {
            if(i==0 || i%2==0)
            {
                num = Character.getNumericValue(id.charAt(i));
                sum = sum+num;
            }
            else
            {
                num = Character.getNumericValue(id.charAt(i));
                if((num*2)>10)
                {
                    a = Integer.toString(num*2);
                    for(j=0; j<2; j++)
                    {
                        num = Character.getNumericValue(a.charAt(j));
                        sum = sum+num;
                    }
                }
                else
                    sum = sum+(num*2);
            }
        }
        
        return sum;
    }
}
