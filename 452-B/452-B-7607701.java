import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    if(n == 0)
    {
        System.out.println(0+" "+(m-1));
        System.out.println(0+" "+0);
        System.out.println(0+" "+m);
        System.out.println(0+" "+1);
    }
    else if(m == 0)
    {
        System.out.println((n-1)+" "+0);
        System.out.println("0 0");
        System.out.println(n+" "+0);
        System.out.println(1+" "+0);
    }
    else
    {
        double d1 = Math.max(n, m) + Math.sqrt(n*n + m*m) * 2;
        double d2 = 2 * Math.sqrt(Math.max(n, m) * Math.max(n, m) + Math.min(m-1, n-1) * Math.min(m-1, n-1));
        d2 += Math.sqrt(Math.max(n, m) * Math.max(n, m) + Math.min(m, n) * Math.min(m, n));
        double d3 = Math.sqrt(Math.max(n, m) * Math.max(n, m) + Math.min(m-1, n-1) * Math.min(m-1, n-1)) + Math.sqrt(n*n + m*m);
        d3 +=  Math.sqrt(Math.max(n-1, m-1) * Math.max(n-1, m-1) + Math.min(m, n) * Math.min(m, n));
        //System.out.println(d1+" "+d2);
        if(d1 > d2 && d1 > d3 || n < 2 || m < 2)
        {
            System.out.println("0 0");
            System.out.println(n+" "+m);
            if(m < n)
            {
                System.out.println(0+" "+m);
                System.out.println(n+" "+0);
            }
            else
            {
                System.out.println(n+" "+0);
                System.out.println(0+" "+m);
            }
        }
        else if(d2 > d3)
        {
            
            if(m < n) System.out.println(n+" "+(m-1));
            else System.out.println((n-1)+" "+m);
            System.out.println("0 0");
            System.out.println(n+" "+m);
            if(m < n) System.out.println(0+" "+1);
            else System.out.println(1+" "+0);
        }
        else
        {
            System.out.println(n+" "+(m-1));
            System.out.println("0 0");
            System.out.println(n+" "+m);
            System.out.println(1+" "+0);
        }
    }
}
}