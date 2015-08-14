import java.util.*;
public class d {
    static int mod = 1000000007;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n= input.nextInt(), m = input.nextInt();
    char[][] data = new char[n][m];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    long[][] count1 = new long[n][m]; //From (0, 1)
    long[][] count2 = new long[n][m]; //From (1, 0)
    if(data[0][1] != '#') count1[0][1] = 1;
    for(int i = 0; i<n; i++)
        for(int j = 1; j<m; j++)
        {
            if(data[i][j] == '#') continue;
            count1[i][j] += count1[i][j-1];
            if(i>0) count1[i][j] += count1[i-1][j];
            count1[i][j] %= mod;
        }
    if(data[1][0] != '#') count2[1][0] = 1;
    for(int i = 1; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(data[i][j] == '#') continue;
            count2[i][j] += count2[i-1][j];
            if(j>0) count2[i][j] += count2[i][j-1];
            count2[i][j] %= mod;
        }
    long res = count1[n-2][m-1] * count2[n-1][m-2] - count1[n-1][m-2] * count2[n-2][m-1];
    res = (res%mod+mod)%mod;
    System.out.println(res);
}
}