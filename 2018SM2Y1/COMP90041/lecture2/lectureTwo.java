import java.util.Scanner;

public class lectureTwo{
  public static void main(String[] args){
    System.out.print("Hello, Bobby\n");
    String bob = "Bob Smith";
    System.out.println(bob);
    System.out.println(bob.length());
    System.out.printf("Bob has $%.2f in his pocket\n", 35f);
    System.out.println("Hello, "+args[0]+'!');
    System.out.println("Type a number or something >");
    Scanner scan = new Scanner(System.in);
    String ouf = scan.nextLine();
    System.out.println(args[0]+" on "+ouf);
  }
}
