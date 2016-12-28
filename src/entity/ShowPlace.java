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
public class ShowPlace {

    private int placeNumber;
    private String placeName;
    private String Adderss;
    private String Email;
    private int Phone;
    private String GoogleMaps;
    private int capacity;
    
    public ShowPlace(int placeNumber, String placeName, String Adderss, String Email, int Phone, String GoogleMaps , int capacity) {
        this.placeNumber = placeNumber;
        this.placeName = placeName;
        this.Adderss = Adderss;
        this.Email = Email;
        this.Phone = Phone;
        this.GoogleMaps = GoogleMaps;
        this.capacity = capacity;
    
    
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setAdderss(String Adderss) {
        this.Adderss = Adderss;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public void setGoogleMaps(String GoogleMaps) {
        this.GoogleMaps = GoogleMaps;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getAdderss() {
        return Adderss;
    }

    public String getEmail() {
        return Email;
    }

    public int getPhone() {
        return Phone;
    }

    public String getGoogleMaps() {
        return GoogleMaps;
    }

    public int getCapacity() {
        return capacity;
    }
    
}
