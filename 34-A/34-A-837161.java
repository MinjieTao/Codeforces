import java.util.*;
public class Reconnaissance2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] h = new int[n];
    for(int i = 0; i<n; i++)
        h[i] = input.nextInt();
    int min = 100000;
    int mindex1 = 0;
    int mindex2 = 0;
    for(int i = 0; i<n; i++)
        {
        int j = i+1;
            if(Math.abs(h[i]-h[j%n])<min)
            {
                min = Math.abs(h[i]-h[j%n]);
                mindex1 = i;
                if(j==n)
                    j = 0;
                mindex2 = j;
            }
        }

    System.out.println(mindex2+1 + " " + (int)(mindex1+1));
}
}