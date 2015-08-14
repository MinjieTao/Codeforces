import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    n = input.nextInt();
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }
    tree();
    binaryLift();
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        out.println(query(a, b));
    }
    out.close();
}
static int query(int a, int b)
{
    if(a == b) return n;
    int dist = dist(a, b);
    if(dist%2 == 1) return 0;
    if(depths[a] < depths[b])
    {
        int temp = a; a = b; b = temp;
    }
    if(depths[a] == depths[b]) return n - size[getParent(a, dist/2 - 1)] - size[getParent(b, dist/2 - 1)];
    int mid = getParent(a, dist/2);
    int other = getParent(a, dist/2 - 1);
    return size[mid] - size[other];
}
static int[] depths;
static int[] ps;
static int[][] bl;
static int n;
static ArrayList<Integer>[] g;
static void tree()
{
    ps = new int[n];
    depths = new int[n];
    boolean[] vis = new boolean[n];
    vis[0] = true;
    ps[0] = -1;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    ArrayList<Integer>[] tree = new ArrayList[n];
    for(int i = 0; i<n; i++) tree[i] = new ArrayList<Integer>();
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int e : g[at])
        {
            if(!vis[e])
            {
                tree[at].add(e);
                vis[e] = true;
                q.add(e);
                ps[e] = at;
                depths[e] = 1 + depths[at];
            }
        }
    }
    g = tree;
    size();
}
static int[] size;
static void size()
{
    size = new int[n];
    int[] degs = new int[n];
    Queue<Integer> q = new LinkedList<Integer>();
    for(int i = 0; i<n; i++)
    {
        degs[i] = g[i].size();
        if(degs[i] == 0) q.add(i);
    }
    while(!q.isEmpty())
    {
        int at = q.poll();
        size[at] = 1;
        for(int e : g[at]) size[at] += size[e];
        if(ps[at] >= 0)
        {
            degs[ps[at]]--;
            if(degs[ps[at]] == 0)
            {
                q.add(ps[at]);
            }
        }
    }
}
static int lca(int a, int b)
{
    if(depths[a] < depths[b])
    {
        int temp = a; a = b; b = temp;
    }
    int log = 0;
    for(log = 1; (1<<log) <= depths[a]; log++);
    log--;
    for(int i = log; i >= 0; i--)
        if(depths[a] - (1<<i) >= depths[b])
            a = bl[i][a];
    if(a == b) return a;
    for(int i = log; i>=0; i--)
        if(bl[i][a] != -1 && bl[i][a] != bl[i][b])
        {
            a = bl[i][a];
            b = bl[i][b];
        }
    return ps[a];
}
static int dist(int a, int b)
{
    int lca = lca(a, b);
    return depths[a] + depths[b] - 2 * depths[lca];
}
static int getParent(int at, int p)
{
    if(p == 0) return at;
    int log = Integer.numberOfTrailingZeros(Integer.highestOneBit(p));
    return getParent(bl[log][at], p - (1<<log));
}
static void binaryLift()
{
    bl = new int[Integer.numberOfTrailingZeros(Integer.highestOneBit(n)) + 1][n];
    for(int i = 0; i<n; i++) bl[0][i] = ps[i];
    for(int i = 1; i < bl.length; i++)
    {
        Arrays.fill(bl[i], -1);
        for(int j = 0; j<n; j++)
            if(bl[i-1][j] >= 0)
                bl[i][j] = bl[i-1][bl[i-1][j]];
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