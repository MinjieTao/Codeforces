import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    boolean[][] data = new boolean[n][m];
    for(int i = 0; i<n; i++)
        for(int j =0; j<m; j++)
            data[i][j] = input.nextInt() == 1;
    boolean side = false, corner = false;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(data[i][j])
            {
                if((i == 0 || i == n-1) && (j==0 || j == m-1)) corner = true;
                else if((i == 0 || i == n-1) || (j==0 || j == m-1)) side = true;
            }
        }
    if(corner)System.out.println(1);
    else if(side) System.out.println(2);
    else System.out.println(4);
}
}