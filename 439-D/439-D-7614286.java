import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    int[] as = new int[n], bs = new int[m];
    for(int i  =0; i<n; i++) as[i] = input.nextInt();
    for(int i = 0; i<m; i++) bs[i] = input.nextInt();
    long min = (long)1e9, max = 0;
    for(int i = 0; i<n; i++) min = Math.min(min, as[i]);
    for(int i = 0; i<m; i++) max = Math.max(max, bs[i]);
    long lo = min, hi = max;
    while(lo < hi-2)
    {
        //System.out.println(lo+" "+hi);
        long mid1 = (lo+lo+hi)/3;
        long mid2 = (lo+hi+hi)/3;
        if(go(as, bs, mid1) < go(as, bs, mid2)) hi = mid2;
        else lo = mid1;
    }
    while(go(as, bs, lo+1) < go(as, bs, lo)) lo++;
    while(go(as, bs, lo-1) < go(as, bs, lo)) lo--;
    out.println(go(as, bs, lo));
    out.close();
}
static long go(int[] as, int[] bs, long x)
{
    long res = 0;
    for(int i = 0; i<as.length; i++) if(x > as[i]) res += x - as[i];
    for(int i = 0; i<bs.length; i++) if(bs[i] > x) res += bs[i] - x;
    return res;
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