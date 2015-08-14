import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String s = input.next(), p = input.next();
    int n = s.length();
    int m = p.length();
    int[] jump = new int[n];
    Arrays.fill(jump, -1);
    for(int i = 0; i<n; i++)
    {
        int j = 0;
        int end = i;
        while(end < n && j < m)
        {
            if(s.charAt(end) == p.charAt(j)) j++;
            end++;
        }
        if(j == m) jump[i] = end;
    }
    int[][] memo = new int[n+1][n+1];
    //Arrays.fill(memo[0], -987654321);
    memo[0][0] = 0;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<=i; j++)
        {
            memo[i+1][j] = Math.max(memo[i+1][j], memo[i][j]);
            memo[i+1][j+1] = Math.max(memo[i][j], memo[i+1][j+1]);
            //System.out.println(i+" "+jump[i]);
            if(jump[i] != -1) memo[jump[i]][j+(jump[i] - i - p.length())] = Math.max(memo[jump[i]][j+(jump[i] - i - p.length())], 1+memo[i][j]);
        }
    for(int i = 0; i<=n; i++) System.out.print(memo[n][i]+" ");
//  int[][] dp = new int[n+1][n+1];
//  int[][] fail = new int[m][26];
//  int[] zs = zs(p);
//  zs[0] = m;
//  for(int i = 0; i<m; i++)
//      for(int j = 0; j<26; j++)
//          for(int k = 0; k<=i; k++)
//              if(zs[i-k] >= k && ('a'+j) == p.charAt(k)) fail[i][j] = k+1;
//  for(int i = 1; i<=n; i++) dp[0][i] = -987654321;
//  for(int i = 1; i<=n; i++)
//  {
//      for(int j = 0; j<=n; j++)
//      {
//          int prevNoRemove = dp[i-1][j];
//          if(prevNoRemove >= 0)
//              dp[i][j] = m * (prevNoRemove / m) + fail[prevNoRemove%m][s.charAt(i-1)-'a'];
//          else dp[i][j] = prevNoRemove;
//          //System.out.println(i+" "+j+" "+dp[i][j]);
//          if(j > 0)
//          {
//              int prevRemove = dp[i-1][j-1];
//              if(prevRemove > dp[i][j]) dp[i][j] = prevRemove;
//          }
//      }
//  }
//  for(int i = 0; i<=n; i++) System.out.print(dp[n][i]/m+" ");
}
static int[] zs(String ss)
{
    char[] s = ss.toCharArray();
    int L = 0, R = 0;
    int n = s.length;
    int[] z = new int[n];
    for (int i = 1; i < n; i++) 
    {
          if (i > R) 
          {
            L = R = i;
            while (R < n && s[R-L] == s[R]) R++;
            z[i] = R-L; R--;
          } 
          else 
          {
                int k = i-L;
                if (z[k] < R-i+1) 
                    z[i] = z[k];
                else 
                {
                      L = i;
                      while (R < n && s[R-L] == s[R]) R++;
                      z[i] = R-L; R--;
                }
          }
    }
    return z;
}
}