import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    n = input.nextInt();
    ls = new int[n];
    cs = new int[n];
    for(int i = 0; i<n; i++)
    {
        ls[i] = input.nextInt();
    }
    for(int i = 0; i<n; i++)
    {
        cs[i] = input.nextInt();
    }
    memo = new HashMap<Long, Integer>();
    int res = go(0, 0);
    out.println(res > 2e8 ? -1 : res);
    out.close();
}
static int n;
static int[] ls;
static int[] cs;
static HashMap<Long, Integer> memo;
static int go(int at, int g)
{
    //System.out.println(at+" "+g);
    if(at == n)
    {
        return g == 1 ? 0 : 987654321;
    }
    long key = (long)g*n+at;
    if(memo.containsKey(key)) return memo.get(key);
    int res = Math.min(go(at+1, g), go(at+1, gcd(g, ls[at])) + cs[at]);
    memo.put(key, res);
    return res;
}
static int gcd(int a, int b)
{
    //if(a == (int)1e9+1) return b;
    int res = b == 0 ? a : gcd(b, a%b);
    //System.out.println(a+" "+b+" "+res);
    return res;
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