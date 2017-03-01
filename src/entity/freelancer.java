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
public class freelancer {
    
    
        private String freelancerId;
        private String firstName;
    
        // constractor
    public freelancer (String freelancerId,String firstName){
        this.freelancerId = freelancerId;
        this.firstName = firstName;
    }
        //-------------------------- gettrs & setrs ----------------------------

    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFreelancerId() {
        return freelancerId;
    }

    public String getFirstName() {
        return firstName;
    }

    
}
