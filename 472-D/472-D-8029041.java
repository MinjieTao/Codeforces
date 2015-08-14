import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[][] data = new int[n][n];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
            data[i][j] = input.nextInt();
    Edge[] pq = new Edge[n*(n-1)/2];
    int cur = 0;
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
            if(data[i][j] > 0)
            pq[cur++] = (new Edge(i, j, data[i][j]));
    pq = Arrays.copyOfRange(pq, 0, cur);
    Arrays.sort(pq);
    DisjointSet ds = new DisjointSet(n);
    ArrayList<Edge>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
    for(int i = 0; i<cur; i++)
    {
        Edge e = pq[i];
        if(ds.find(e.from) == ds.find(e.to)) continue;
        ds.union(e.from, e.to);
        g[e.from].add(e);
        g[e.to].add(e);
    }
    int[][] paths = new int[n][n];
    for(int i = 0; i<n; i++)
    {
        Arrays.fill(paths[i], -1);
        paths[i][i] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i);
        while(!q.isEmpty())
        {
            int at = q.poll();
            for(Edge e: g[at])
            {
                int to = e.to;
                if(to == at) to = e.from;
                if(paths[i][to] != -1) continue;
                paths[i][to] = paths[i][at] + e.dist;
                q.add(to);
            }
        }
    }
    boolean good = true;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
            good &= paths[i][j] == data[i][j];
    System.out.println(good ? "YES" : "NO");
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
    int from, to, dist;
    public Edge(int ff, int tt, int dd)
    {
        from = ff; to = tt; dist = dd;
    }
    @Override
    public int compareTo(Edge o) {
        // TODO Auto-generated method stub
        return dist - o.dist;
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