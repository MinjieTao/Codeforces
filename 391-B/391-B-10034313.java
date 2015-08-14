import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    char[] s = input.next().toCharArray();
    int n = s.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int max = 1;
    for(int i = 1; i<n; i++)
    {
        for(int j = i-1; j>=0; j-=2)
            if(s[i] == s[j])
                dp[i] = Math.max(dp[i], 1+dp[j]);
        max = Math.max(max, dp[i]);
        //System.out.println(i+" "+dp[i]);
    }
    System.out.println(max);
}
}