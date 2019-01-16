public class lab3q1
{
    public static void printDegrees(String s)
    {
        char firstChar = s.charAt(0);
        String degree;
        switch (firstChar)
        {
            case 'N': degree = "0";
            break;
            case 'E': degree = "90";
            break;
            case 'S': degree = "180";
            break;
            case 'W': degree = "270";
            break;
            default: degree = "Invalid character";
            break;
        }
        System.out.println(degree);
        
    }
    public static void main(String [] args)
    {
        String input = args[0];
        printDegrees(input);
    }
}