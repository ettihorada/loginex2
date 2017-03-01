package Validators;

import java.io.Serializable;
import javax.swing.JOptionPane;



public class EmailValidator{

        /**
        * Checks whether the given email address is valid according to format:
        * Format user_name@domain.ending.....
        * @param email represents the email address.
        */
	public static void validateEmail (String email){	  
     // a null string is invalid
     if ( email == null )
       JOptionPane.showMessageDialog(null,null,"email is not correct.", JOptionPane.ERROR_MESSAGE);

     // a string without a "@" is an invalid email address
     if ( email.indexOf("@") < 0 )
       JOptionPane.showMessageDialog(null,null,"email is not correct.", JOptionPane.ERROR_MESSAGE);


     // a string without a "."  is an invalid email address
     if ( email.indexOf(".") < 0 )
         JOptionPane.showMessageDialog(null,null,"email is not correct.", JOptionPane.ERROR_MESSAGE);


		    
	}

}
	
