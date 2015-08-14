import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    long k = input.nextLong();
    long lo = 0, hi = (long)n*m+1;
    while(lo < hi - 1)
    {
        long mid = (lo+hi)/2;
        long count = 0;
        for(int i = 0; i<n; i++) count += Math.min(m, mid/(i+1));
        if(count < k) lo = mid;
        else hi = mid;
    }
    out.println(hi);
    out.close();
}
static class Edge
{
    int to, cost;
    public Edge(int tt, int cc)
    {
        to = tt; cost = cc;
    }
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