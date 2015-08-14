import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class D236 {
    static int oo = 987654321;
    static HashMap<Integer, Integer> map;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    memo = new int[1000000];
    Arrays.fill(memo, oo);
    map = new HashMap<Integer, Integer>();
    int n =input.nextInt(), m = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] gcds = new int[n];
    gcds[0] = data[0];
    for(int i = 1; i<n; i++) gcds[i] = gcd(data[i], gcds[i-1]);
    int[] bad = new int[m];
    for(int i = 0; i<m; i++) bad[i] = input.nextInt();
    set = new HashSet<Integer>();
    b = new boolean[1000000];
    for(int x : bad)
    {
        if(x < b.length) b[x] = true;
        else set.add(x);
    }
    int[] f = new int[n];
    for(int i = 0; i<n; i++) f[i] = -f(gcds[i]);
    int sub = 0;
    int tot = 0;
    for(int x : data) tot += f(x);
    for(int i = n-1; i>=0; i--)
    {
        if(f[i] > sub)
        {
            tot += (f[i] - sub) * (i+1);
            sub = f[i];
        }
    }
    System.out.println(tot);
}
static int[] memo;
static boolean[] b;
static HashSet<Integer> set;
static int f(int x)
{
    //System.out.println(x);
    int temp = x;
    if(x < memo.length && memo[x] != oo) return memo[x];
    if(x >= memo.length && map.containsKey(x)) return map.get(x);
    BigInteger bi = BigInteger.valueOf(x);
    if(bi.isProbablePrime(50))
    {
        int res = (x < 1e6 && b[x]) || (x >= 1e6 && set.contains(x)) ? -1 : 1;
        if(x < 1e6) memo[x] = res;
        else map.put(x, res);
        return res;
    }
    int tot = 0;
    for(int j = 2; j<= Math.sqrt(x); j++)
    {
        while(x%j == 0)
        {
            x /= j;
            if(b[j]) tot--;
            else tot++;
        }
    }
    if(x > 1)
    {
        if((x < 1e6 && b[x]) || (x >= 1e6 && set.contains(x))) tot--;
        else tot++;
    }
    if(temp < memo.length) memo[temp] = tot;
    else map.put(temp, tot);
    //System.out.println(temp+" "+tot);
    return tot;
}
static int gcd(int a, int b)
{
    if(b == 0) return a;
    return gcd(b, a%b);
}
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
            //TODO add check for eof if necessary
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