import java.util.*;
public class c {
    public static int[][] ons;
    public static int m, n, x, y;
    public static int[][][] memo;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    m = input.nextInt(); n = input.nextInt();
    x = input.nextInt(); y = input.nextInt();
    memo = new int[n+1][y+1][2];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<=y; j++)
            Arrays.fill(memo[i][j], -1);
    ons = new int[n][2];
    for(int i = 0; i<m; i++)
    {
        String s = input.next();
        for(int j = 0; j<n; j++)
        {
            if(s.charAt(j) == '.')ons[j][0]++;
            else ons[j][1]++;
        }
    }
    System.out.println(go(0, 0, 0));
}
public static int go(int row, int consec, int last)
{
    if(row == n && consec < x)
        return 987654321;
    if(memo[row][consec][last] != -1)
        return memo[row][consec][last];
    if(consec < x && consec > 0)
            return memo[row][consec][last] = ons[row][last] + go(row+1, consec+1, last);
    else if(consec == y)
        return memo[row][consec][last] = ons[row][1-last] + go(row+1, 1, 1-last);
    else
        return memo[row][consec][last] = Math.min(ons[row][last] + go(row+1, consec+1, last), ons[row][1-last] + go(row+1,1, 1-last));

}
}