import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    PrintWriter out = new PrintWriter(System.out);
    int[] res = go(n);
    if(res == null) out.println("NO");
    else
    {
        out.println("YES");
        for(int x: res) out.print(x+" ");
    }
    
    out.close();
}
//GCD - O(log(max(p, q)))
//res[0] is gcd of p and q
//res[1] and res[2] are values used in extended Euclidean algorithm for inverse mod
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
static int[] go(int n)
{
    if(n == 1) return new int[]{1};
    if(n == 4) return new int[]{1, 3, 2, 4};
    if(!prime(n)) return null;
    int[] res = new int[n];
    for(int i = 1; i<n; i++)
    {
        res[i-1] = (int)(i == 1 ? i :((long)i * invmod(i-1, n))%n); 
    }
    res[n-1] = n;
    return res;
}
static boolean prime(int n)
{
    for(int i = 2; i<= Math.sqrt(n); i++) if(n%i == 0) return false;
    return true;
}
}