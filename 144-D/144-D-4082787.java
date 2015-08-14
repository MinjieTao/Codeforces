import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), m = input.nextInt(), s = input.nextInt()-1;
  ArrayList<Edge>[] adj = new ArrayList[n];
  for(int i = 0; i<n; i++) adj[i] = new ArrayList<Edge>();
  int[] as = new int[m], bs = new int[m], ds = new int[m];
  for(int i = 0; i<m; i++)
  {
    int a = input.nextInt()-1, b = input.nextInt()-1, dist = input.nextInt();
    as[i] = a; bs[i] = b; ds[i] = dist;
    adj[a].add(new Edge(b, dist));
    adj[b].add(new Edge(a, dist));
  }
  int[] min = new int[n];
  Arrays.fill(min, 987654321);
  min[s] = 0;
  PriorityQueue<State> pq = new PriorityQueue<State>();
  pq.add(new State(s, 0));
  while(!pq.isEmpty())
  {
    State cur = pq.poll();
    if(min[cur.at] < cur.dist) continue;
    for(Edge e: adj[cur.at])
    {
      int to = e.to, dist = e.len+cur.dist;
      if(dist < min[to])
      {
        min[to] = dist;
        pq.add(new State(to, dist));
      }
    }
  }
  int l = input.nextInt();
  int count = 0;
  for(int i = 0; i<n; i++)
  {
    //out.println(i+" "+min[i]);
    if(min[i] == l) count++;
  }
  for(int i = 0; i<m; i++)
  {
    int d1 = min[as[i]], d2 = min[bs[i]];
    int x1 = -1, x2 = -1;
    //out.println(d1+" "+d2+" "+ds[i]);
    if(d1 < l && d1+ds[i] > l)
    {
      x1 = l - d1;
      //out.println(i+" "+x1);
      if(d2 + ds[i] - x1 < l) x1 = -1;
    }
    if(d2 < l && d2+ds[i] > l)
    {
      x2 = ds[i] - (l - d2);
      if(d1 + x2 < l) x2 = -1;
      if(x1==x2) x2 = -1;
    }
    if(x1>-1) count++;
    if(x2>-1) count++;
  }
  out.println(count);

  out.close();
}
static class State implements Comparable<State>
{
  int at, dist;
  public State(int a, int d)
  {
    at = a;
    dist = d;
  }
  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(State o) {
    // TODO(mkirsche): Auto-generated method stub
    return this.dist - o.dist;
  }
}
static class Edge
{
  int to, len;
  public Edge(int t, int l)
  {
    to = t; len = l;
  }
}
static long[][] comb(int n)
{
  long[][] res = new long[n+1][n+1];
  Arrays.fill(res[0], 0);
  for(int i = 0; i<=n; i++) res[i][0] = 1;
  for(int i = 1; i<=n; i++)
    for(int j = 1; j<=n; j++)
      res[i][j] = (res[i-1][j-1] + res[i-1][j])%mod;
  return res;
}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b, a%b);
}
static long pow(long a, long p)
{
  if(p<=0) return 1;
  if((p&1) == 0)
  {
    long sqrt = pow(a, p/2);
    return (sqrt*sqrt)%mod;
  }
  else
    return (a*pow(a,p-1))%mod;
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

  /**
   * @return
   */
  public static boolean hasNext() {
    // TODO(mkirsche): Auto-generated method stub
    return tokenizer.hasMoreTokens();
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