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
public class Artist {
    private String alphanumericCode;
    private String stageName;
    
    // constractor
    public Artist (String alphanumericCode,String stageName){
        this.alphanumericCode = alphanumericCode;
        this.stageName = stageName;
    }
    
    //-------------------------- gettrs & setrs ----------------------------
    public String getAlphanumericCode() {
        return alphanumericCode;
    }
    public void setAlphanumericCode(String alphanumericCode) {
        this.alphanumericCode = alphanumericCode;
    }
    
    
    public String getStageName() {
        return stageName;
    }
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
    
}
