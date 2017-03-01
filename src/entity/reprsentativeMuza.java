/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Etti
 */
public class reprsentativeMuza {
    
    private String ID;
    private String firstName;
    
        // constractor
    public reprsentativeMuza (String ID,String firstName){
        this.ID = ID;
        this.firstName = firstName;
    }
    
        //-------------------------- gettrs & setrs ----------------------------

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
}
