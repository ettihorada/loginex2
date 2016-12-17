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
public class Agent {
    private String AgentID;
    private String FirstName;
    
    // ---------------------------constractor--------------------------------
    public Agent(String AgentID, String FirstName) {
        this.AgentID = AgentID;
        this.FirstName = FirstName;
    }
    //--------------------------getters&setters------------------------------

    public String getAgentID() {
        return AgentID;
    }

    public void setAgentID(String AgentID) {
        this.AgentID = AgentID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    
}
