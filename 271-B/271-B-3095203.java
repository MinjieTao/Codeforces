import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    boolean[] sieve = new boolean[1000000];
    Arrays.fill(sieve, true);
    sieve[0]=sieve[1]=false;
    for(int i = 2; i<1000000; i++)
    {
        if(!sieve[i]) continue;
        for(long j = (long)i*i; j<1000000; j+=i)
        {
            sieve[(int)j] = false;
        }
    }
    int n = input.nextInt(), m = input.nextInt();
    int[][] data = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            data[i][j] = input.nextInt();
    int[] count = new int[200000];
    count[100000] = 3;
    for(int i =99999; i>=0; i--)
    {
        if(sieve[i]) count[i] = 0;
        else count[i] = 1+count[i+1];
    }
    int res = 100000;
    for(int i = 0; i<n; i++)
    {
        int sum = 0;
        for(int j = 0; j<m; j++)
            sum += count[data[i][j]];
        res = Math.min(res, sum);
    }
    for(int i = 0; i<m; i++)
    {
        int sum = 0;
        for(int j = 0; j<n; j++)
            sum += count[data[j][i]];
        res = Math.min(res, sum);
    }
    System.out.println(res);
    
}
}