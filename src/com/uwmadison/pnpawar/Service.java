package com.uwmadison.pnpawar;

public class Service {
    /**
     * It books seats for the particular reservation
     * @param screen object of the selected screen
     * @param reservation object with ID and number of tickets in the booking
     */
    public void bookSeats(Screen screen, Reserve reservation){
        // Condition to check if theatre permits for more bookings.
        if(screen.getOccupancy() + reservation.getNumTickets() > screen.maximumCapacity){
            reservation.setErrorMessage("Cannot Accept Reservation. Screen full.");
            return;
        }
        // Condition to check non positive number of tickets.
        if(reservation.getNumTickets() <= 0){
            reservation.setErrorMessage("Cannot accept reservation. Invalid Number of tickets");
            return;
        }
        // Condition to check more than our limit for a reservationId
        if(reservation.getNumTickets() > screen.getSeatsPerRow()){
            reservation.setErrorMessage("Cannot accept reservation. Large number of tickets in reservation.");
            return;
        }
        else{
            int[][] arrangement = screen.getSeatingArrangement();
            int rows = arrangement.length;
            int seats = arrangement[0].length;
            boolean isUnavailable = true;
            for(int i=0;i<arrangement.length;i++){
                // Checking for rows that are blocked to maintain safety.
                if(arrangement[i][0] == -1){
                    continue;
                }
                //Getting first empty seat in the given row.
                int firstEmptySeat = getFirstEmptySeat(arrangement[i]);
                // Checking if a booking can be completed in a row at once.
                boolean isSeatAvailable = checkAvailability(arrangement[i], firstEmptySeat, reservation.getNumTickets());

                if (!isSeatAvailable){
                    continue;
                }
                // If booking can be done making the unavailability flag false.
                isUnavailable = false;
                // Looping to book seats for a reservation Id and store the ID of the seat.
                for(int person=0;person<reservation.getNumTickets();person++){
                    arrangement[i][firstEmptySeat] = 1;
                    String new_seat = "" + (char) ('A' + rows - i - 1) + (firstEmptySeat+1);
                    reservation.addSeat(new_seat);
                    firstEmptySeat++;
                }
                // Maintaining seat gap between each booking.
                int seatGap = screen.getSeatGap();
                while(firstEmptySeat<seats && seatGap > 0){
                    arrangement[i][firstEmptySeat] = -1;
                    firstEmptySeat++;
                    seatGap = seatGap - 1;
                }
                //Updating the Occupancy of the screen.
                screen.setOccupancy(screen.getOccupancy() + reservation.getNumTickets());
                //Updating the seating arrangement of the screen
                screen.setSeatingArrangement(arrangement);
                break;
            }

            if(isUnavailable){
                reservation.setErrorMessage("Cannot Accept Reservation. Not enough seats in a single row.");
            }
        }
    }

    /**
     * It gets the first empty seat in the row if exists.
     * @param row row in the theatre
     * @return returns the index of the empty seat or the row length.
     */
    private int getFirstEmptySeat(int[] row){
        for(int i = 0;i<row.length;i++){
            if(row[i] == 0){
                return i;
            }
        }
        return row.length;
    }

    /**
     * It checks whether there is availability of seats in the row for particular booking.
     * @param row row in the theatre
     * @param emptySeatIndex index of the empty seat in the row
     * @param numTickets number of tickets in the booking
     */
    private boolean checkAvailability(int[] row, int emptySeatIndex, int numTickets){
        int availableSeats = row.length - emptySeatIndex;
        return (numTickets <= availableSeats);
    }

}
