import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int m = input.nextInt(), n = input.nextInt();
    char[][] grid = new char[n][m];
    for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
    grid = rotate(grid);
    grid = expand(grid);
    for(char[] A : grid) System.out.println(new String(A));
}
static char[][] rotate(char[][] grid)
{
    int n = grid.length, m = grid[0].length;
    char[][] res = new char[m][n];
    for(int i = 0; i<m; i++)
        for(int j = 0; j<n; j++)
            res[i][j] = grid[j][i];
    
    return res;
}
static char[][] expand(char[][] grid)
{
    int n = grid.length*2, m = grid[0].length*2;
    char[][] res = new char[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            res[i][j] = grid[i>>1][j>>1];
        }
    return res;
}
}