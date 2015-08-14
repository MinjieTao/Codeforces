import java.util.*;
public class e {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long t = input.nextLong(), a = input.nextLong(), b = input.nextLong();
    if(t == 1)
    {
        if(a == 1 && b == 1)
        {
            System.out.println("inf");
        }
        else if(a == 1)
        {
            System.out.println(0);
        }
        else
        {
            boolean good = false;
            long cur = a;
            while(cur < 2e18 / a)
            {
                cur *= a;
                if(cur == b) good = true;
            }
            if(a == b) good = true;
            if(good) System.out.println(1);
            else
            {
                long sum = 0;
                while(b > 0)
                {
                    sum += b%a;
                    b /= a;
                }
                if(sum == a) System.out.println(1);
                else System.out.println(0);
            }
        }
    }
    else if(a == 1)
    {
        if(b == 1) System.out.println(1);
        else System.out.println(0);
    }
    else
    {
        long ca = a, cb = b;
        boolean good = true;
        long res = 0;
        if(a == b) res++;
        while(ca > 0 || cb > 0)
        {
            if(ca%t != cb % a) good = false;
            ca /= t;
            cb /= a;
        }
        if(good) res++;
        System.out.println(res);
    }
}
}