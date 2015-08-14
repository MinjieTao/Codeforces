import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n= input.nextInt(), m = input.nextInt();
    int[][] g = new int[n][n];
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt();
        g[a][b] += c;
    }
    for(int k = 0; k<n; k++)
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
            {
                int x = Math.min(g[i][k], g[k][j]);
                g[i][k] -= x;
                g[k][j] -= x;
                g[i][j] += x;
            }
    int res = 0;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
            if(i != j) res += g[i][j];
    System.out.println(res);
}
}