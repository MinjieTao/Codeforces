import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double p = input.nextDouble();
    int t = input.nextInt();
    double[][] dp = new double[t+1][n+1];
    dp[0][0] = 1;
    for(int i = 0; i<t; i++)
    {
        for(int j = 0; j<n; j++)
        {
            dp[i+1][j] += dp[i][j] * (1 - p);
            dp[i+1][j+1] += dp[i][j] * p;
        }
        dp[i+1][n] += dp[i][n];
    }
    double res = 0;
    for(int i = 0; i<=n; i++) res += i * dp[t][i];
    System.out.println(res);
}
}