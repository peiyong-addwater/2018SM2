
public class lab3q2
{
    public static void main(String [] args)
    {
        int size = 11;
        int[] integerList = new int[size];
        for (int i = 0; i < size; i++)
        {
            integerList[i] = i;
        }

        for (int m = 0; m < size; m ++)
        {
            if(m == 0) {System.out.print("*");System.out.print('|'); System.out.print('\t');}
            else if(m==size-1) {System.out.println(m);}
            else {System.out.print(m);System.out.print('|');System.out.print('\t');}
        }
        /*System.out.println("fjla");*/
        for (int n = 1; n < size; n++)
        {
            System.out.print(n);
            System.out.print('\t');
            for (int o = 1; o < size; o++)
            {
                int output = n * integerList[o];
                if (o==size-1){System.out.println(output);}
                else {System.out.print(output);System.out.print('\t');}
            }
        }

    }
}