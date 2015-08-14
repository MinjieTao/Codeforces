import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] data = new int[n][n];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                data[i][j] = input.nextInt();
        int[] rs = new int[n], cs = new int[n];
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
            {
                rs[i] += data[i][j];
                cs[j] += data[i][j];
            }
        int count = 0;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++)
                if(cs[j] > rs[i])
                    count++;
        System.out.println(count);
    }
}