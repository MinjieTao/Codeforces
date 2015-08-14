import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    char[][] res = new char[n][m];
    for(int i = 0; i<n; i++) Arrays.fill(res[i], '.');
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(i%2 == 0 || (i%4 == 1 && j == m-1) || (i%4 == 3 && j == 0)) res[i][j] = '#';
        }
    for(int i = 0; i<n; i++) System.out.println(new String(res[i]));
}
}