import java.util.*;
import java.io.*;
public class b {
    static long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        
        int n = input.nextInt();
        BIT2[][] bits = new BIT2[2][2];
        for(int i = 0; i<2; i++) for(int j = 0; j<2; j++) bits[i][j] = new BIT2(n+1, n+1);
        int m = input.nextInt();
        for(int i = 0; i<m; i++)
        {
            int type = input.nextInt();
            int x1 = input.nextInt(), y1 = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
            if(type == 2)
            {
                long v = input.nextLong();
                bits[x1&1][y1&1].upd(x1, y1, v);
                bits[x1&1][1-y2&1].upd(x1, y2+1, v);
                bits[1-x2&1][y1&1].upd(x2+1, y1, v);
                bits[1-x2&1][1-y2&1].upd(x2+1, y2+1, v);
            }
            else
            {
                long res = bits[x2&1][y2&1].csum(x2, y2);
                res ^= bits[1-x1&1][y2&1].csum(x1-1, y2);
                res ^= bits[x2&1][1-y1&1].csum(x2, y1-1);
                res ^= bits[1-x1&1][1-y1&1].csum(x1-1, y1-1);
                out.println(res);
            }
        }
        
        out.close();
    }
    /*
     * 2-dimensional binary indexed tree - supports updates and range queries in 2 dimensions.
     * All operations are O(log(n)*log(m)).
     */
    static class BIT2
    {
        long[][] tree;
        int n, m;
        BIT2(int n, int m)
        {
            tree = new long[n+1][m+1];
            this.n = n;
            this.m = m;
        }
         //Xors a[x][y] by v.
        void upd(int x, int y, long v)
        {
            while(x<=n)
            {
                int z=y;
                while(z<=m)
                {
                    tree[x][z]^=v;
                    z+=(z&-z);
                }
                x+=(x&-x);
            }
        }
        //Gets xor sum of elements in rectangle [1][1] to [x][y]
        long csum(int x, int y)
        {
            long s = 0;
            while(x>0)
            {
                int z = y;
                while(z>0)
                {
                    s ^= tree[x][z];
                    z -= (z&-z);
                }
                x -= (x&-x);
            }
            return s;
        }
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