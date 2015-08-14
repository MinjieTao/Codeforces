import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[][] data = new int[n][n];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
            data[i][j] = input.nextInt();
    double[][] a = new double[n][n];
    double[][] b = new double[n][n];
    for(int i = 0; i<n; i++) a[i][i] = data[i][i];
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
        {
            a[i][j] = a[j][i] = .5*(data[i][j] + data[j][i]);
            b[i][j] = data[i][j] - a[i][j];
            b[j][i] = -b[i][j];
        }
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
            System.out.print(a[i][j]+" ");
        System.out.println();
    }
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
            System.out.print(b[i][j]+" ");
        System.out.println();
    }
}
}