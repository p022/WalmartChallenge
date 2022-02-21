package com.uwmadison.pnpawar;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestClass {
    /**
     * It tests the case in which a reservation has more than 20 tickets
     */
    public void largeGroupTesting(){
        Screen screen = new Screen(10, 20, 3, 1);
        Service service = new Service();
        Main main = new Main();
        System.out.println();
        System.out.println("Testcase for Max bookings for a user");
        Reserve r1 = new Reserve("R001", 21);
        Reserve r2 = new Reserve("R002", 20);
        Reserve[] reservations = {r1, r2};
        for(Reserve r: reservations){
            service.bookSeats(screen, r);
        }
        main.showReservation(Arrays.asList(reservations));
        System.out.println("When a large group comes in for reservation, the reservation is not accepted");
        System.out.println("==============================");

    }

    /**
     * It tests the case in which a reservation cannot be booked since there are more than 20 tickets in a row
     */
    public void availabilityPerRowTesting(){
        Screen screen = new Screen(10, 20, 3, 1);
        Service service = new Service();
        Main main = new Main();
        Reserve r1 = new Reserve("R001", 10);
        Reserve r2 = new Reserve("R002", 10);
        Reserve r3 = new Reserve("R003", 10);
        Reserve r4 = new Reserve("R004", 10);
        Reserve r5 = new Reserve("R005", 10);
        Reserve r6 = new Reserve("R006", 7);
        Reserve r7 = new Reserve("R007", 8);
        Reserve[] reservations = {r1, r2, r3, r4, r5, r6, r7};

        System.out.println();
        System.out.println("Testcase for booking to be done in single row");
        for(Reserve r: reservations){
            service.bookSeats(screen, r);
        }
        main.showReservation(Arrays.asList(reservations));
        System.out.println("When a row does not have enough seats for a group, the reservation is not accepted");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which a reservation has negative number of tickets
     */
    public void negativeNumberOfTicketsTesting(){
        Screen screen = new Screen(10, 20, 3, 1);
        Service service = new Service();
        Main main = new Main();
        System.out.println();
        System.out.println("Testcase for negative no of tickets for a reservation");
        Reserve r1 = new Reserve("R001", -10);
        service.bookSeats(screen, r1);
        main.showReservation(Arrays.asList(new Reserve[]{r1}));
        System.out.println("When a negative number of tickets are encountered, message is presented");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which a reservation has 0 number of tickets
     */
    public void zeroNumberOfTicketsTesting(){
        Screen screen = new Screen(10, 20, 3, 1);
        Service service = new Service();
        Main main = new Main();
        System.out.println();
        System.out.println("Testcase for zero no of tickets for a reservation");
        Reserve r1 = new Reserve("R001", 0);
        service.bookSeats(screen, r1);
        main.showReservation(Arrays.asList(new Reserve[]{r1}));
        System.out.println("When number of tickets is 0, message is presented");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which the inputFile name is not given
     */
    public void nullFilenameTesting() throws IOException {
        System.out.println();
        System.out.println("Testcase for passing a null file");
        try {
            String inputFilename = null;
            Main main = new Main();
            List<Reserve> reservations = main.store_input(inputFilename);
        }
        catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("When no file is passed as an input, NullPointerException is thrown");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which the inputFile does not exist.
     */
    public void nonExistentFileTesting() throws IOException {
        System.out.println();
        System.out.println("Testcase for passing a non existing file");
        try {
            String inputFilename = "xyz.txt";
            Main main = new Main();
            List<Reserve> reservations = main.store_input(inputFilename);
        }
        catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
        System.out.println("When a file that does not exist is passed, FileNotFound exception is thrown");
        System.out.println("==============================");
    }

    /**
     * It tests the case in which the inputFile contains duplicate values for ReservationID
     */
    public void duplicateReservations() throws IOException{
        System.out.println();
        System.out.println("Testcase for duplicate reservations for an ID");

        Main main = new Main();
        List<Reserve> reservations = main.store_input(System.getProperty("user.dir") + "\\src\\com\\uwmadison\\pnpawar\\input.txt");
        Screen screen = new Screen(10, 20, 3, 1);
        Service service = new Service();
        for(Reserve r: reservations){
            service.bookSeats(screen, r);
        }
        main.showReservation(reservations);
        System.out.println("When a file contains duplicate reservations, the sum of number of tickets is taken and treated as a single group");
        System.out.println("==============================");
    }

    /**
     * It runs all the test case functions.
     */
    public void runAllTestCases() throws IOException{
        System.out.println("==============================");
        System.out.println("Running all test cases");
        System.out.println("==============================");
        largeGroupTesting();
        availabilityPerRowTesting();
        negativeNumberOfTicketsTesting();
        zeroNumberOfTicketsTesting();
        nullFilenameTesting();
        duplicateReservations();
        nonExistentFileTesting();
    }
}
