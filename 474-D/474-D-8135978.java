import java.util.*;
public class d {
    static int mod = (int)1e9+7;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int T = input.nextInt(), k = input.nextInt();
    long[][] dp = new long[100001][2];
    dp[0][1] = 1;
    for(int i = 1; i<dp.length; i++)
    {
        dp[i][1] = (dp[i-1][0] + dp[i-1][1])%mod;
        dp[i][0] = i >= k ? (dp[i-k][1] + dp[i-k][0]) : 0;
    }
    long[] sum = new long[dp.length];
    sum[0] = 1;
    for(int i = 1; i<sum.length; i++)
    {
        sum[i] = (dp[i][0] + dp[i][1])%mod;
        sum[i] = (sum[i] + sum[i-1])%mod;
    }
    //for(int i = 0; i<10; i++) System.out.println(sum[i]);
    for(int i = 0; i<T; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        System.out.println((sum[b] - sum[a-1] + mod)%mod);
    }
}
}