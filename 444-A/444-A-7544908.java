import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    ArrayList<Edge>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1 ,b = input.nextInt()-1, c = input.nextInt();
        g[a].add(new Edge(b, c));
        g[b].add(new Edge(a, c));
    }
    double res = 0;
    for(int i = 0; i<n; i++)
    {
        boolean[] set = new boolean[n];
        int[] costs = new int[n];
        Arrays.fill(costs, 987654321);
        for(Edge e: g[i]) costs[e.to] = e.cost;
        int num = data[i];
        set[i] = true;
        int denom = 0;
        for(int iter = 1; iter <    n; iter++)
        {
            int mindex = -1;
            double max = denom == 0 ? 0 : 1.*num/denom;
            for(int j = 0; j<n; j++)
            {
                if(set[j] || costs[j] == 987654321) continue;
                if(1. * (num+data[j]) / (denom+costs[j]) > max)
                {
                    max = 1. * (num+data[j]) / (denom+costs[j]);
                    mindex = j;
                }
            }
            if(mindex == -1) break;
            //out.println(i+" "+mindex);
            set[mindex] = true;
            denom += costs[mindex];
            num+= data[mindex];
            for(Edge e: g[mindex]) costs[e.to] += e.cost;
            res = Math.max(res, 1.*num/denom);
        }
    }
    out.println(res);
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