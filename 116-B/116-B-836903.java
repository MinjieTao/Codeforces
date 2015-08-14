import java.util.*;
public class PigsWolves {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    char[][] memo = new char[n][m];
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        for(int j = 0; j<m; j++)
        {
            memo[i][j] = s.charAt(j);
        }
    }
    int count = 0;
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<m; j++)
        {
            if(memo[i][j]=='P')
            {
                if(i!=0 && memo[i-1][j]=='W')
                {
                    memo[i][j] = '.';
                    memo[i-1][j] = '.';
                    count++;
                }
                if(i!=n-1 && memo[i+1][j]=='W')
                {
                    memo[i][j] = '.';
                    memo[i+1][j] = '.';
                    count++;
                }
                if(j!=0 && memo[i][j-1]=='W')
                {
                    memo[i][j] = '.';
                    memo[i][j-1] = '.';
                    count++;
                }
                if(j!=m-1 && memo[i][j+1]=='W')
                {
                    memo[i][j] = '.';
                    memo[i][j+1] = '.';
                    count++;
                }
            }
        }
        
    }
    System.out.println(count);
}
}