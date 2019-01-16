import java.util.Scanner;

public class PlaceOrder
{
    public static void calculateAndShowResult(int quantity, String description, float unitPrice)
    {
        double totalPrice;
        double floatQuantity = quantity;
        totalPrice = floatQuantity * unitPrice;
        String captialDescription = description.toUpperCase();
        String outputLineOne = "Order for " + Integer.toString(quantity) + " " + captialDescription;
        System.out.println(outputLineOne);
        System.out.print("Total price ");
        System.out.printf("%14.2f", totalPrice);
        System.out.print('\n');
    }

    public static void main(String [] args)
    {
        Scanner inputs = new Scanner(System.in);
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(inputs.nextLine());
        System.out.print("Description: ");
        String description = inputs.nextLine();
        System.out.print("Unit price: ");
        float price =inputs.nextFloat();
        calculateAndShowResult(quantity, description, price);
    }
}