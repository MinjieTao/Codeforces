import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        boolean[] primes = new boolean[1000001];
        Arrays.fill(primes,  true);
        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i<= 1000000; i++)
        {
            if(!primes[i])
                continue;
            for(long x = (long)i*i; x<= 1000000; x+= i)
                primes[(int)x] = false;
        }
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] data = new long[n];
        for(int i = 0; i<n; i++) data[i] = input.nextLong();
        for(int i = 0; i<n; i++)
        {
            if(Math.sqrt(data[i]) != (int)Math.sqrt(data[i]))
                System.out.println("NO");
            else
            {
                System.out.println(primes[(int)Math.sqrt(data[i])] ? "YES" : "NO");
            }
        }
    }
}