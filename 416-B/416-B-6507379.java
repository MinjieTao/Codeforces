import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int m = input.nextInt(), n = input.nextInt();
    int[][] data = new int[m][n];
    for(int i = 0; i<m; i++)
        for(int j = 0; j<n; j++) data[i][j] = input.nextInt();
    int[][] dp = new int[m][n];
    for(int i = 0; i<n; i++) dp[0][i] = (i == 0 ? data[0][i] : data[0][i] + dp[0][i-1]);
    for(int i = 1; i<m; i++)
        for(int j = 0; j<n; j++)
            dp[i][j] = (j == 0 ? data[i][j] + dp[i-1][j] : data[i][j] + Math.max(dp[i-1][j], dp[i][j-1]));
    for(int i = 0; i<m; i++) System.out.print(dp[i][n-1]+" ");
}
}