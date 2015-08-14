import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    char[][] data = new char[n][n];
    boolean good = true;
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            if(data[i][j] == '.') continue;
            //System.out.println(i+" "+j);
            if(j == n-1 || j == 0 || i == n-1 || i == n-2)
            {
                good = false;
                break;
            }
            if(data[i+1][j+1] == '.' || data[i+1][j] == '.' || data[i+1][j-1] == '.' || data[i+2][j] == '.')
            {
                good = false;
                break;
            }
            data[i][j] = data[i+1][j] = data[i+2][j] = data[i+1][j+1] = data[i+1][j-1] = '.';
        }
    System.out.println(good ? "YES" : "NO");
}
}