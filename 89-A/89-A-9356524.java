import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    if(n == 1)
    {
        System.out.println(Math.min(data[0], (long)m*k));
    }
    else if(n == 2)
    {
        System.out.println(0);
    }
//  else if(n == 3)
//  {
//      System.out.println(Math.min((data[0] + data[2])/2, (long)m/2*k));
//  }
    else if(n%2 == 0) System.out.println(0);
    else
    {
        long min = (long)m/(n/2+1)*k;
        for(int i = 0; i<n; i+=2) min = Math.min(min,  data[i]);
        System.out.println(min);
    }
}
}