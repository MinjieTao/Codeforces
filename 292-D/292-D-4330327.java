import java.util.*;
import java.io.*;

public class a {
    static long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        int n = input.nextInt(), m = input.nextInt();
        int[] as = new int[m], bs = new int[m];
        for(int i = 0; i<m; i++)
        {
            as[i] = input.nextInt()-1;
            bs[i] = input.nextInt()-1;
        }
        DisjointSet[] pre = new DisjointSet[m+1];
        pre[0] = new DisjointSet(n);
        for(int i = 1; i<=m; i++)
        {
            pre[i] = new DisjointSet(n);
            for(int j = 0; j<n; j++)
                pre[i].map[j] = pre[i-1].map[j];
            pre[i].union(as[i-1], bs[i-1]);
        }
        DisjointSet[] post = new DisjointSet[m+1];
        post[m] = new DisjointSet(n);
        for(int i = m-1; i>=0; i--)
        {
            post[i] = new DisjointSet(n);
            for(int j = 0; j<n; j++)
                post[i].map[j] = post[i+1].map[j];
            post[i].union(as[i], bs[i]);
        }
        int k = input.nextInt();
        for(int i = 0; i<k; i++)
        {
            int a = input.nextInt()-1, b = input.nextInt()-1;
            DisjointSet ds1 = pre[a], ds2 = post[b+1];
            DisjointSet merge = new DisjointSet(n);
            for(int j = 0; j<n; j++) merge.map[j] = ds1.map[j];
            for(int j = 0; j<n; j++)
            {
                if(ds2.map[j] >= 0)
                    merge.union(ds2.map[j], j);
            }
            int count = 0;
            for(int j = 0; j<n; j++)
            {
                int x = merge.map[j];
                if(x<0) count++;
            }
            out.println(count);
        }
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