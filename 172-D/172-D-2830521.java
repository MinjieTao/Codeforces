import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(),n = input.nextInt();
    int[] sieve = new int[10000001];
    for(int i = 0; i<sieve.length; i++) sieve[i] = i;
    for(int i = 2; i<sieve.length; i++)
    {
        if(sieve[i] == i)
        {
            for(long lo = (long)i*i; lo < sieve.length; lo += i)
                sieve[(int)lo] = i;
        }
    }
    long total = 0;
    for(int i = a; i < a+n; i++)
    {
        long pieces = 1;
        int at = i;
        while(at > 1)
        {
            int f = sieve[at];
            if(pieces % f == 0)
            {
                pieces /= f;
            }
            else
                pieces *= f;
            at /= sieve[at];
        }
        total += pieces;
    }
    System.out.println(total);
}
}