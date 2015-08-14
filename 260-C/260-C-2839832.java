import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n= input.nextInt(), x = input.nextInt()-1;
    long[] data = new long[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    int mindex = 0, min = (int)1e9+1;
    for(int i = 0; i<n; i++)
    {
        int at = (x-i+n)%n;
        if(data[at] < min)
        {
            mindex =at;
            min = (int)data[at];
        }
    }
    long[] data2 = new long[n];
    for(int i = 0; i<n; i++) data2[i] = data[i];
    long balls = (long)n*min + (x+n-mindex)%n;
    //System.out.println(balls);
    data2[mindex] = balls;
    boolean found = false;
    int at = mindex;
    if(at == x) found = true;
    for(int i = 0; i<n-1; i++)
    {
        at++;
        at%=n;
        long toSub = min+1;
        if(found) toSub--;
        if(at == x) found = true;
        data2[at] -= toSub;
    }
    for(long i: data2) System.out.print(i+" ");
}
}