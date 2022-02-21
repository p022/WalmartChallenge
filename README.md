# Movie Theater Seating Challenge

## Problem Statement
Implement an algorithm for assigning seats within a movie theater to fulfill reservation requests. Seat assignment algorithm should maximize both customer satisfaction and customer safety.

## Assumption
The algorithm follows following rules:
1. The algorithm is developed for one screen for the layout where, row J is farthest from the screen and A is the closest to the screen.
2. Customers that come first will be allocated seats starting from the back/top row(First come first serve). If seats are available in any of the top rows, then, they will be allotted keeping a gap of atleast 3 seats in the same row.
3. For the purpose of public safety, alternate rows have already been marked as unavailable before reservations are even accepted.
4. Each group will be allocated seats in a single row. Try to keep reservation parties together, however, if seats are not available in a single row, then, inform the customer about insufficient seats.
5. We assume that the maximum seats a customer can request cannot be greater than the total number of seats in the screen's row(For example, user cannot request more than 20 seats). 
6. Full fill as many requests as possible.

### How are the goals of the problem statement achieved?

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

```
