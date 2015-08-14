import java.util.*;
import java.io.*;

public class b {
    static ArrayList<Integer>[] tree;
    static long[] data;
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        
        int n = input.nextInt();
        data = new long[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<Integer>();
        for(int i = 0; i<n-1; i++)
        {
            int a = input.nextInt()-1, b = input.nextInt()-1;
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        tree = new ArrayList[n];
        for(int i = 0; i<n; i++) tree[i] = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        parent[0] = -2;
        q.add(0);
        while(!q.isEmpty())
        {
            int at = q.poll();
            for(int e: adj[at])
            {
                if(parent[e] == -1)
                {
                    parent[e] = at;
                    q.add(e);
                    tree[at].add(e);
                }
            }
        }
        memo = new long[n][3];
        for(int i = 0; i<n; i++) memo[i][0] = -1;
        long[] ans = go(0);
        System.out.println(ans[0]);
        out.close();
    }
    static long[][] memo;
    static long[] go(int at)
    {
        if(tree[at].size()==0) return new long[]{0, data[at], 1};
        if(memo[at][0] != -1) return memo[at];
        long res = 0;
        ArrayList<Long> ans = new ArrayList<Long>();
        long lcm = 1;
        for(int e: tree[at])
        {
            long[] cur = go(e);
            res += cur[0];
            ans.add(cur[1]);
            lcm = lcm(lcm, cur[2]);
        }
        long min = (long)1e15;
        for(long x: ans){
            min = Math.min(min,  x);
        }
        long num = lcm <= 0 ? 0 : lcm*(min/lcm);
        //System.out.println(num);
        for(long x: ans) res += x - num;
        //System.out.println(at+" "+res+" "+min*ans.size()+" "+lcm*ans.size());
        return memo[at] = new long[]{res, num*ans.size(), lcm*ans.size()};
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
    static long lcm(long a, long b)
    {
        return a/gcd(a,b)*b;
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