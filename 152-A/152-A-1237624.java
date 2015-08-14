import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
        int m = input.nextInt();
    int[][] grades = new int[n][m];
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        for(int j = 0; j<m; j++)
            grades[i][j] = s.charAt(j) - '0';
    }
    boolean[] success = new boolean[n];
    for(int i = 0; i<m; i++)
    {
        int max = 0;
        int maxIndex = 0;
        for(int j = 0; j<n; j++)
        {
            if(grades[j][i] >= max)
            {
                max = grades[j][i];
                maxIndex = j;
            }
        }
        for(int j = 0; j<n; j++)
        {
            if(grades[j][i] == max)
                success[j] = true;
        }
    }
    int count = 0;
    for(int i = 0; i<n; i++)
        if(success[i])
            count++;
    System.out.println(count);
}
}