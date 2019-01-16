/*
COMP90041 First Assessed Exercise
Author : Peiyong Wang
StudentID: 955986
*/
public class Greetings
{
    public static void main (String [] args)
    {
        String someName = args[0];
        String somePlace = args[1];
        String outPutOne = "Hello " + someName + " " + "from " + somePlace +".";
        String upperCasePlace = somePlace.toUpperCase();
        String outPutTwo = "I'VE ALWAYS WANTED TO GO TO " + upperCasePlace + ".";
        System.out.println(outPutOne);
        System.out.println(outPutTwo); 
    }
}