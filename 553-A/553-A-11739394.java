import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int soFar = 0;
    long res = 1;
    for(int i = 1; i<n; i++)
    {
        soFar += data[i-1];
        res *= comb(soFar + data[i] - 1, data[i] - 1);
        res %= mod;
    }
    out.println(res);
    out.close();
}
static long comb(long n, long k)
{
    if(k >n - k) return comb(n, n-k);
    long num = 1;
    long denom = 1;
    for(int i = 0; i<k; i++)
    {
        num = (num * (n - i))%mod;
        denom = (denom * (i+1))%mod;
    }
    return (num * invmod(denom)) % mod;
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
public static long invmod(long x)
{
    long[] vals = gcd(x, mod);
    if(vals[0]>1)
        return -1;
    if(vals[1]>0)
        return vals[1];
    return mod + vals[1];
}
static long mod = (long)(1e9+7);
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
}