# Movie Theater Seating Challenge

## Problem Statement
Implement an algorithm for assigning seats within a movie theater to fulfill reservation requests. Seat assignment algorithm should maximize both customer satisfaction and customer safety.

## Assumption
The algorithm follows following rules:
1. The algorithm is developed for one screen for the layout where, row J is farthest from the screen and A is the closest to the screen.
2. Customers that come first will be allocated seats starting from the back/top row(First come first serve). If seats are available in any of the top rows, then, they will be allotted keeping a gap of atleast 3 seats in the same row.
3. For the purpose of public safety, alternate rows have already been marked as unavailable.
4. Each group will be allocated seats in a single row. Try to keep reservation parties together, however, if seats are not available in a single row, then, inform the customer about insufficient seats.
5. We assume that the maximum seats a customer can request cannot be greater than the maximum number of seats in the screen's row(For example, user cannot request more than 20 seats). 
6. Full fill as many requests as possible.

### How are the goals of seat allocation achieved?

_Customer Satisfaction:_
1. Seats will be allotted from the top row for a better viewing appearence.
2. Since customers are reserving seats for groups, priority will be to allocate seats for the group in a single row.

_Customer Safety:_
1. Seats will be allotted keeping a gap of atleast 3 seats in the same row.
2. For safety, buffer seats in alternate rows.

## Steps for running code

1. Download and save the src folder in a directory.
2. Compile all the java files Main.java, Reserve.java, Screen.java, Service.java and TestClass.java
3. Go to the command line inside the folder where you have stored the src folder and compile the files using the following command: javac
For example:    
```
javac Main.java
```
4. Go into the src folder through the command prompt and run the program with the following command:   
```
java Main C:/Users/Patron/spring/WalmartChallenge/src/com/uwmadison/pnpawar/input.txt
```

## Class Design:

1. Main.java: main/driver class for handling the input and output.
2. Reserve.java: class object stores the information of each reservation made.
3. Screen.java: class initializes the screen arrangement and stores its information after each reservation is made.
4. Service.java: class to make a reservation via the _bookSeats_ interface.
5. TestClass.java: class called to run all the test cases.

## Sample Input:
```
R001 21
R002 20
R003 12
R004 13
R005 9
R006 4
R007 20
R008 8
R009 5
R010 15
```

## Sample Output:
```
R001 Cannot accept reservation. Large number of tickets in reservation.
R002 J1,J2,J3,J4,J5,J6,J7,J8,J9,J10,J11,J12,J13,J14,J15,J16,J17,J18,J19,J20
R003 H1,H2,H3,H4,H5,H6,H7,H8,H9,H10,H11,H12
R004 F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,F11,F12,F13
R005 D1,D2,D3,D4,D5,D6,D7,D8,D9
R006 H16,H17,H18,H19
R007 B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14,B15,B16,B17,B18,B19,B20
R008 D13,D14,D15,D16,D17,D18,D19,D20
R009 Cannot Accept Reservation. Not enough seats in a single row.
R010 Cannot Accept Reservation. Screen full.
```
