import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    char[][] names = new char[n][m];
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        for(int j = 0; j<m; j++)
        {
            names[i][j] = s.charAt(j);
        }
    }
    long res = 1;
    for(int i = 0; i<m; i++)
    {
        boolean[] appear = new boolean[26];
        for(int j = 0; j<n; j++)
            appear[names[j][i]-'A'] = true;
        int count = 0;
        for(boolean b: appear)
            if(b) count++;
        res *= count;
                res %= 1000000007;
            
    }
    System.out.println(res);
}
}