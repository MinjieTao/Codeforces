import java.util.*;
import java.io.*;
public class C528 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(new Edge(b, i));
        g[b].add(new Edge(a, i));
    }
    int at = m;
    ArrayList<Integer> odd = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) if(g[i].size()%2 == 1) odd.add(i);
    for(int i = 0; i<odd.size(); i+=2)
    {
        int a = odd.get(i), b = (i+1 < odd.size() ? odd.get(i+1) : a);
        g[a].add(new Edge(b, at));
        g[b].add(new Edge(a, at));
        at++;
    }
    if(at%2 == 1)
    {
        g[0].add(new Edge(0, at));
        g[0].add(new Edge(0, at));
        at++;
    }
    ArrayList<Integer> eulerCycle = eulerPath();
    if(eulerCycle != null)
    {
        out.println(eulerCycle.size() - 1);
        for(int i = 0; i<eulerCycle.size()-1; i++)
        {
            int a = eulerCycle.get(i), b = eulerCycle.get((i+1)%eulerCycle.size());
            if(i%2 == 0) out.println((a+1)+" "+(b+1));
            else out.println((b+1)+" "+(a+1));
        }
    }
    out.close();
}

static int[] ptrs;
static ArrayList<Edge>[] g;
static ArrayList<Integer> eulerPath;
static boolean[] used;
static ArrayList<Integer> eulerPath()
{
    int n = g.length, start = 0, diff = 0, edges = 0;
    eulerPath = new ArrayList<Integer>();
    int[] in = new int[n], out = new int[n];
    for(int i = 0; i<n; i++)
    {
        edges += out[i] = g[i].size();
        for(Edge e : g[i])
        {
            in[e.to]++;
        }
    }
    edges /= 2;
    while(out[start] == 0) start++;
    for(int i = 0; i<n; i++)
    {
        if(out[i] > in[i]) start = i;
        diff += Math.abs(in[i] - out[i]);
    }
    if(diff > 2) return null;
    ptrs = new int[n];
    used = new boolean[edges];
    dfs(start);
    eulerPath.add(start);
    if(eulerPath.size() < edges + 1) return null;
    return eulerPath;
}
static void dfs(int at)
{
    while(ptrs[at] < g[at].size())
    {
        while(ptrs[at] < g[at].size() && used[g[at].get(ptrs[at]).i]) ptrs[at]++;
        if(ptrs[at] == g[at].size()) break;
        int p = ptrs[at];
        used[g[at].get(p).i] = true;
        dfs(g[at].get(ptrs[at]++).to);
        eulerPath.add(g[at].get(p).to);
    }
}
static class Edge
{
    int to, i;
    public Edge(int tt, int ii)
    {
        to = tt; i = ii;
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