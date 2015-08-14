import java.util.*;
public class f {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long a = input.nextLong(), b = input.nextLong();
    int k = input.nextInt();
    int lcm = 1;
    for(int i = 2; i<=k; i++) lcm = lcm(lcm, i);
    int[] dp = new int[2*lcm];
    int start = (int)(a%lcm) + lcm;
    Arrays.fill(dp, 987654321);
    dp[start] = 0;
    for(int i = start; i>0; i--)
    {
        dp[i-1] = Math.min(dp[i-1], dp[i]+1);
        for(int j = 2; j<=k; j++)
        {
            int next = i - i%j;
            if(next >= 0) dp[next] = Math.min(dp[next], dp[i]+1);
        }
    }
    long res = 0;
    if(a-b >= lcm)
    {
        res = dp[lcm];
        a -= (a%lcm);
    }
    //System.out.println(dp[0]+" "+dp[lcm]);
    int lcmStep = dp[0]-dp[lcm];
    //System.out.println(lcm+" "+lcmStep);
    
    long numSteps = (a-b)/lcm - 2;
    if(numSteps > 0)
    {
        a -= lcm*numSteps;
        res += lcmStep*numSteps;
    }
    
    dp = new int[5*lcm];
    int end = (int)(b - lcm*(b/lcm));
    start = (int)(end + a - b);
    //System.out.println(start+" "+end);
    Arrays.fill(dp, 987654321);
    dp[start] = 0;
    for(int i = start; i>end; i--)
    {
        dp[i-1] = Math.min(dp[i-1], dp[i]+1);
        for(int j = 2; j<=k; j++)
        {
            int next = i - i%j;
            if(next > 0) dp[next] = Math.min(dp[next], dp[i]+1);
        }
    }
    
    res += dp[end];
    
    System.out.println(res);
}
static int lcm(int a, int b)
{
    return a/gcd(a,b)*b;
}
static int gcd(int a, int b)
{
    if(b==0) return a;
    return gcd(b, a%b);
}
}