import java.util.*;
import java.io.*;
public class C225 {
    static int[] depths, pre, post;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    depths = new int[n];
    pre = new int[n];
    Arrays.fill(pre, -1);
    post = new int[n];
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    int[] init = new int[n];
    for(int i = 0; i<n; i++) init[i] = input.nextInt();
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }
    count = 1;
    depths[0] = 0;
    go(0);
    BIT even = new BIT(2*n+2), odd = new BIT(2*n+2);
    for(int i = 0; i<m; i++)
    {
        int type = input.nextInt(), x = input.nextInt()-1;
        if(type == 1)
        {
            //System.out.println(pre[x]+" "+post[x]+" "+depths[x]);
            int val = input.nextInt();
            if(depths[x]%2 == 1) val = -val;
            even.upd(post[x] + 1, -val);
            even.upd(pre[x], val);
            odd.upd(pre[x], -val);
            odd.upd(post[x] + 1, val);
//          for(int j = 0; j<n; j++)
//          {
//              out.print((depths[j]%2 == 0 ? even : odd).csum(pre[x])+" ");
//          }
//          out.println();
        }
        else
        {
            if(depths[x]%2 == 0) out.println(init[x] + even.csum(pre[x]));
            else out.println(init[x] + odd.csum(pre[x]));
        }
    }
    out.close();
}
static int count;
static ArrayList<Integer>[] g;
static void go(int at)
{
    pre[at] = count++;
    for(int e : g[at])
    {
        if(pre[e] != -1) continue;
        depths[e] = 1 + depths[at];
        go(e);
    }
    post[at] = count++;
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