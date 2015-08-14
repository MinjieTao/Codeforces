import java.util.*;
public class d {
    static ArrayList<Integer>[] g;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[][] data = new int[k][n];
    for(int i = 0;i <k; i++)
        for(int j = 0; j<n; j++)
            data[i][j] = input.nextInt();
    int[][] inv = new int[k][n];
    for(int i = 0; i<k; i++)
        for(int j = 0; j<n; j++)
            inv[i][data[i][j]-1] = j;
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            boolean good = true;
            for(int x = 0; x<k; x++)
                good &= inv[x][i] < inv[x][j];
            if(good) g[i].add(j);
        }
    memo = new int[n];
    Arrays.fill(memo, -1);
    int res = 1;
    for(int i =0; i<n; i++) res = Math.max(res, go(i));
    System.out.println(res);
}
static int[] memo;
static int go(int at)
{
    if(memo[at] != -1) return memo[at];
    int res = 1;
    for(int x: g[at]) res = Math.max(res, 1+go(x));
    return memo[at] = res;
}
}