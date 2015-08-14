import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int count = 0;
    char[][] res = new char[n][n];
    for(char[] A: res) Arrays.fill(A, '.');
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            if(i > 0 && res[i-1][j] == 'C') continue;
            if(j > 0 && res[i][j-1] == 'C') continue;
            res[i][j] = 'C';
            count++;
        }
    System.out.println(count);
    for(char[] A: res) System.out.println(new String(A));
}
}