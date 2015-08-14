import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[][] t = new int[n][n];
    Arrays.fill(t[0], 1);
    for(int i = 1;i<n; i++)
        for(int j = 0; j<n; j++)
        {
            if(j == 0) t[i][j] = 1;
            else t[i][j] = t[i-1][j] + t[i][j-1];
        }
    System.out.println(t[n-1][n-1]);
}
}