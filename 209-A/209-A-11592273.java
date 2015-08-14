import java.util.*;
public class a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] dp = new int[n+1];
        for(int i = 1; i<=n; i++)
        {
            dp[i] = 2 + dp[i-1];
            if(i == 1) dp[i]--;
            if(i > 1) dp[i] += dp[i-2];
            dp[i] %= 1000000007;
        }
        System.out.println(dp[n]);
    }
}