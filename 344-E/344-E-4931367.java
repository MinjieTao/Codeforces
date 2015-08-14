import java.util.*;
public class c {
    static int n, m;
    static long[] ss, es;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    m = input.nextInt();
    ss = new long[n];
    es = new long[m];
    for(int i = 0; i<n; i++) ss[i] = input.nextLong();
    for(int i = 0; i<m; i++) es[i] = input.nextLong();
    long lo = 0, hi = (long)1e18;
    while(lo < hi-1)
    {
        long mid = (lo+hi)/2;
        if(possible(mid)) hi = mid;
        else lo = mid;
    }
    if(!possible(lo)) lo++;
    System.out.println((lo));
}
static boolean possible(long t)
{
    int pm = 0;
    for(int i = 0; i<n; i++)
    {
        long needed = ss[i] - es[pm];
        if(needed > t) return false;
        long max = needed < 0 ? ss[i] + t : Math.max((t - needed) + es[pm], ss[i]+(t-needed)/2);
        while(pm < m && es[pm] <= max) pm++;
        if(pm == m) return true;
    }
    return false;
}
}