import java.util.*;
public class Abby3_C {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[][] data = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            data[i][j] = input.nextInt();
    MinCostFlow mcf = new MinCostFlow(n*m+2);
    mcf.s = n*m;
    mcf.t = n*m+1;
    int[] di = new int[]{1, 0, -1, 0};
    int[] dj = new int[]{0, 1, 0, -1};
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<m; j++)
        {
            if((i+j)%2 == 0)
            {
                mcf.add(mcf.s, i*m+j, 1, 0);
                for(int k = 0; k<4; k++)
                {
                    int ni = i+di[k], nj = j+dj[k];
                    if(ni<0||nj<0||ni>=n||nj>=m) continue;
                    int cost = data[i][j] == data[ni][nj] ? 0 : 1;
                    mcf.add(i*m+j, ni*m+nj, 1, cost);
                }
            }
            else
            {
                mcf.add(i*m+j, mcf.t, 1, 0);
            }
        }
    }
    System.out.println(mcf.minCostFlow()[1]);
}
public static class MinCostFlow{
    int N, s,t;
    ArrayList<Edge>[] adj;
    final int oo = 987654321;
    boolean negCosts;
    int[] pi,dist;
    Edge[] prev;
    
    public MinCostFlow(int n){
        N = n;
        adj = new ArrayList[N];
        for(int i = 0; i < N; i++)
            adj[i] = new ArrayList<Edge>();
        pi = new int[N];
        prev = new Edge[N];
        dist = new int[N];
    }
    
    void add(int u, int v, int cap, int cost){
        Edge e = new Edge(u,v,cap,cost);
        negCosts |= (cost < 0);
        Edge r = new Edge(v,u,0,cap,-cost);
        e.rev = r;
        r.rev = e;
        adj[u].add(e);
        adj[v].add(r);
    }
    
    public boolean dijkstra(){
        Arrays.fill(prev, null);
        Arrays.fill(dist,oo);
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        dist[s] = 0;
        q.add(new Pair(s,0));
        while(q.size() > 0){
            Pair p = q.poll();
            int cur = p.first, d = p.second;
            if(dist[cur] < d)
                continue;
            for(Edge e: adj[cur])
                if(e.resid > 0 && dist[e.v] > dist[cur] + e.pcost()){
                    dist[e.v] = dist[cur] + e.pcost();
                    prev[e.v] = e;
                    q.add(new Pair(e.v, dist[e.v]));
                }
        }
        for(int i = 0; i < N; i++)
            if(pi[i] < oo)
                pi[i] += dist[i];
        return prev[t] != null;
    }
    
    public int[] minCostFlow(){
        int flow = 0, cost = 0;
        if(negCosts){
            Arrays.fill(dist,oo);
            dist[s] = 0;
            for(int k = 0; k < N-1; k++)
                for(int i = 0; i < N; i++)
                    for(Edge e:adj[i])
                        if(e.resid > 0 && dist[e.v] > dist[e.u] + e.cost)
                            dist[e.v] = dist[e.u] + e.cost;
            for(int i = 0; i < N; i++)
                if(pi[i] < oo)
                    pi[i] += dist[i];
        }
        while(dijkstra()){
            int f = Integer.MAX_VALUE/2;
            for(int cur = t; cur != s; cur = prev[cur].u)
                f = Math.min(f, prev[cur].resid);
            for(int cur = t; cur != s; cur = prev[cur].u){
                prev[cur].resid -= f;
                prev[cur].rev.resid += f;
                cost += prev[cur].cost * f;
            }
            flow += f;
        }
        return new int[]{flow,cost};
    }
    
    public class Edge{
        int u,v,resid,cap,cost;
        Edge rev;
        public Edge(int uu, int vv, int cp, int ct){
            u = uu;
            v = vv;
            resid = cap = cp;
            cost = ct;
        }
        public Edge(int uu, int vv, int rr, int cp, int ct){
            this(uu,vv,cp,ct);
            resid = rr;
        }
        int pcost(){
            return resid > 0?cost+pi[u]-pi[v]:0;
        }
    }
    public class Pair implements Comparable<Pair>{
        int first,second;
        public Pair(int ff, int ss){
            first = ff;
            second = ss;
        }
        public int compareTo(Pair p){
            return second-p.second;
        }
        public String toString(){
            return "("+first +", "+second+")";
        }
    }
}
}