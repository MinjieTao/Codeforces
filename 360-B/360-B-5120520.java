import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    long lo = -1, hi = (int)(2e9+1);
    while(lo < hi-1)
    {
        long mid = (lo+hi)/2;
        if(possible(data, k, mid)) hi =mid;
        else lo = mid;
    }
    System.out.println(hi);
}
static boolean possible(int[] data, int k, long x)
{
    int n = data.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1000000000);
    for(int i = 0; i<n; i++) dp[i] = i;
    for(int i =0; i<n; i++)
    {
        if(dp[i] + (n-1-i) <= k) return true;
        for(int j = i+1; j<n; j++)
        {
            boolean okay = Math.abs(data[j] - data[i]) <= x*(j-i);
            if(okay) dp[j] = Math.min(dp[j], dp[i] + (j-i-1));
            //else dp[j] = Math.min(dp[j], dp[i] + j-i);
        }
    }
    //System.out.println(x+" "+Arrays.toString(dp));
    return (dp[n-1] <= k);
}
}