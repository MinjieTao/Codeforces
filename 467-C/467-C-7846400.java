import java.util.*;
public class c {
    static int n, m, k;
    static long[] ss;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt(); m = input.nextInt(); k = input.nextInt();
    ss = new long[n];
    for(int i = 0; i<n; i++) ss[i] = input.nextInt();
    for(int i = 1; i<n; i++) ss[i] += ss[i-1];
    long[][] memo = new long[2][n+1+m];
    for(int i = 0; i<=k; i++)
        for(int j = 0; j<n; j++)
        {
            //System.out.println(i+" "+j+" "+memo[i][j]);
            memo[i&1][j+1] = Math.max(memo[i&1][j+1], memo[i&1][j]);
            if(j+m-1 < n) memo[1-i&1][j+m] = Math.max(memo[1-i&1][j+m], memo[i&1][j] + ss[j+m-1] - (j == 0 ? 0 : ss[j-1]));
        }
    long max = 0;
    for(int i = 0; i<memo[0].length; i++) max = Math.max(max, memo[k&1][i]);
    System.out.println(max);
}
}