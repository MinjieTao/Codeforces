import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int[] cs = new int[k];
    for(int i = 0; i<k; i++) cs[i] = input.nextInt();
    int[] types = new int[n];
    int at = 0;
    for(int i = 0; i<k; i++)
        for(int j =0; j<cs[i]; j++)
            types[at++] = i;
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] =new ArrayList<Edge>();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt();
        g[a].add(new Edge(b, c));
        g[b].add(new Edge(a, c));
    }
    scc();
    int[] ids = new int[k];
    Arrays.fill(ids, -1);
    boolean good = true;
    for(int i = 0; i<n; i++)
    {
        int cur = id[i];
        if(ids[types[i]] != -1 && ids[types[i]] != cur) good = false;
        else ids[types[i]] = cur;
    }
    if(!good) out.println("No");
    else
    {
        out.println("Yes");
    
        int[][] adj = new int[k][k];
        for(int[] A: adj) Arrays.fill(A, 987654321);
        for(int i = 0; i<k; i++) adj[i][i] = 0;
        for(int i = 0; i<n; i++)
            for(Edge e: g[i])
            {
                if(types[e.to] != types[i]) adj[types[e.to]][types[i]] = adj[types[i]][types[e.to]] = Math.min(adj[types[i]][types[e.to]], e.d);
            }
        for(int l = 0; l<k; l++)
            for(int i =0; i<k; i++)
                for(int j = 0; j<k; j++)
                    adj[i][j] = Math.min(adj[i][j], adj[i][l]+adj[l][j]);
        for(int i= 0; i<k; i++)
        {
            for(int j = 0; j<k; j++)
            {
                if(adj[i][j] == 987654321) adj[i][j] = -1;
                out.print(adj[i][j]+(j==k-1?"":" "));
            }
            out.println();
        }
    }
    out.close();
}
/*
 * Tarjan's Strongly Connected Componenets - O(n)
 * Initialize g beforehand.
 * After it's run, id will have SCC's in reverse topological order
 * Indices with same id represent nodes in same SCC
 */
static ArrayList<Edge>[] g;
static boolean[] marked;
static int[] id, low, stk;
static int pre, count;
static void scc()
{
    id = new int[g.length]; low = new int[g.length]; stk = new int[g.length+1];
    pre = count = 0;
    marked = new boolean[g.length];
    for(int i =0; i<g.length; i++)
        if(!marked[i]) dfs(i);
}
static void dfs(int i)
{
    marked[stk[++stk[0]]=i] = true;
    int min = low[i] = pre++;
    for(Edge j: g[i])
    {
        if(j.d != 0) continue;
        if(!marked[j.to]) dfs(j.to);
        if(low[j.to] < min) min = low[j.to];
    }
    if(min < low[i]) low[i] = min;
    else
    {
        while(stk[stk[0]] != i)
        {
            int j =stk[stk[0]--];
            id[j] = count;
            low[j] = g.length;
        }
        id[stk[stk[0]--]] = count++;
        low[i] = g.length;
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