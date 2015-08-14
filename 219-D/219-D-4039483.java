import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static int[] depth, goods;
  static ArrayList<Edge>[] tree;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int n = input.nextInt();
  ArrayList<Edge>[] adj = new ArrayList[n];
  for(int i = 0; i<n; i++) adj[i] = new ArrayList<Edge>();
  for(int i = 0; i<n-1; i++)
  {
    int a = input.nextInt()-1, b = input.nextInt()-1;
    adj[a].add(new Edge(b, true));
    adj[b].add(new Edge(a, false));
  }
  tree = new ArrayList[n];
  for(int i = 0; i<n; i++) tree[i] = new ArrayList<Edge>();
  Queue<Integer> q = new LinkedList<Integer>();
  boolean[] visited = new boolean[n];
  q.add(0);
  visited[0] = true;
  int numGood = 0;
  while(!q.isEmpty())
  {
    int at = q.poll();
    //System.out.println(adj[at].size());
    for(Edge e: adj[at])
    {
      //System.out.println(e.to);
      if(!visited[e.to])
      {
        visited[e.to] = true;
        q.add(e.to);
        if(e.good) numGood++;
        tree[e.to].add(new Edge(at, e.good));
      }
    }
  }
  //for(boolean b: visited) System.out.println(b);
  depth = new int[n];
  goods = new int[n];
  Arrays.fill(depth, -1);
  depth[0]=0;
  for(int i = 0; i<n; i++) calcDepth(i);
  int min = n;
  for(int i = 0; i<n; i++) min = Math.min(min, n-1-numGood+goods[i]-(depth[i]-goods[i]));
  out.println(min);
  for(int i = 0; i<n; i++)
  {
    int x = n-1-numGood+goods[i]-(depth[i]-goods[i]);
    if(x==min) out.print((i+1)+" ");
  }



  out.close();

}
static int calcDepth(int at)
{
  //System.out.println(at);
  if(at==0) return 0;
  if(depth[at] != -1) return depth[at];
  Edge go = tree[at].get(0);
  int parentDepth = calcDepth(go.to);
  if(go.good) goods[at] = goods[go.to] +1;
  else goods[at] = goods[go.to];
  return depth[at] = 1+parentDepth;

}
static class Edge{
  int to;
  boolean good;
  public Edge(int tt, boolean gg)
  {
    to = tt;
    good = gg;
  }
}
static class input {
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
  static long nextLong() throws IOException {
    return Long.parseLong( next() );
}

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}