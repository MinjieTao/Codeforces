import java.util.*;
import java.io.*;
public class c {
    static long mod = (long)1e9+7;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    int[] as = new int[m], bs = new int[m], cs = new int[m];
    for(int i = 0; i<m; i++)
    {
        as[i] = input.nextInt()-1;
        bs[i] = input.nextInt()-1;
        cs[i] = input.nextInt();
    }
    DisjointSet ds = new DisjointSet(n);
    for(int i = 0; i<m; i++)
    {
        if(cs[i] == 1) ds.union(as[i], bs[i]);
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int cnt = 0;
    for(int i = 0; i<n; i++)
        if(ds.map[i] < 0)
            map.put(i, cnt++);
    HashSet<Integer>[] g = new HashSet[cnt];
    for(int i = 0; i<cnt; i++) g[i] = new HashSet<Integer>();
    boolean good = true;
    for(int i = 0; i<m; i++)
    {
        if(cs[i] == 0)
        {
            int a = map.get(ds.find(as[i]));
            int b = map.get(ds.find(bs[i]));
            if(a == b) good = false;
            g[a].add(b);
            g[b].add(a);
        }
    }
    int[] color = new int[cnt];
    Arrays.fill(color, -1);
    long res = 1;
    for(int i = 0; i<cnt; i++)
    {
        //System.out.println(i+" "+Arrays.toString(color));
        if(color[i] > -1) continue;
        res = (res * 2) %mod;
        Queue<Integer> q = new LinkedList<Integer>();
        color[i] = 0;
        q.add(i);
        while(!q.isEmpty())
        {
            int at = q.poll();
            for(int e : g[at])
            {
                if(color[e] == 1 - color[at]) continue;
                if(color[e] == color[at])
                {
                    good = false;
                    break;
                }
                color[e] = 1 - color[at];
                q.add(e);
            }
        }
    }
    out.println(good ? (res * ((mod+1)/2))%mod : 0);
    out.close();
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