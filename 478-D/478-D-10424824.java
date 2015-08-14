import java.util.*;
public class D273 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int r = input.nextInt(), g = input.nextInt();
    int levels = 0;
    while((levels+1) * (levels+2) / 2 <= r+g) levels++;
    int[][] dp = new int[2][r+1];
    dp[0][0] = 1;
    int mod = (int)(1e9+7);
    for(int i = 1; i<=levels; i++)
        for(int j = 0; j<=r; j++)
        {
            dp[i&1][j] = 0;
            int k = i * (i + 1) / 2 - j;
            if(j >= i)
            {
                dp[i&1][j] += dp[(i^1)&1][j-i];
                if(dp[i&1][j] >= mod) dp[i&1][j] -= mod;
            }
            if(k <= g)
            {
                dp[i&1][j] += dp[(i^1)&1][j];
                if(dp[i&1][j] >= mod) dp[i&1][j] -= mod;
            }
        }
    long res = 0;
    for(int j = 0; j<= r; j++) res += dp[levels&1][j];
    System.out.println(res%mod);
}
}