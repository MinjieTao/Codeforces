import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt(), w = input.nextInt();
    char[][][] data = new char[k][n][m];
    for(int i = 0; i<k; i++)
        for(int j = 0; j<n; j++)
            data[i][j] = input.next().toCharArray();
    int[][] ds = new int[k][k];
    for(int i = 0; i<k; i++)
        for(int j = 0; j<i; j++)
        {
            for(int r = 0; r<n; r++)
                for(int c = 0; c<m; c++)
                    if(data[i][r][c] != data[j][r][c])
                        ds[i][j]++;
        }
    int res = 0;
    ArrayList<Integer> adds = new ArrayList<Integer>();
    int[] partners = new int[k];
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    for(int i = 0; i<k; i++)
        for(int j = 0; j<i; j++)
        {
            pq.add(new Edge(i, j, ds[i][j]*w));
        }
    for(int i = 0; i<k; i++) pq.add(new Edge(k, i, n*m));
    DisjointSet djs = new DisjointSet(k+1);
    ArrayList<Integer>[] g = new ArrayList[k+1];
    for(int i = 0; i<k+1; i++) g[i] = new ArrayList<Integer>();
    while(!pq.isEmpty())
    {
        Edge at = pq.poll();
        if(djs.find(at.from) != djs.find(at.to))
        {
            res += at.cost;
            djs.union(at.from,at.to);
            g[at.from].add(at.to);
            g[at.to].add(at.from);
        }
    }
    out.println(res);
    boolean[] vis = new boolean[k+1];
    Queue<Integer> q = new LinkedList<Integer>();
    vis[k] = true;
    q.add(k);
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int e: g[at])
        {
            if(vis[e]) continue;
            vis[e] = true;
            q.add(e);
            if(at == k) out.println((e+1)+" "+0);
            else out.println((e+1)+" "+(at+1));
        }
    }
    out.close();
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
public static class DisjointSet
{
    int[] map; //negative if root, more negative means bigger set; if nonnegative, then it indicates the parent 
    public DisjointSet(int n)
    {
        map = new int[n+1];
        Arrays.fill(map, -1);
    }
    public int find(int x)
    {
        if(map[x] < 0)
            return x;
        else
        {
            map[x] = find(map[x]);
            return map[x];
        }
    }
    public void union(int a, int b)
    {
        int roota = find(a), rootb = find(b);
        if(roota == rootb)
            return;
        if(map[roota] < map[rootb])
        {
            map[roota] += map[rootb]; //add the sizes
            map[rootb] = roota; //connect the smaller to the bigger
        }
        else
        {
            map[rootb] += map[roota];
            map[roota] = rootb;
        }
    }
}
static class Edge implements Comparable<Edge>
{
    int from, to , cost;
    public Edge(int ff, int tt, int cc)
    {
        from = ff; to = tt;
        cost = cc;
    }
    @Override
    public int compareTo(Edge o) {
        // TODO Auto-generated method stub
        return cost - o.cost;
    }
}
}