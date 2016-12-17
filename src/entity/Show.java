/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Etti
 */
public class Show {
    private int showNumber;
    private String mainArtist;
    private Date dateAndHourOfShow;
    private int placeNumber;
    private String status;
    private int ticketPrice;
    private int minimumAge;
    private int numberOfLeftTickets;

    // ---------------------------constractor--------------------------------
    public Show(int showNumber, String mainArtist, Date dateAndHourOfShow, int placeNumber, String status, int ticketPrice, int minimumAge, int numberOfLeftTickets) {
        this.showNumber = showNumber;
        this.mainArtist = mainArtist;
        this.dateAndHourOfShow = dateAndHourOfShow;
        this.placeNumber = placeNumber;
        this.status = status;
        this.ticketPrice = ticketPrice;
        this.minimumAge = minimumAge;
        this.numberOfLeftTickets = numberOfLeftTickets;
    }
    //--------------------------getters&setters------------------------------
    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }

    public void setMainArtist(String mainArtist) {
        this.mainArtist = mainArtist;
    }

    public void setDateAndHourOfShow(Date dateAndHourOfShow) {
        this.dateAndHourOfShow = dateAndHourOfShow;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public void setNumberOfLeftTickets(int numberOfLeftTickets) {
        this.numberOfLeftTickets = numberOfLeftTickets;
    }

    public int getShowNumber() {
        return showNumber;
    }

    public String getMainArtist() {
        return mainArtist;
    }

    public Date getDateAndHourOfShow() {
        return dateAndHourOfShow;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public String getStatus() {
        return status;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public int getNumberOfLeftTickets() {
        return numberOfLeftTickets;
    }
}
