import java.util.*;
import java.io.*;
public class C455 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), Q = input.nextInt();
    int[] longest = new int[n];
    ArrayList<Integer>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    DisjointSet ds = new DisjointSet(n);
    for(int i =0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        ds.union(a, b);
        g[a].add(b);
        g[b].add(a);
    }
    boolean[] vis = new boolean[n], vis2 = new boolean[n];
    int[] dist = new int[n];
    Queue<Integer> q = new LinkedList<Integer>();
    for(int i = 0; i<n; i++)
    {
        if(vis[i]) continue;
        ArrayList<Integer> comp = new ArrayList<Integer>();
        q.add(i);
        dist[i] = 0;
        vis[i] = true;
        while(!q.isEmpty())
        {
            int at = q.poll();
            comp.add(at);
            for(int e : g[at])
            {
                if(vis[e]) continue;
                q.add(e);
                vis[e] = true;
                dist[e] = 1 + dist[at];
            }
        }
        int last = comp.get(comp.size()-1);
        q.add(last);
        vis2[last] = true;
        dist[last] = 0;
        int max = 0;
        while(!q.isEmpty())
        {
            int at = q.poll();
            max = dist[at];
            for(int e : g[at])
            {
                if(vis2[e]) continue;
                vis2[e] = true;
                dist[e] = 1+dist[at];
                q.add(e);
            }
        }
        for(int x: comp) longest[x] = max;
    }
    ds.setSize(longest);
    for(int i = 0; i<Q; i++)
    {
        int type = input.nextInt();
        if(type == 1)
        {
            out.println(ds.size[ds.find(input.nextInt()-1)]);
        }
        else
        {
            ds.union(input.nextInt()-1, input.nextInt()-1);
        }
    }
    out.close();
}
public static class DisjointSet
{
    int[] map; //negative if root, more negative means bigger set; if nonnegative, then it indicates the parent 
    int[] size;
    public DisjointSet(int n)
    {
        map = new int[n+1];
        Arrays.fill(map, -1);
        size = new int[n+1];
    }
    void setSize(int[] ss)
    {
        size = ss;
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
        int nsize = Math.max(size[roota], Math.max(size[rootb], 1+(size[roota]+1)/2 + (size[rootb]+1)/2));
        size[roota] = size[rootb] = nsize;
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