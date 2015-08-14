import java.util.*;
public class d {
    public static int m, length;
    public static long[] digits;
    public static int mod = 1000000007;
    public static long[][][] memo;
    public static long[] counts;
    public static int[] facts;
public static void main(String[] args)
{
    facts = new int[10];
    facts[0] = 1;
    for(int i = 1; i<10; i++) facts[i] = i*facts[i-1];
    //for(int i: facts) System.out.println(i);
    Scanner input = new Scanner(System.in);
    m = input.nextInt();
    length = (m+"").length();
    digits = new long[length];
    for(int i =0; i<length; i++)
        digits[i] = (m+"").charAt(i) - '0';
    //System.out.println(go(0, false, 0));
    memo = new long[11][2][11];
    for(int i = 0; i<memo.length; i++)
        for(int j = 0; j<memo[0].length; j++)
            Arrays.fill(memo[i][j], -1);
    counts = new long[10];
    for(int i = 0; i<10; i++)
    {
        counts[i] = go(0, false, i);
        if(i == 0) counts[i]--;
    }
    //for(long i: counts) System.out.println(i);
    long res = 0;
    for(int i =0; i<10; i++)
    {
        if(counts[i] == 0) continue;
        counts[i]--;
        for(int j = 0; j<i; j++)
        {
            //System.out.println(i + " " + j);
            res += (counts[i]+1)*go2(0, j, 0);
            res%= mod;
            //System.out.println(res);
        }
        counts[i]++;
    }
    res *= facts[6];
    res %= mod;
    System.out.println(res);
}
public static long go2(int at, int left, int numOn)
{
    //System.out.println(at + " " + left + " " + numOn);
    if(left<0)
        return 0;
    if(at > 6)
        return 0;
    if(at == 6)
    {
        //if(left == 0) System.out.println("SUCCESS");
        return left == 0 ? 1 : 0;
    }
    if(numOn == 10)
        return 0;
    long res = 0;
    for(int i =0; i<7; i++)
    {
        if(i > counts[numOn])
            break;
        long factor = invmod(facts[i], mod);
        //System.out.println(factor);
        for(int j =0; j<i; j++)
        {
            //System.out.println(factor);
            factor *= counts[numOn] - j;
            factor %= mod;
//          factor *= invmod(j+1, mod);
//          factor %= mod;
        }
        //System.out.println(i + " " + numOn + " " + factor);
        res += factor * go2(at+i, left - i*numOn, numOn+1);
        res %= mod;
    }
    return res%mod;
}
public static long go(int at, boolean less, int left)
{
    if(left < 0)
        return 0;
    if(at == length)
        return left == 0 ? 1:0;
    if(memo[at][less?1:0][left] != -1)
        return memo[at][less?1:0][left];
    if(less)
    {
        int res = 0;
        for(int i = 0; i<10; i++)
        {
            if(i == 4 || i == 7)
                res += go(at+1, less, left-1);
            else
                res += go(at+1, less, left);
            res %= mod;
        }
        return memo[at][less?1:0][left] = res;
    }
    else
    {
        int res = 0;
        for(int i = 0; i<digits[at]; i++)
        {
            if(i == 4 || i == 7)
                res += go(at+1, true, left - 1);
            else
                res += go(at+1, true, left);
            res %= mod;
        }
        if(digits[at] == 4 || digits[at] == 7)
            res += go(at+1, false, left -1);
        else
            res += go(at+1, false, left);
        return memo[at][less?1:0][left] = res %mod;
    }
}
public static long[] gcd(long p, long q)
{
    if(q==0)
        return new long[] {p, 1, 0};
    long[] vals = gcd(q, p%q);
    return new long[] {vals[0], vals[2], vals[1] - (p/q)*vals[2]};
}
//Inverse Mod - O(log(mod))
//Returns A s.t. x*A = 1(MOD mod)
public static long invmod(long x, long mod)
{
    long[] vals = gcd(x, mod);
    if(vals[0]>1)
        return -1;
    if(vals[1]>0)
        return vals[1];
    return mod + vals[1];
}
}