package com.uwmadison.pnpawar;
import java.io.*;
import java.util.*;

public class Main {

    /**
     * It reads the input from the file and writes it into a reservations array
     * @param filename name of the file
     */
    public static List<Reserve> store_input(String filename) throws IOException {
        List<Reserve> reservations = new ArrayList<>();
        List<String> ids = new ArrayList<>(); // To store the IDs of the reservations
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                String[] splitLine = inputLine.split(" ");
                // If duplicate ID is encountered
                if (ids.contains(splitLine[0])) {
                    for(Reserve r: reservations){
                        // Update the number of tickets by taking sum
                        if(r.getID().equals(splitLine[0])){
                            r.setNumTickets(r.getNumTickets() + Integer.parseInt(splitLine[1]));
                        }
                    }
                } else {
                    ids.add(splitLine[0]);
                    Reserve newReservation = new Reserve(splitLine[0], Integer.parseInt(splitLine[1]));
                    reservations.add(newReservation);
                }
            }
        }
        return reservations;
    }

    /**
     * It prints out the reservations from a List of reservtions
     * @param reservations List that has the reservations
     */
    public static void showReservation(List<Reserve> reservations){
        for(Reserve r: reservations){
            System.out.println(r.toString());
        }
    }

    /**
     * It writes all the reservations in array to an output file
     * @param reservations List that has the reservations
     * @param filename name of the output file
     */
    public static String storeReservation(List<Reserve> reservations, String filename) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Reserve r : reservations) {
                writer.write(r.toString() + "\n");
            }
            return new String("Directory: " + System.getProperty("user.dir") + " Filename: " + filename);
        }
    }

    /**
     * It takes the input file and creates objects for the classes and performs necessary calls.
     * main method which handles the input and output.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws IOException {
        String inputFilename = args[0];
        List<Reserve> reservations = store_input(inputFilename);
        Screen screen = new Screen(10, 20, 3, 1);
        Service service = new Service();
        for(Reserve r: reservations){
            service.bookSeats(screen, r);
        }
        showReservation(reservations);
        String output_path = storeReservation(reservations, "output.txt");
        System.out.println(output_path);
        TestClass test = new TestClass();
        test.runAllTestCases();
    }
}
