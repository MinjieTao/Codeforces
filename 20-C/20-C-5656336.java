import java.io.*;
import java.util.*;
public class Dijkstra {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n= input.nextInt(), m = input.nextInt();
    ArrayList<Edge>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, w = input.nextInt();
        g[a].add(new Edge(b, w));
        g[b].add(new Edge(a, w));
    }
    int[] prev = new int[n];
    Arrays.fill(prev, -1);
    long[] ds = new long[n];
    Arrays.fill(ds, (long)1e18);
    PriorityQueue<State> pq = new PriorityQueue<State>();
    int start = 0, end = n-1;
    pq.add(new State(start, 0));
    while(!pq.isEmpty())
    {
        State at = pq.poll();
        if(ds[at.at] < at.d) continue;
        for(Edge e: g[at.at])
        {
            int to = e.to;
            long nd = at.d + e.d;
            if(nd >= ds[to]) continue;
            ds[to] = nd;
            prev[to] = at.at;
            pq.add(new State(to, nd));
        }
    }
    if(ds[end] == 1e18) out.println(-1);
    else
    {
        ArrayList<Integer> path = new ArrayList<Integer>();
        int at = end;
        while(at != start)
        {
            path.add(at);
            at = prev[at];
        }
        path.add(start);
        for(int i = path.size()-1; i>=0; i--) out.print((1+path.get(i))+" ");
    }
    
    
    
    
    out.close();
}
static class State implements Comparable<State>
{
    int at;
    long d;
    public State(int aa, long dd)
    {
        at = aa; d = dd;
    }
    @Override
    public int compareTo(State o) {
        // TODO Auto-generated method stub
        return (int)Long.signum(d - o.d);
    }
}
static class Edge
{
    int to, d;
    public Edge(int tt, int dd)
    {
        to = tt; d = dd;
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