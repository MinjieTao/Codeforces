import java.util.*;
import java.io.*;
public class b {
    static ArrayList<Integer>[] g;
    static int n;
    static int[] ps, as;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    n = input.nextInt();
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    ps = new int[n];
    as = new int[n];
    for(int i = 0; i<n; i++)
    {
        ps[i] = input.nextInt();
        as[i] = input.nextInt();
    }
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) if(ps[i] != -1) g[ps[i]-1].add(i);
    memo = new long[2][n];
    for(long[] A : memo) Arrays.fill(A, -1);
    System.out.println(Math.max(go(0, 0), go(0, 1)));
}
static long[][] memo;
static long go(int at, int p)
{
    if(memo[p][at] != -1) return memo[p][at];
    if(g[at].size() == 0) return p == 1 ? as[at] : 0;
    long sum = 0;
    long[] diffs = new long[g[at].size()];
    for(int i = 0; i<g[at].size(); i++)
    {
        int e = g[at].get(i);
        sum += go(e, 0);
        diffs[i] = go(e, 0) - go(e, 1);
    }
    Arrays.sort(diffs);
    int ptr = 0;
    if(p == 1)
    {
        sum -= diffs[0];
        ptr++;
    }
    while(ptr + 1 < g[at].size() && diffs[ptr] + diffs[ptr+1] < 0)
    {
        sum -= diffs[ptr] + diffs[ptr+1];
        ptr += 2;
    }
    if(p == 1) sum = Math.max(sum, as[at] + go(at, 0));
    //System.out.println(at+" "+p+" "+sum);
    return memo[p][at] = sum;
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