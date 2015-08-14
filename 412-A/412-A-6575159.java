import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt()-1;
    int copy = k;
    String s = input.next();
    if(k < n/2)
    {
        while(k > 0)
        {
            System.out.println("PRINT " + s.charAt(k));
            System.out.println("LEFT");
            k--;
        }
        System.out.println("PRINT " + s.charAt(k));
        while(k <= copy && k < n-1)
        {
            System.out.println("RIGHT");
            k++;
        }
        while(k<n)
        {
            if(k>copy) System.out.println("PRINT " + s.charAt(k));
            if (k<n-1)System.out.println("RIGHT");
            k++;
        }
    }
    else
    {
        while(k < n-1)
        {
            System.out.println("PRINT " + s.charAt(k));
            System.out.println("RIGHT");
            k++;
        }
        System.out.println("PRINT " + s.charAt(n-1));
        while(k >= copy && k > 0)
        {
            System.out.println("LEFT");
            k--;
        }
        while(k>=0)
        {
            if(k < copy) System.out.println("PRINT " + s.charAt(k));
            if (k > 0)System.out.println("LEFT");
            k--;
        }
    }
}
}