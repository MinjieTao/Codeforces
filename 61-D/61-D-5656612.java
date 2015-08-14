import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    ArrayList<Edge>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
    long tot = 0;
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, w = input.nextInt();
        g[a].add(new Edge(b, w));
        g[b].add(new Edge(a, w));
        tot += 2*w;
    }
    int[] ds = new int[n];
    Arrays.fill(ds, Integer.MAX_VALUE);
    ds[0] = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(Edge e: g[at])
        {
            if(ds[at] + e.d < ds[e.to])
            {
                ds[e.to] = e.d + ds[at];
                q.add(e.to);
            }
        }
    }
    int max = 0;
    for(int  i= 0; i<n; i++) max = Math.max(max, ds[i]);
    out.println(tot - max);
    out.close();
}
static class Edge
{
    int to, d;
    public Edge(int tt, int dd)
    {
        to = tt;
        d = dd;
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