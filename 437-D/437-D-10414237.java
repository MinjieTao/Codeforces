import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    Edge[] data = new Edge[m];
    int[] xs = new int[n];
    for(int i = 0; i<n; i++) xs[i] = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int a, b;
        data[i] = new Edge(a=(input.nextInt()-1), b =(input.nextInt()-1), Math.min(xs[a], xs[b]));
    }
    Arrays.sort(data);
    double res = 0;
    DisjointSet ds = new DisjointSet(n);
    for(int i = 0; i<m; i++)
    {
        int ra = ds.find(data[i].a);
        int rb = ds.find(data[i].b);
        if(ra == rb) continue;
        res += (long)data[i].d * ds.map[ra] * ds.map[rb];
        ds.union(ra, rb);
    }
    System.out.println(res / ((long)n * (n-1) / 2));
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
    int a, b, d;
    public Edge(int aa, int bb,int dd)
    {
        a = aa; b = bb; d = dd;
    }
    @Override
    public int compareTo(Edge o) {
        // TODO Auto-generated method stub
        return o.d - d;
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