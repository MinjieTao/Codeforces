import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    /*
    boolean[] sieve = new boolean[1000001];
    Arrays.fill(sieve, true);
    sieve[0]=sieve[1]=false;
    for(int i = 2; i<sieve.length; i++) if(sieve[i]) for(long j = (long)i*i; j<sieve.length; j+=i) sieve[(int)j] = false;
    */
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    boolean allz = true;
    int n =input.nextInt(), m = input.nextInt();
    boolean[][] list = new boolean[n][m];
    for(int i = 0; i<n; i++)
    {
        int k = input.nextInt();
        allz &= k==0;
        for(int j = 0; j<k; j++)
        {
            int b = input.nextInt();
            list[i][b-1] = true;
        }
    }
    if(allz)
    {
        out.println(n);
        out.close();
        return;
    }
    boolean[][] adj = new boolean[n][n];
    for(int i = 0; i<n; i++)
        for(int j =0; j<n; j++)
            for(int k = 0; k<m; k++)
                adj[i][j] |= (list[i][k] && list[j][k]);
    for(int k = 0; k<n; k++)
        for(int i = 0; i<n; i++)
            for(int j =0; j<n; j++)
                adj[i][j] |= (adj[i][k] && adj[k][j]);
    int count = 0;
    for(int i = 0; i<n; i++)
    {
        boolean good = true;
        for(int j= 0; j<i; j++)
        {
            if(adj[i][j])
                good = false;
            
        }
        if(good) count++;
    }
    out.println(count-1);
    
    out.close();
}
public static long gcd(long a, long b)
{
if(b == 0) return a;
return gcd(b, a%b);
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
static class TidalFlow {
    ArrayDeque<Edge> stk = new ArrayDeque<Edge>();
    int N, s, t, oo = 987654321, fptr, bptr;
    ArrayList<Edge>[] adj;
    int[] q, dist, pool;

    @SuppressWarnings("unchecked")
    TidalFlow(int NN) {
        N=(t=(s=NN)+1)+1;
        adj = new ArrayList[N];
        for(int i = 0; i < N; adj[i++] = new ArrayList<Edge>());
        dist = new int[N];
        pool = new int[N];
        q = new int[N];
    }
    void add(int i, int j, int cap) {
        Edge fwd = new Edge(i, j, cap, 0);
        Edge rev = new Edge(j, i, 0, 0);
        adj[i].add(rev.rev=fwd);
        adj[j].add(fwd.rev=rev);
    }
    int augment() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        pool[t] = dist[s] = fptr = bptr = 0;
        pool[q[bptr++] = s] = oo;
        while(bptr > fptr && q[fptr] != t)
            for(Edge e : adj[q[fptr++]]) {
                if(dist[e.i] < dist[e.j])
                    pool[e.j] += e.carry = Math.min(e.cap - e.flow, pool[e.i]);
                if(dist[e.i] + 1 < dist[e.j] && e.cap > e.flow)
                    dist[q[bptr++] = e.j] = dist[e.i] + 1;
            }
        if(pool[t] == 0) return 0;
        Arrays.fill(pool, fptr = bptr = 0);
        pool[q[bptr++] = t] = oo;
        while(bptr > fptr) 
            for(Edge e : adj[q[fptr++]]) {
                if(pool[e.i] == 0) break;
                int f = e.rev.carry = Math.min(pool[e.i], e.rev.carry);
                if(dist[e.i] > dist[e.j] && f != 0) {
                    if(pool[e.j] == 0) q[bptr++] = e.j;
                    pool[e.i] -= f;
                    pool[e.j] += f;
                    stk.push(e.rev);
                }
            }
        int res = pool[s];
        Arrays.fill(pool, 0);
        pool[s] = res;
        while(stk.size() > 0) {
            Edge e = stk.pop();
            int f = Math.min(e.carry, pool[e.i]);
            pool[e.i] -= f;
            pool[e.j] += f;
            e.flow += f;
            e.rev.flow -= f;
        }
        return res;
    }
    int getFlow() {
        int res = 0, f = 1;
        while(f != 0)
            res += f = augment();
        return res;
    }
    class Edge {
        int i, j, cap, flow, carry;
        Edge rev;
        Edge(int ii, int jj, int cc, int ff) {
            i=ii; j=jj; cap=cc; flow=ff;
        }
    }
}
}