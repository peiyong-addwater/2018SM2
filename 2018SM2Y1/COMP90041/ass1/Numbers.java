/*
COMP90041 First Assessed Exercise
Author : Peiyong Wang
StudentID: 955986
*/
public class Numbers
{
    public static void calculateResults (int a, int b)
    {
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        System.out.println(sum);
        System.out.println(difference);
        System.out.println(product);
        System.out.println(quotient);
        System.out.println(remainder);

        return;
    }

    public static void main (String [] args)
    {
        int firstInput = Integer.parseInt(args[0]);
        int secondInput = Integer.parseInt(args[1]);
        calculateResults(firstInput, secondInput);
    }
}