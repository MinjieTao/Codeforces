import java.util.*;
public class j {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), d = input.nextInt();
    int[][] data = new int[n][m];
    boolean possible = true;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            data[i][j] = input.nextInt();
            if(data[i][j]%d != data[0][0]%d) possible = false;
        }
    for(int i =0; i<n; i++)
        for(int j = 0; j<m; j++)
            data[i][j] = (data[i][j]-data[i][j]%d)/d;;
    if(!possible) System.out.println(-1);
    else
    {
        int best = 987654321;
        for(int i = 0; i<=10000; i++)
        {
            int cur = 0;
            for(int j = 0; j<n; j++)
                for(int k = 0; k<m; k++)
                    cur += Math.abs(data[j][k] - i);
            best = Math.min(best, cur);
        }
        System.out.println(best);
    }
}
}