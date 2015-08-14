import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[][] dp = new int[n][n];
    for(int i = data[0]; i<n; i++) dp[0][i]++;
    for(int i = 1; i<n; i++)
    {
        for(int j = 0; j<data[i]; j++) dp[i][j] = dp[i-1][j];
        for(int j = data[i]; j<n; j++) dp[i][j] = dp[i-1][j] + 1;
        //System.out.println(i+" "+Arrays.toString(dp[i]));
    }
    int best = -1, count = 0;
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
        {
            int min = Math.min(data[i], data[j]);
            int max = Math.max(data[i], data[j]);
            int ans = 2*(dp[j-1][max-1] - dp[i][max-1] - (dp[j-1][min] - dp[i][min]));
            if(data[i] < data[j]) ans = -ans;
            if(data[i] > data[j]) ans++;
            else ans--;
            //System.out.println(i+" "+j+" "+min+" "+max+" "+ans);
            if(ans > best)
            {
                best = ans;
                count = 1;
            }
            else if(ans == best) count++;
        }
    int x = 0;
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
            if(data[i] > data[j])
                x++;
    best = x-best;
    System.out.println(best+" "+count);
}
}