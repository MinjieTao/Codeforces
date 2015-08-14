import java.util.*;
public class b {
    static int n;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    int m = input.nextInt();
    boolean[] rs = new boolean[n], cs = new boolean[n];
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        rs[a] = cs[b] = true;
    }
    int r = n, c = n;
    for(int i = 0; i<n; i++)
    {
        if(rs[i]) r--;
        if(cs[i]) c--;
    }
    memo = new double[n+1][n+1];
    for(double[] A: memo) Arrays.fill(A, -1);
    System.out.println(go(r, c));
}
static double[][] memo;
static double go(int a, int b)
{
    if(memo[a][b] != -1) return memo[a][b];
    if(a == 0 && b == 0) return 0;
    if(b ==0) return go(b, a);
    if(a == 0)
    {
        double probB = 1.*b/n;
        return memo[a][b] = go(a, b-1) + 1./probB;
    }
    double probA = 1.*a/n, probB = 1.*b/n;
    double res = probA * (1-probB) * go(a-1, b) + probB * (1-probA) * go(a, b-1) + probA * probB * go(a-1, b-1) + 1;
    return memo[a][b] = res/(probA + (1-probA)*probB);
}
}