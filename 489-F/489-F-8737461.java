import java.util.*;
public class f {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    int m = input.nextInt();
    mod = input.nextInt();
    memo = new long[n+1][n+1];
    for(long[] A: memo) Arrays.fill(A, -1);
    int[] counts = new int[n];
    for(int i = 0; i<m; i++)
    {
        String s = input.next();
        for(int j = 0; j<n; j++)
            if(s.charAt(j) == '1')
                counts[j]++;
    }
    int ones = 0, twos = 0;
    for(int i = 0; i<n; i++)
    {
        if(counts[i] == 1) ones++;
        else if(counts[i] == 0) twos++;
    }
    //System.out.println(ones+" "+twos);
    System.out.println(go(ones, twos));
}
static int n;
static long mod;
static long[][] memo;
static long go(int ones, int twos)
{
    //System.out.println(ones+" "+twos);
    int zeroes = n - ones - twos;
    if(ones < 0 || twos < 0 || zeroes < 0) return 0;
    int row = (2*zeroes+ones)/2;
    if(row == n) return ones == 0 && twos == 0 ? 1 : 0;
    if(memo[ones][twos] != -1) return memo[ones][twos];
    long res = 0;
    res = (res + (ones * (ones-1) / 2) * go(ones-2, twos))%mod;
    res = (res + twos * (twos-1) / 2 * go(ones+2, twos-2))%mod;
    res = (res + ones*twos*go(ones, twos-1))%mod;
    return memo[ones][twos] = res;
}
}