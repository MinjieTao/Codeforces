import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    // Coordinate compression
    TreeSet<Integer> set = new TreeSet<Integer>();
    for(int x: data) set.add(x);
    HashMap<Integer, Integer> compressed = new HashMap<Integer, Integer>();
    int at = 1;
    // Iterate over distinct elements of array in sorted order, assigning each of them a number one higher than the previous.
    for(int x: set)
    {
        compressed.put(x, at);
        at++;
    }
    // Replace all values with compressed values so all numbers will be in the range [1, n].
    for(int i = 0; i<n; i++) data[i] = compressed.get(data[i]);
    BIT bit = new BIT(n);
    int[] biggerBefore = new int[n];
    for(int i = 0; i<n; i++)
    {
        // bit.csum(data[i]) will count how many elements that I already looked at are <= the value of the current element
        // i elements have been looked at before this, so subtract csum(data[i]) from this.
        biggerBefore[i] = i - bit.csum(data[i]);
        // add one to the sum of the current element's value
        bit.upd(data[i], 1);
    }
    int[] smallerAfter = new int[n];
    bit = new BIT(n); // reset BIT to all 0
    for(int i = n-1; i>=0; i--)
    {
        smallerAfter[i] = bit.csum(data[i] - 1);
        bit.upd(data[i], 1);
    }
    long res = 0;
    // Iterate over all possible middle elements of the triple.
    // The first one can be anything before it that's bigger.
    // The third one can be anything after it that's smaller.
    // So for each i, increase answer by biggerBefore[i] * smallerAfter[i]
    for(int i = 0; i<n; i++)
    {
        res += (long)biggerBefore[i] * smallerAfter[i];
    }
    System.out.println(res);
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