import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(); k = input.nextInt(); d = input.nextInt();
    memo = new long[n+1][2];
    for(long[] A: memo) Arrays.fill(A, -1);
    out.println(go(n, 0));
    out.close();
}
static long[][] memo;
static int k, d;
static long mod = 1000000007;
static long go(int at, int used)
{
    if(at == 0) return used == 1 ? 1 : 0;
    if(at < 0) return 0;
    if(memo[at][used] != -1) return memo[at][used];
    long res = 0;
    for(int i = 1; i<=k; i++)
    {
        if(i < d) res = (res + go(at-i, used))%mod;
        else res = (res + go(at-i, 1))%mod;
    }
    return memo[at][used] = res;
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