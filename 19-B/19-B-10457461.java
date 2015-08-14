import java.util.*;
public class B19 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] ts = new int[n], cs = new int[n];
    for(int i = 0; i<n; i++)
    {
        ts[i] = input.nextInt(); cs[i] = input.nextInt();
    }
    long[][] dp = new long[n+1][n+1];
    for(long[] A : dp) Arrays.fill(A, (long)1e18);
    dp[0][0] = 0;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<=n; j++)
        {
            dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
            int nj = Math.min(j+ts[i]+1, n);
            dp[i+1][nj] = Math.min(dp[i+1][nj], dp[i][j] + cs[i]);
        }
    System.out.println(dp[n][n]);
}
}