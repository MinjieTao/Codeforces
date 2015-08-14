import java.util.*;
import java.io.*;
public class a {
    static int n;
    static int[] data;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    n = input.nextInt();
    data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    memo = new int[n][n+1];
    for(int[] A: memo) Arrays.fill(A, -1);
    System.out.println(go(0, n));
    out.close();
}
static int[][] memo;
static int go(int at, int last)
{
    if(at == n) return 0;
    if(memo[at][last] != -1) return memo[at][last];
    if(last != n && data[at] <= data[last]) return memo[at][last] = go(at+1, at);
    int vert = 1 + go(at+1, last);
    int horiz = (last == n ? data[at] : (data[at] - data[last])) + go(at+1, at);
    //System.out.println(at+" "+last+" "+vert+" "+horiz);
    return memo[at][last] = Math.min(vert, horiz);
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