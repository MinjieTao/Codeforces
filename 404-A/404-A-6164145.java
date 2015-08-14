import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    char[][] grid = new char[n][n];
    for(int i =0; i<n; i++) grid[i] = input.next().toCharArray();
    char a = grid[0][0], b = grid[0][1];
    boolean valid = a != b;
    for(int i =0; i<n; i++)
        for(int j = 0; j<n; j++)
            if(i == j || i+j == n-1)
                valid &= grid[i][j] == a;
            else valid &= grid[i][j] == b;
    System.out.println(valid ? "YES" :"NO");
}
}