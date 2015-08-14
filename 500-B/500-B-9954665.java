import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] ps = new int[n];
    for(int i = 0; i<n; i++) ps[i] = input.nextInt();
    boolean[][] g = new boolean[n][n];
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        for(int j = 0; j<n; j++)
            g[i][j] = s.charAt(j) == '1';
    }
    for(int k = 0; k<n; k++)
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                g[i][j] |= g[i][k] && g[k][j];
    for(int i = 0; i<n; i++)
    {
        int min = i;
        for(int j = i+1; j<n; j++)
        {
            if(ps[j] < ps[min] && g[i][j]) min = j;
        }
        int temp = ps[i];
        ps[i] = ps[min];
        ps[min] = temp;
    }
    for(int x : ps) System.out.print(x+" ");
}
}