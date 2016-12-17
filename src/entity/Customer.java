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
public class Customer {
    private String CustomerID;
    private String firstName;
    
    // ---------------------------constractor--------------------------------

    public Customer(String CustomerID, String firstName){
        this.CustomerID = CustomerID;
        this.firstName = firstName;
        //continue to fill all details you need
    }
    //--------------------------getters&setters------------------------------

    public String getCustomerID() {
        return CustomerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
}
