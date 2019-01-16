import java.util.Scanner;

public class lab_two{
    public static void main(String [] args){
      Scanner input = new Scanner(System.in);
      System.out.println("Please type a line of words, seperated by one space >>>");
      String line = input.nextLine();
      input.close();
      int lineLength = line.length();
      System.out.println("The length of the input is "+ lineLength);
      String seperated[] = line.split(" ", 2);
      String out1 = seperated[0];
      System.out.println(out1);
      String out2 = " " + seperated[1];
      System.out.println(out2);

  }
}
