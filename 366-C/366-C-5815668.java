import java.util.*;
public class a {
    static int n, k;
    static int[] as;
    static int[] bs;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt(); k = input.nextInt();
    as = new int[n]; bs = new int[n];
    for(int i = 0; i<n; i++) as[i] = input.nextInt();
    for(int i = 0; i<n; i++) bs[i] = input.nextInt();
    memo = new int[101][110001];
    for(int[] A: memo) Arrays.fill(A, -1);
    int res = go(0, 0);
    System.out.println(res == 0 ? -1 : res);
}
static int[][] memo;
//memoize!
static int go(int at, int sum)
{
    if(at == n)
    {
        return sum == 0 ? 0 : -987654321;
    }
    if(memo[at][sum+10000] != -1) return memo[at][sum+10000]; 
    return memo[at][sum+10000] = Math.max(go(at+1, sum), as[at] + go(at+1, sum - (as[at] - bs[at]*k)));
}
}