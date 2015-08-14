import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    m = input.nextInt();
    grid = new char[n][m];
    for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
    cycle = false;
    color = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            if(color[i][j] == 0)
            check(i, j, -1, -1);
    System.out.println(cycle ? "Yes" :"No");
}
static int[][] color;
static char[][] grid;
static int n, m;
static int[] di = new int[]{0, 1, 0, -1};
static int[] dj = new int[]{1, 0, -1, 0};
static boolean cycle;

static void check(int i, int j, int lasti, int lastj)
{
    color[i][j] = 1;
    for(int k = 0; k<4; k++)
    {
        int ni = i+di[k];
        int nj = j+dj[k];
        if(ni < 0 || nj < 0 || ni >= n || nj >= m || color[ni][nj] == 2 || grid[ni][nj] != grid[i][j] || (ni == lasti && nj == lastj)) continue;
        if(color[ni][nj] == 1)
        {
            cycle = true;
            return;
        }
        check(ni, nj, i, j);
    }
    color[i][j] = 2;
}
}