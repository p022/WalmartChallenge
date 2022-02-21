package com.uwmadison.pnpawar;
import java.util.ArrayList;
import java.util.List;

public class Reserve {
    private String ID;
    private List<String> seats;
    private String errorMessage;
    private int numTickets;

    /**
     * constructor for the class Reserve which initializes ID and numTickets.
     * @param id ReservationID.
     * @param numTickets numTickets in the reservation.
     */
    public Reserve(String id, int numTickets){
        ID = id;
        seats = new ArrayList<>();
        errorMessage = "";
        this.numTickets = numTickets;
    }

    /**
     * Method to update the seat number.
     * @param seatNo the seat number.
     */
    public void addSeat(String seatNo){
        seats.add(seatNo);
    }

    /**
     * Method to fetch the information of the reservation.
     * @return info the reservation information.
     */
    public String toString(){
        String info = ID + " ";
        if(errorMessage != ""){
            info = info + errorMessage;
        }
        if (!seats.isEmpty()) {
            info = info + seats.get(0);
            for(int i=1;i<seats.size();i++){
                info = info + "," + seats.get(i);
            }
        }
        return info;
    }

    /**
     * Getter method to get the ID of the reservation.
     * @return returns the ID.
     */
    public String getID(){
        return ID;
    }

    /**
     * Setter method to update the number of tickets encountered during duplicates.
     * @param number the new number.
     */
    public void setNumTickets(int number){
        numTickets = number;
    }

    /**
     * Getter method to get the number of tickets in the reservation.
     * @return returns the numTickets.
     */
    public int getNumTickets(){
        return numTickets;
    }

    /**
     * Setter method to update the errorMessage encountered during booking.
     * @param message the error message.
     */
    public void setErrorMessage(String message){
        errorMessage = message;
    }

    /**
     * Getter method to get the errorMessage encountered during booking.
     * @return returns the error message.
     */
    public String getErrorMessage(){
        return errorMessage;
    }
}
