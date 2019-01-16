public class Primes
{
    public static int isPrime(int candidate)
    {
        if(candidate == 1)
        {
            return -1;
        }
        for(int k = 2; k < candidate; k++)
        {
            if (candidate % k == 0)
            {
                //System.out.println(i);
                return -1;
            }
        }

        return candidate;
    }

    public static void printPrimes(int low, int high)
    {
        int iterStart = low;
        for(int i = iterStart; i <= high; i++)
        {
            int res = isPrime(i);
            //System.out.println(res);
            if(res != -1)
            {
                System.out.println(res);
            }
        }
    }

    public static void main(String [] args)
    {
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);
        printPrimes(start, end);
    }
}