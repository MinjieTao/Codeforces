import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> oddIndex = new ArrayList<Integer>(), evenIndex = new ArrayList<Integer>();
    ArrayList<Integer> oddFact = new ArrayList<Integer>(), evenFact = new ArrayList<Integer>();
    int n = input.nextInt(), m = input.nextInt();
    boolean[][] good = new boolean[n][n];
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt();
        for(int j = 2; j<= Math.sqrt(x); j++)
        {
            while(x%j == 0)
            {
                if(i%2 == 0)
                {
                    evenIndex.add(i);
                    evenFact.add(j);
                }
                else
                {
                    oddIndex.add(i);
                    oddFact.add(j);
                }
                x /= j;
            }
        }
        if(x > 1)
        {
            //System.out.println(i+" "+x);
            if(i%2 == 0)
            {
                evenIndex.add(i);
                evenFact.add(x);
            }
            else
            {
                oddIndex.add(i);
                oddFact.add(x);
            }
        }
    }
    for(int i = 0; i<m; i++)
    {
        good[input.nextInt()-1][input.nextInt()-1] = true;
    }
    TidalFlow tf = new TidalFlow(evenIndex.size() + oddIndex.size());
    for(int i = 0; i<evenIndex.size(); i++)
    {
        tf.add(tf.s, i, 1);
        for(int j = 0; j<oddIndex.size(); j++)
        {
            if(good[evenIndex.get(i)][oddIndex.get(j)] || good[oddIndex.get(j)][evenIndex.get(i)])
            {
                //System.out.println(i+" "+j);
                if(evenFact.get(i).equals(oddFact.get(j)))
                {
                    //System.out.println(i+" "+j);
                    tf.add(i, j+evenIndex.size(), 1);
                }
            }
        }
    }
    for(int i = 0; i<oddIndex.size(); i++)
    {
        tf.add(i+evenIndex.size(), tf.t, 1);
    }
    System.out.println(tf.getFlow());
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