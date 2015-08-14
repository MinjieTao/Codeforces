import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    
    int[][] g = new int[3][3];
    for(int i = 0; i<3; i++)
        for(int j = 0; j<3; j++) g[i][j] = input.nextInt();
    int n = input.nextInt();
    memo = new long[n+2][3][3];
    for(long[][] A: memo) for(long[] B: A) Arrays.fill(B, -1);
    out.println(cost(n, 0, 2, g));
    
    out.close();
}
static long[][][] memo;
static long cost(int n, int from, int to, int[][] g)
{
    if(n == 0) return 0;
    if(memo[n][from][to] != -1) return memo[n][from][to];
    int x =0;
    while(x == from || x == to) x++;
    long min = cost(n-1, from, x, g) + g[from][to] + Math.min(cost(n-1, x, to, g), cost(n-1, x, from, g) + cost(n-1, from, to, g));
    min = Math.min(min, cost(n-1, from, to, g) + g[from][x] + cost(n-1, to, from, g) + g[x][to] + Math.min(cost(n-1, from, to, g), cost(n-1, from, x, g) + cost(n-1, x, to, g)));
    
    
    return memo[n][from][to] = min;
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