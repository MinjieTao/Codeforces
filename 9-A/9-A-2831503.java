import java.util.*;
public class a {
public static void main(String[] args)
{
      Scanner input = new Scanner(System.in);
//    int n = input.nextInt(), mod = 1000000007;
//    long res = 1;
//    for(int i = 0; i<n; i++)
//      res = (res*(2*n-1-i))%mod;
//    for(int i = 1; i<=n; i++)
//      res = (res*invmod(i, mod))%mod;
//    res = (2*res - n)%mod;
//    System.out.println(res);
    
    int a = input.nextInt(), b = input.nextInt();
    String[] ans = {"0/1","1/6","1/3","1/2","2/3","5/6", "1/1"};
    System.out.println(ans[7-Math.max(a,b)]);
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
}