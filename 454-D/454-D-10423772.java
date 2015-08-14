import java.util.*;
public class B259 {
public static void main(String[] args)
{
    int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59};
    int[] masks = new int[60];
    for(int i = 1; i<60; i++)
        for(int j = 0; j<primes.length; j++)
            if(i%primes[j] == 0)
                masks[i] |= (1<<j);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[][] dp = new int[n+1][1<<17];
    for(int[] A : dp) Arrays.fill(A, 987654321);
    dp[0][0] = 0;
    int[][] last = new int[n+1][1<<17];
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<(1<<17); j++)
        {
            if(dp[i][j] == 987654321) continue;
            for(int k = 1; k<60; k++)
            {
                if((j & masks[k]) > 0) continue;
                int cur = Math.abs(data[i] - k) + dp[i][j];
                if(cur >= dp[i+1][j | masks[k]]) continue;
                last[i+1][j|masks[k]] = k;
                dp[i+1][j | masks[k]] = Math.min(dp[i+1][j | masks[k]], cur);
            }
        }
    }
    int min = 987654321;
    int m = 0;
    for(int i = 0; i<(1<<17); i++)
    {
        if(dp[n][i] < min) m = i;
        min = Math.min(min, dp[n][i]);
    }
    int[] res = new int[n];
    int row = n, col = m;
    while(row > 0)
    {
        res[row-1] = last[row][col];
        row--;
        col ^= masks[res[row]];
    }
    //System.out.println(min);
    for(int x : res) System.out.print(x+" ");
}
}