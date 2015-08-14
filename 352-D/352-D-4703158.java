import java.util.*;
import java.io.*;
public class b {
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        BIT bit = new BIT(n);
        int res = 0;
        for(int i = 0; i<n; i++)
        {
            res += i-bit.csum(data[i]);
            bit.upd(data[i], 1);
        }
        if(res == 0) out.println(0);
        else out.println(res%2 == 0 ? 2*res : 2*res-1);
        
        
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
    /*
     * 2-dimensional binary indexed tree - supports updates and range queries in 2 dimensions.
     * All operations are O(log(n)*log(m)).
     * Note: It is possible to make it do range updates and single element queries.  To do so,
     * the following is required: 
     * upd(x1, y1, v); upd(x1, y2+1, -v); upd(x2+1, y1, -v); upd(x2+1, y2+1, v);
     * Then, a point query is simply csum(x, y).
     */
    static class BIT2
    {
        int[][] tree;
        int n, m;
        BIT2(int n, int m)
        {
            tree = new int[n+1][m+1];
            this.n = n;
            this.m = m;
        }
         //Increases a[x][y] by v.
        void upd(int x, int y, int v)
        {
            while(x<=n)
            {
                int z=y;
                while(z<=m)
                {
                    tree[x][z]+=v;
                    z+=(z&-z);
                }
                x+=(x&-x);
            }
        }
        //Gets sum of elements in rectangle [1][1] to [x][y]
        int csum(int x, int y)
        {
            int s = 0;
            while(x>0)
            {
                int z = y;
                while(z>0)
                {
                    s += tree[x][z];
                    z -= (z&-z);
                }
                x -= (x&-x);
            }
            return s;
        }
        //Gets a[x][y].
        //This can be optionally sped up by mimicking what the 1-D tree does.
        int get(int x, int y)
        {
            return csum(x, y) - csum(x-1, y) - csum(x, y-1) + csum(x-1, y-1);
        }
    }

    static long pow(long x, long p) {
        if (p == 0)
            return 1;
        if ((p & 1) > 0) {
            return (x * pow(x, p - 1)) % mod;
        }
        long sqrt = pow(x, p / 2);
        return (sqrt * sqrt) % mod;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static class input {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                // TODO add check for eof if necessary
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static String nextLine() throws IOException {
            return reader.readLine();
        }
    }
}