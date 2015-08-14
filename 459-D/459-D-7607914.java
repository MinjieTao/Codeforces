import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    TreeSet<Integer> ts = new TreeSet<Integer>();
    for(int x: data) ts.add(x);
    HashMap<Integer, Integer> compress = new HashMap<Integer, Integer>();
    int at = 0;
    for(int x: ts) compress.put(x, at++);
    for(int i = 0; i<n; i++) data[i] = compress.get(data[i]);
    int[] counts = new int[n];
    int[] fwd = new int[n], back = new int[n];
    for(int i = 0; i<n; i++)
        fwd[i] = ++counts[data[i]];
    counts = new int[n];
    for(int i = n-1; i>=0; i--)
        back[i] = ++counts[data[i]];
    BIT bit = new BIT(n+1);
    for(int i = 0; i<n; i++) bit.upd(back[i], 1);
    long res = 0;
    for(int i = 0; i<n; i++)
    {
        bit.upd(back[i], -1);
        res += bit.csum(fwd[i]-1);
    }
    out.println(res);
    out.close();
}
/*
 * Binary Indexed Tree - used for updates and range queries.  Every operation is O(log(n)).
 * Note: It is possible to make it do range updates and single element queries.  To do so,
 * the following is required: upd(a, v); upd(b+1, -v);  (Be careful of bounds on right side!)
 * Then, a point query is simply csum(x).
 */
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
            tree[i]+=v;
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
            s += tree[x];
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