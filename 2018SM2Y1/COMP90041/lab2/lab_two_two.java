import java.util.Arrays;

import sun.jvm.hotspot.utilities.IntArray;

public class lab_two_two{
    public static void main (int  args[]){
        System.out.print("Type to integers for compution");
        if (args.length > 2){
            System.out.println("Number of integers is more than 2.");
            
        }
        else if (args.length < 2){
            System.out.println("Number of integers is less than 2.");
        }
        else{
            int ans = int args[0]+ int args[1];
            System.out.println("The product of two integers is "+ ans);
        }

        }
    }