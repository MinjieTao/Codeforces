import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    int min = 987654321;
    int mindex = -1;
    int[] a = new int[n];
    for(int i = 0; i<n; i++) a[i] = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        if(a[i] - i*k <= 0) continue;
        int count = 0;
        for(int j = 0; j<n; j++)
        {
            if(a[i] - a[j] != k*(i-j)) count++;
        }
        if(count < min)
        {
            min = count;
            mindex = i;
        }
    }
    System.out.println(min);
    for(int i = 0; i<n; i++)
    {
        if(a[mindex] - a[i] != k*(mindex - i))
        {
            int diff = k*(mindex-i) - (a[mindex] - a[i]);
            if(diff > 0) System.out.println("- "+(i+1)+" "+diff);
            else System.out.println("+ "+(i+1)+" "+(-diff));
        }
    }
}
}