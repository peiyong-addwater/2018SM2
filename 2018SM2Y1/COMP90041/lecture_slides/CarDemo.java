package cardemo;

import java.util.Scanner;

public class CarDemo
{

    private static Point_2D origin = null;//new Point_2D();
    private static Scanner kbd = new Scanner(System.in);
    
    // added value to control car loop number (removing magic number)
    private static final int NUM_OF_TESTS = 5;

    public static void main(String[] args)
    {

        Car[] cars = new Car[5];

        cars[0] = new Car(1, 1);
        cars[1] = new Car(6, 5);
        cars[2] = new Car(3, 5);
        cars[3] = new Truck(4, 3);
        cars[4] = new RaceCar(9, 6);
        System.out.println("List of objects created in array car:");
        for (Car c : cars)
        {
            System.out.println(c.getClass().getSimpleName() + " " + c);
        }
        // adds clear line before prompting user for direction
        System.out.println("");


        for (Car car : cars)
        {
            // added internal loop to allow each Car object to be tested 5 times
            for (int i = 0; i < NUM_OF_TESTS; i++)
            {
                moveCar(car, prompt(car));
            }
            System.out.println("\nNext Vehicle");
        }
    }

    // this needs to be changed to take the new string returned by prompt 
    // public static void moveCar(Car car, char dir)
    public static void moveCar(Car car, String input)
    {
        // moved from promt to moveCar
        Direction dir = Direction.fromString(input); // Got to here in class L9
 
        if (dir != null) // check for null because invalid value returns null
        {
            car.move(dir);
        }

        System.out.printf("Moving Car %s to [x%d, y%d]%n", 
                car.toString(), car.getX(), car.getY());

    }

    // changed return from char to string, only to return the complete inputted 
    // value rom the users input.  old code - private static char prompt()
    // Now, prompt simply prompts the user and returns the inputted value
    private static String prompt(Car car)
    {
        // altered prompt to show which car is being asked to be moved
        System.out.printf("Enter direction for %s %d: ", car.getClass().getSimpleName(), car.getId());
 
       // old code - String input = kbd.nextLine();
        //simply return the inputed value from the scanner input
        return kbd.nextLine();

        // removed other code extracting the first letter because it will now be 
        // controlled thorugh the enum
    }

}
