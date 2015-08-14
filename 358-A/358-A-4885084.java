import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input =  new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    boolean good = true;
    for(int i = 0; i<n-1; i++)
        for(int j = i+1; j<n-1; j++)
        {
            int a = data[i], b = data[i+1], c = data[j], d = data[j+1];
            if(a>b)
            {
                int temp = a;
                a = b; b = temp;
            }
            if(c>d)
            {
                int temp = c;
                c = d; d = temp;
            }
            //System.out.println(a+" "+b+" "+c+" "+d);
            if(a < c && b > c && b < d || a > c && a<d && b>d) good = false;
        }
    System.out.println(good ? "no" : "yes");
}
}