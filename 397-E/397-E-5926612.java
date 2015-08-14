import java.util.*;
import java.io.*;

public class c {
    static int mod = 1000000007;
    static int dec = 1;
    static int[] depths, pre, post;
    public static void main(String[] args) throws IOException {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        depths = new int[n];
        pre = new int[n];
        post = new int[n];
        g = new ArrayList[n];
        for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
        for(int i = 1; i<n; i++)
        {
            int p = input.nextInt()-1;
            depths[i] = depths[p]+1;
            g[p].add(i);
        }
        cnt = 0;
        dfs(0);
        int q = input.nextInt();
        IT it = new IT(n);
        for(int i = 0; i<q; i++)
        {
            int type = input.nextInt();
            if(type == 1)
            {
                int x = input.nextInt()-1, v = input.nextInt(), k = input.nextInt();
                //out.println(pre[x]+" "+post[x]+" "+v+" "+k+" "+depths[x]);
                //out.println("D: " + depths[x]);
                it.add(pre[x], post[x], v, k, depths[x]);
            }
            else
            {
                int x = input.nextInt()-1;
                int temp = x;
                x = pre[x];
                //out.println(x);
                long v = it.getVal(x), s = it.getSlope(x);
                //out.println(v+" "+s);
                long res = (v - depths[temp]*s)%mod;
                if(res < 0) res += mod;
                out.println(res);
            }
        }
        out.close();
    }
    static ArrayList<Integer>[] g;
    static int cnt;
    static void dfs(int at)
    {
        pre[at] = cnt++;
        for(int x: g[at]) dfs(x);
        post[at] = cnt - 1;
    }
    //Minimum Interval Tree
    static class IT
    {
        int[] left,right, val, a, b, prop, slope, pslope;
        IT(int n)
        {
            left = new int[4*n];
            right = new int[4*n];
            val = new int[4*n];
            slope = new int[4*n];
            prop = new int[4*n];
            pslope = new int[4*n];
            a = new int[4*n];
            b = new int[4*n];
            init(0,0, n-1);
        }
        int init(int at, int l, int r)
        {
            a[at] = l;
            b[at] = r;
            if(l==r)
                left[at] = right [at] = -1;
            else 
            {
                int mid = (l+r)/2;
                left[at] = init(2*at+1,l,mid);
                right[at] = init(2*at+2,mid+1,r);
            }
            return at++;
        }
        //return val at x
        int getVal(int x)
        {
            return go(x,x, 0);
        }
        int getSlope(int x)
        {
            return go2(x, x, 0);
        }
        void push(int at)
        {
            if(prop[at] != 0 || pslope[at] != 0)
            {
                go3(a[left[at]], b[left[at]], prop[at], pslope[at], left[at]);
                go3(a[right[at]], b[right[at]], prop[at], pslope[at], right[at]);
                prop[at] = 0;
                pslope[at] = 0;
            }
        }
        int go(int x,int y, int at)
        {
            if(at==-1 || y<a[at] || x>b[at]) return 0;
            if(x <= a[at] && y>= b[at]) return val[at];
            push(at);
            return (go(x, y, left[at]) + go(x, y, right[at]))%mod;
        }
        int go2(int x,int y, int at)
        {
            if(at==-1 || y<a[at] || x>b[at]) return 0;
            if(x <= a[at] && y>= b[at]) return slope[at];
            push(at);
            return (go2(x, y, left[at]) + go2(x, y, right[at]))%mod;
        }
        //add v - k*depth to elements x through y
        void add(int x, int y, int v, int k, int curDepth)
        {
            go3(x, y, (int)((v+(long)k*curDepth)%mod), k, 0);
            //go4(x, y, k, 0);
        }
        void go3(int x, int y, int v, int v2, int at)
        {
            if(at==-1) return;
            if(y < a[at] || x > b[at]) return;
            x = Math.max(x, a[at]);
            y = Math.min(y, b[at]);
            if(y == b[at] && x == a[at])
            {
                val[at] = (val[at]+v)%mod;
                prop[at] = (prop[at]+v)%mod;
                slope[at] = (slope[at]+v2)%mod;
                pslope[at] = (pslope[at]+v2)%mod;
                return;
            }
            push(at);
            go3(x, y, v, v2, left[at]);
            go3(x, y, v, v2, right[at]);
        }
    }

    public static class input {
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
    }
}