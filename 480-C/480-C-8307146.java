import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), a = input.nextInt()-1, b = input.nextInt()-1, k = input.nextInt();
    int[] dp = new int[n];
    dp[a] = 1;
    for(int i = 0; i<k; i++)
    {
        int[] csum = csum(dp);
        //System.out.println(Arrays.toString(dp));
        int[] next = new int[n];
        for(int j = 0; j<n; j++)
        {
            if(j == b) continue;
            int min = -1, max = -1;
            if(j < b)
            {
                min = 0;
                max = (j+b-1)/2;
            }
            else
            {
                max = n-1;
                min = (j+b)/2+1;
            }
            //int maxDist = Math.abs(b - j) - 1;
            //int min = Math.max(0, j - maxDist);
            //int max = Math.min(n-1, j + maxDist);
            //System.out.println(j+" "+min+" "+max+" "+query(csum, min, max)+" "+dp[j]);
            int nn = query(csum, min, max) - dp[j];
            if(nn < 0) nn += mod;
            next[j] = nn;
        }
        dp = next;
    }
    //System.out.println(Arrays.toString(dp));
    System.out.println(csum(dp)[n-1]);
}
static int[] csum(int[] a)
{
    int n = a.length;
    int[] res = new int[n];
    res[0] = a[0];
    for(int i = 1; i<n; i++) res[i] = (a[i] + res[i-1])%mod;
    return res;
}
static int query(int[] csum, int a, int b)
{
    int res = csum[b];
    if(a > 0) res -= csum[a-1];
    if(res < 0) res += mod;
    return res;
}
static int mod = 1000000007;
}