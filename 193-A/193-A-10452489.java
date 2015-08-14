import java.util.*;
public class A122 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    char[][] grid = new char[n][m];
    for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
    boolean d1 = false;
    int count = 0;
    int[][] id = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(grid[i][j] == '#')
            {
                count++;
                int d = 0;
                if(i > 0 && grid[i-1][j] == '#') d++;
                if(i < n-1 && grid[i+1][j] == '#') d++;
                if(j > 0 && grid[i][j-1] == '#') d++;
                if(j < m - 1 && grid[i][j+1] == '#') d++;
                if(d == 1) d1 = true;
                id[i][j] = count - 1;
            }
        }
    g = new ArrayList[count];
    cut = false;
    c = count;
    for(int i = 0; i<count; i++) g[i] = new ArrayList<Edge>();
    int[] di = new int[]{0, 1, 0, -1};
    int[] dj = new int[]{1, 0, -1, 0};
    int ei = 0;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(grid[i][j] == '#')
            {
                for(int k = 0; k<4; k++)
                {
                    int ni = i + di[k], nj = j + dj[k];
                    if(ni < 0 || nj < 0 || ni >= n || nj >= m || grid[ni][nj] == '.') continue;
                    Edge e = new Edge(id[i][j], id[ni][nj], ei++);
                    g[id[i][j]].add(e);
                    //System.out.println(i+" "+j+" "+ni+" "+nj+" "+id[i][j] +" "+id[ni][nj]);
//                  //g[id[ni][nj]].add(new Edge(id[ni][nj], id[i][j], ei++));
                }
            }
        }
    BCC();
    if(count < 3) System.out.println(-1);
    else if(cut) System.out.println(1);
    else System.out.println(2);
}
static int c;
static boolean cut;
//Bi-Connected (2-Vertex Connected) Components - O(V + E)
//Divides the graph into (not necessarily disjoint) subgraphs that are biconnected.
//A subgraph is biconnected if after removing any vertex from that subgraph, the subgraph is still a connected component.
static ArrayList<Edge>[] g;
static int[] low;
static int[] pre;
static ArrayDeque<Edge> stk;
static int count, n;
static void BCC()
{
    Arrays.fill(pre = new int[n = g.length], -1);
    low = new int[n];
    stk = new ArrayDeque<Edge>();
    for(int i = count=0; i<n; i++)
        if(pre[i] == -1)
        {
            dfs(i, -1);
            if(!stk.isEmpty()) process(i);
        }
}
static void dfs(int at, int lastEdge)
{
    pre[at] = count++;
    low[at] = pre[at];
    boolean first = true;
    for(Edge e: g[at])
    {
        if(e.i == lastEdge) continue;
        if(pre[e.b] == -1) //Not visited yet
        {
            stk.push(e);
            dfs(e.b, e.i);
            low[at] = Math.min(low[at], low[e.b]);
            if((lastEdge != -1 || !first) && low[e.b] >= pre[at]) process(at);
        }
        else low[at] = Math.min(low[at], pre[e.b]);
        first = false;
    }
}
//Processes the component - its vertex indices will be in the HashSet comp.
static boolean found;
static void process(int at)
{
    //System.out.println(at);
    HashSet<Integer> comp = new HashSet<Integer>();
    while(!stk.isEmpty())
    {
        Edge cur = stk.pop();
        comp.add(cur.a);
        comp.add(cur.b);
        if(cur.a == at) break;
    }
    if(!found) found = true;
    else cut = true;
    //for(int x : comp) System.out.println(x);
    //System.out.println(comp.size());
    //if(comp.size() == c) cut = false;
}
static class Edge
{
    int a, b, i;
    public Edge(int aa, int bb, int ii)
    {
        a = aa; b = bb; i = ii;
    }
}
}