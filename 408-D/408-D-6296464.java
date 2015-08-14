import java.util.*;
public class b {
    static int mod = 1000000007;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] ps = new int[n];
    for(int i = 0; i<n; i++)
        ps[i] = input.nextInt()-1;
    int[] dp = new int[n];
    for(int i = 0; i<n; i++)
    {
        if(ps[i] == i) dp[i] = 2;
        else
        {
            int tot = 1, at = ps[i];
            while(at < i)
            {
                tot = (tot+dp[at])%mod;
                at++;
            }
            dp[at] = (tot+1)%mod;
        }
    }
    int res = 0;
    for(int i = 0; i<n; i++)
        res = (res +dp[i])%mod;
    System.out.println(res);
    
}
}