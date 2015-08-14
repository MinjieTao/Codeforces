import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    boolean[] prime = new boolean[100001];
    Arrays.fill(prime, true);
    for(int i = 2; i<prime.length; i++)
    {
        if(!prime[i]) continue;
        for(long j = (long)i*i; j < prime.length; j+=i)
        {
            prime[(int)j] = false;
        }
    }
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    TidalFlow tf = new TidalFlow(n);
    for(int i = 0; i<n; i++)
    {
        if(data[i]%2 == 0) tf.add(tf.s, i, 2);
        else tf.add(i, tf.t, 2);
        for(int j = i+1; j<n; j++)
        {
            if(prime[data[i] + data[j]])
            {
                if(data[i]%2 == 0)
                {
                    tf.add(i, j, 1);
                }
                else 
                {
                    tf.add(j, i, 1);
                }
            }
        }
    }
    int flow = tf.getFlow();
    if(flow == n)
    {
        int[][] adjs = new int[n][2];
        int[] ptrs = new int[n];
        for(ArrayList<TidalFlow.Edge> list : tf.adj)
        {
            for(TidalFlow.Edge e : list)
            {
                if(e.flow == 1)
                {
                    adjs[e.i][ptrs[e.i]++] = e.j;
                    adjs[e.j][ptrs[e.j]++] = e.i; 
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        boolean[] used = new boolean[n];
        for(int i = 0; i<n; i++)
        {
            if(used[i]) continue;
            ArrayList<Integer> toAdd = new ArrayList<Integer>();
            int at = i;
            int last = adjs[at][1];
            while(true)
            {
                int temp = last;
                last = at;
                at = adjs[at][0] == temp ? adjs[at][1] : adjs[at][0];
                used[at] = true;
                toAdd.add(at);
                if(at == i) break;
            }
            res.add(toAdd);
        }
        out.println(res.size());
        for(int i = 0; i<res.size(); i++)
        {
            out.print(res.get(i).size());
            for(int x : res.get(i))
                out.print(" "+(1+x));
                    out.println();
        }
    }
    else
    {
        out.println("Impossible");
    }
    out.close();
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