import java.util.*;
public class c {
    static int mod = 1000000007;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[][][] dp = new int[1002][1002][4]; //1 bit refers to current position, 2 bit refers to last 
    dp[0][0][2] = 1; //can't use previous because it's start of array
    for(int i =0; i<=n; i++)
        for(int j = 0; j<i; j++)
        {
            dp[i][j+1][3] = (dp[i][j+1][3] + dp[i-1][j][3])%mod; //one already in current and previous - place in next
            dp[i][j+1][2] = (dp[i][j+1][2] + dp[i-1][j][1])%mod; //already one in previous - place one in next
            if(i<n)
            {
                //place one in previous if unoccupied
                dp[i][j+1][0] = (dp[i][j+1][0] + dp[i-1][j][0])%mod;
                dp[i][j+1][0] = (dp[i][j+1][0] + dp[i-1][j][1])%mod;
                
                dp[i][j+1][1] = (dp[i][j+1][1] + dp[i-1][j][2])%mod;
                dp[i][j+1][1] = (dp[i][j+1][1] + dp[i-1][j][3])%mod;
            }
            
            //place one in current position - doesn't add to good count
            //assuming all bad ones are placed in their own position
            dp[i][j][2] = (dp[i][j][2] + dp[i-1][j][0])%mod;
            dp[i][j][2] = (dp[i][j][2] + dp[i-1][j][1])%mod;
            dp[i][j][3] = (dp[i][j][3] + dp[i-1][j][2])%mod;
            dp[i][j][3] = (dp[i][j][3] + dp[i-1][j][3])%mod;
        }
    long[] res = new long[n+1];
    long[] facts = new long[n+1];
    facts[0] = 1;
    for(int i = 1; i<=n; i++) facts[i] = (facts[i-1]*i)%mod;
    for(int i = 0; i<=n; i++)
    {
        for(int k = 0; k<4; k++) res[i] = (res[i] + dp[n][i][k])%mod;
        res[i] = (res[i] * facts[n-i])%mod; //Try all possible arrangements of the ones we didn't make good.
    }
    
    int[][] combs = comb(1002);
    for(int i = n-1; i>=0; i--)
        for(int j = i+1; j<=n; j++)
            res[i] = (res[i] - (combs[j][i]*res[j])%mod + mod)%mod; //Get rid of the cases where we accidentally made extra good ones.
    
    System.out.println(res[m]);
}
//Returns array of combinations (Pascals's triangle) up to nCn - O(n^2)
//comb[i][j] represents the value of i choose j
public static int[][] comb(int n)
{
    int[][] comb = new int[n+1][n+1];
    for(int i = 0; i<= n; i++)
        comb[i][0] = 1;
    for(int i = 1; i<= n; i++)
        for(int j = 1; j<= i; j++)
            comb[i][j] = (comb[i-1][j] + comb[i-1][j-1])%mod;
    return comb;
}
}