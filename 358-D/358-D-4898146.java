import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] as = new int[n], bs = new int[n], cs = new int[n];
    for(int i =0; i<n; i++) as[i] = input.nextInt();
    for(int i = 0; i<n; i++) bs[i] = input.nextInt();
    for(int i =0; i<n; i++) cs[i] = input.nextInt();
    int[][] dp = new int[n][2];
    dp[n-1][0] = as[n-1];
    dp[n-1][1] = bs[n-1];
    for(int i = n-2; i>=0; i--)
    {
        dp[i][0] = Math.max(as[i] + dp[i+1][1], bs[i] + dp[i+1][0]);
        dp[i][1] = Math.max(bs[i] + dp[i+1][1], cs[i] + dp[i+1][0]);
        //System.out.println(i+" "+dp[i][0]+" "+dp[i][1]);
    }
    System.out.println(dp[0][0]);
}
}