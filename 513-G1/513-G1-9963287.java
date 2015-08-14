import java.util.*;
public class g {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    k = Math.min(k, 900);
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    double[][] dp = new double[n][n];
    double[][] next = new double[n][n];
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
            dp[i][j] = data[i] > data[j] ? 1 : 0;
    for(int iter = 0; iter < k; iter++)
    {
        for(int i = 0; i<n; i++)
            for(int j = i+1; j<n; j++)
            {
                next[i][j] = (i*(i+1) + (n-j)*(n-j-1) + (j-i)*(j-i-1))/2 * dp[i][j]; // Neither of them is affected.
                for(int x = j; x < i+n; x++)
                {
                    int right = Math.min(i, x - j);
                    int left = Math.max(0, x - (n-1));
                    next[i][j] += (right - left + 1) * (1 - dp[x-j][x-i]);
                }
                for(int x = i; x < i+j; x++)
                {
                    int right = Math.min(i, x - i);
                    int left = Math.max(0, x - (j - 1));
                    next[i][j] += (right - left + 1) * dp[x-i][j];
                }
                for(int x = j+i+1; x<j+n; x++)
                {
                    int left = Math.max(i+1, x - (n-1));
                    int right = Math.min(j, x - j);
                    next[i][j] += (right - left + 1) * dp[i][x - j];
                }
                //System.out.println(next[i][j]);
                next[i][j] /= (n*(n+1)/2);
            }
        for(int i = 0; i<n; i++)
            for(int j = i+1; j<n; j++)
                dp[i][j] = next[i][j];
    }
    double res = 0;
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
        {
            //System.out.println(dp[i][j]);
            res += dp[i][j];
        }
    System.out.println(res);
}
}