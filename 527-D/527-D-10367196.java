import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] xs = new int[n], ws = new int[n];
    Pair[] data = new Pair[n];
    for(int i = 0; i<n; i++)
    {
        xs[i] = input.nextInt();
        ws[i] = input.nextInt();
        data[i] = new Pair(xs[i], ws[i]);
    }
    Arrays.sort(data);
    for(int i = 0; i<n; i++)
    {
        xs[i] = data[i].x;
        ws[i] = data[i].w;
    }
    TreeSet<Integer> set = new TreeSet<Integer>();
    for(int i = 0; i<n; i++)
    {
        set.add(xs[i] - ws[i]);
        set.add(xs[i] + ws[i]);
    }
    HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>();
    int at = 0;
    for(int x : set) comp.put(x, ++at);
    BIT bit = new BIT(at);
    int[] dp = new int[n];
    int max = 0;
    for(int i = 0; i<n; i++)
    {
        dp[i] = 1 + bit.csum(comp.get(xs[i] - ws[i]));
        max = Math.max(max, dp[i]);
        bit.upd(comp.get(xs[i] + ws[i]), dp[i]);
    }
    System.out.println(max);
}
static class Pair implements Comparable<Pair>
{
    int x, w;
    public Pair(int xx, int ww)
    {
        x = xx; w = ww;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return x - o.x;
    }
}
static class BIT
{
    int[] tree;
    int n;
    BIT(int n)
    {
        tree = new int[n+1];
        this.n = n;
    }
    /*
     * Increases the value at x by v.
     */
    void upd(int x, int v)
    {
        int i = x;
        while(i<=n)
        {
            tree[i]=Math.max(tree[i], v);
            i += (i&-i);
        }
    }
    /*
     * Returns the sum of the first x elements.
     */
    int csum(int x)
    {
        int s = 0;
        while(x>0)
        {
            s = Math.max(s, tree[x]);
            x -= (x&-x);
        }
        return s;
    }
    /*
     * Returns the sum of elements x through y, inclusive.
     */
    int csum(int x, int y)
    {
        return csum(y) - csum(x-1);
    }
    /*
     * Returns the xth value in the tree.
     */
    int get(int x)
    {
        int sum = tree[x];
        int z = x - (x&-x);
        x--;
        while(x>z)
        {
            sum -= tree[x];
            x -= (x&-x);
        }
        return sum;
    }
    /*
     * Multiplies every element in the tree by a.
     */
    void scale(int a)
    {
        for(int i = 1; i<=n; i++) tree[i] *= a;
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