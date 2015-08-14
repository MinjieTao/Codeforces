import java.util.*;
import java.io.*;
public class b {
    static int k;
    static ArrayList<Integer>[] div;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    k = input.nextInt();
    div = new ArrayList[n+1];
    for(int i = 0; i<n+1; i++) div[i] = new ArrayList<Integer>();
    for(int i = 1; i<=n; i++)
    {
        for(int j = i; j<=n; j+=i) div[j].add(i);
    }
    memo = new int[k+1][n+1];
    for(int[] A: memo) Arrays.fill(A, -1);
    long res = 0;
    for(int i = 1; i<=n; i++) res = (res + go(1, i))%mod;
    out.println(res);
    out.close();
}
static int mod = 1000000007;
static int[][] memo;
static int go(int at, int last)
{
    if(at == k) return 1;
    if(memo[at][last] != -1) return memo[at][last];
    int res = 0;
    for(int x: div[last]) res = (res + go(at+1, x))%mod;
    return memo[at][last] = res;
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