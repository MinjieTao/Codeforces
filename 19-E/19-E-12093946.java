import java.util.*;
import java.io.*;
public class e19 {
public static void main(String[] args) throws IOException
{
  Scanner input = new Scanner(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), m = input.nextInt();
  ArrayList<Edge>[] g = new ArrayList[n];
  int[] as = new int[m], bs = new int[m];
  for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
  for(int i = 0; i<m; i++)
  {
    int a = input.nextInt()-1, b = input.nextInt()-1;
    as[i] = a;
    bs[i] = b;
    g[a].add(new Edge(b, i));
    g[b].add(new Edge(a, i));
  }
  int[] ps = new int[n];
  int[] upEdgeIndex = new int[n];
  Arrays.fill(ps, -2);
  Arrays.fill(upEdgeIndex, -1);
  Queue<Integer> q = new LinkedList<Integer>();
  ArrayList<Edge>[] tree = new ArrayList[n];
  for(int i = 0; i<n; i++) tree[i] = new ArrayList<Edge>();
  int[] depth = new int[n];
  boolean[] used = new boolean[m];
  for(int i = 0; i<n; i++)
  {
    if(ps[i] != -2) continue;
    ps[i] = -1;
    q.add(i);
    depth[i] = 0;
    while(!q.isEmpty())
    {
      int at = q.poll();
      for(Edge e : g[at])
        if(ps[e.to] == -2)
        {
          ps[e.to] = at;
          upEdgeIndex[e.to] = e.i;
          used[e.i] = true;
          depth[e.to] = 1 + depth[at];
          q.add(e.to);
          tree[at].add(e);
        }
    }
  }
  ArrayList<Integer> cycleEdges = new ArrayList<Integer>();
  for(int i = 0; i<m; i++)
  {
    if(used[i]) continue;
    if(depth[as[i]]%2 == depth[bs[i]]%2)
    {
      used[i] = true;
      cycleEdges.add(i);
    }
  }
  
  LCA lcaq = new LCA(tree);
  int[] delta = new int[n];
  for(int x : cycleEdges)
  {
    int a = as[x], b = bs[x];
    int lca = lcaq.query(a, b);
    delta[a]++;
    delta[b]++;
    delta[lca]-=2;
  }
  for(int x = 0; x<m; x++)
  {
    if(used[x]) continue;
    int a = as[x], b = bs[x];
    int lca = lcaq.query(a, b);
    delta[a]--;
    delta[b]--;
    delta[lca]+=2;
  }
  int[] vals = new int[n];
  q = new LinkedList<Integer>();
  int[] degs = new int[n];
  for(int i = 0; i<n; i++)
  {
    degs[i] = tree[i].size();
    if(degs[i] == 0) q.add(i);
  }
  while(!q.isEmpty())
  {
    int at = q.poll();
    vals[at] += delta[at];
    if(ps[at] != -1)
    {
      vals[ps[at]] += vals[at];
      degs[ps[at]]--;
      if(degs[ps[at]] == 0) q.add(ps[at]);
    }
  }
  ArrayList<Integer> res = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
    if(vals[i] == cycleEdges.size() && ps[i] != -1) res.add(upEdgeIndex[i]);
  }
  if(cycleEdges.size() == 1)
  {
    res.add(cycleEdges.get(0));
  }
  else if(cycleEdges.size() == 0)
  {
    res = new ArrayList<Integer>();
    for(int i = 0; i<m; i++)
      res.add(i);
  }
  Collections.sort(res);
  out.println(res.size());
  for(int x : res) out.print((x+1)+" ");
  out.close();
}
static class Edge
{
  int to, i;
  public Edge(int tt, int ii)
  {
    to = tt; i = ii;
  }
}
public static class LCA {
    int n;
    int currIdx = 0;
    int currArrIdx = 0;
    public int[] idx;
    public int[] invIdx;
    public int[] arrIdx;
    public int[] level;
    public long[] arr;
    public ArrayList<Edge>[] children;
    RangeMinimumQuery rmq;
    public LCA(ArrayList<Edge> children[]) {
        this.children = children;
        n = children.length;

        idx = new int[n];
        invIdx = new int[n];
        arrIdx = new int[n];
        level = new int[n];
        arr = new long[n << 2];

        dfs();
        rmq = new RangeMinimumQuery(arr);
    }
    public int query(int u, int v) {
        int x = Math.min(arrIdx[u], arrIdx[v]);
        int y = Math.max(arrIdx[u], arrIdx[v]);
        return invIdx[(int) rmq.query(x, y)];
    }
    private void dfs() {

        boolean[] processed = new boolean[n];
        ArrayDeque<Integer> stk = new ArrayDeque<Integer>(n);
        for(int i = 0; i<n; i++)
        {
          if(processed[i]) continue;
          int root = i;
          stk.push(root);
          while (!stk.isEmpty()) {
              int u = stk.pop();
              if (!processed[u]) {
                  processed[u] = true;
                  idx[u] = currIdx;
                  invIdx[currIdx++] = u;
                  arrIdx[u] = currArrIdx;
                  arr[currArrIdx++] = idx[u];
                  for (Edge e: children[u]) {
                    int v = e.to;
                      level[v] = level[u] + 1;
                      stk.push(u);
                      stk.push(v);
                  }
              }
              else {
                  arr[currArrIdx++] = idx[u];
              }
          }
        }
    }
}
public static class RangeMinimumQuery {

  int n;
  private long[][] memo;
  private int[] log;

  public RangeMinimumQuery(long[] arr) {
      n = arr.length;

      log = new int[n + 1];
      for (int i = 2; i <= n; i++) {
          log[i] = log[i >> 1] + 1;
      }

      int d = log[n];
      memo = new long[n][d];

      for (int i = 0; i < n; i++) {
          memo[i][0] = arr[i];
      }
      for (int j = 1; j < d; j++) {
          for (int k = 0; k < n - (1 << j); k++) {
              memo[k][j] = Math.min(memo[k][j - 1], memo[k + (1 << (j - 1))][j - 1]);
          }
      }
  }

  public long query(int a, int b) {
      if (b < a || a < 0 || b >= n) {
          throw new IndexOutOfBoundsException();
      }

      long res = Long.MAX_VALUE;

      int d = b - a + 1;
      int idx = 0, bit = 1;
      while (d > 0) {
          if ((d & bit) > 0) {
              res = Math.min(res, memo[a][idx]);
              a += bit;
              d ^= bit;
          }

          idx++;
          bit <<= 1;
      }

      return res;
  }
}
}