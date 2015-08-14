import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[][] data = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            data[i][j] = input.nextInt();
    int[][] solve = solve(data);
    if(same(invsolve(solve), data))
    {
        System.out.println("YES");
        for(int i = 0; i<n; i++)
        {
            for(int x: solve[i]) System.out.print(x+" ");
            System.out.println();
        }
    }
    else
        System.out.println("NO");
}
static boolean same(int[][] a, int[][] b)
{
    for(int i = 0; i<a.length; i++)
        for(int j = 0; j<a[0].length; j++)
        {
            if(a[i][j] != b[i][j]) return false;
        }
    return true;
}
static int[][] solve(int[][] data)
{
    int n = data.length, m = data[0].length;
    int[][] res = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            int cur = data[i][j];
            for(int k = 0; k<n; k++) cur &= data[k][j];
            for(int k = 0; k<m; k++) cur &= data[i][k];
            res[i][j] = cur;
        }
    return res;
}
static int[][] invsolve(int[][] data)
{
    int n = data.length, m = data[0].length;
    int[][] res = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            int cur = data[i][j];
            for(int k = 0; k<n; k++) cur |= data[k][j];
            for(int k = 0; k<m; k++) cur |= data[i][k];
            res[i][j] = cur;
        }
    return res;
}
}