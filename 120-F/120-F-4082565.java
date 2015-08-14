import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  //input.init(System.in);
  //PrintWriter out = new PrintWriter(new PrintStream(System.out));
  input.init(new FileInputStream(new File("input.txt")));
  PrintWriter out = new PrintWriter(new File("output.txt"));
  int res = 0;
  int T = input.nextInt();
  for(int t = 0; t<T; t++)
  {
    int n = input.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[n];
    for(int i = 0; i<n; i++) adj[i] = new ArrayList<Integer>();
    for(int i = 0; i<n-1; i++)
    {
      int a = input.nextInt()-1, b = input.nextInt()-1;
      adj[a].add(b);
      adj[b].add(a);
    }
    int max = 0;
    for(int j = 0; j<n; j++)
    {
    int[] parent = new int[n];
    Arrays.fill(parent, -2);
    parent[j] = -1;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(j);
    while(!q.isEmpty())
    {
      int at = q.poll();
      for(int x: adj[at])
      {
        if(parent[x] == -2)
        {
          parent[x] = at;
          q.add(x);
        }
      }
    }
    int change = depth(parent, j);
    max = Math.max(max, change);
    }
    res += max;
  }
  out.println(res);
  out.close();
}
static int depth(int[] parent, int x)
{
  int res = 0;
  for(int i = 0; i<parent.length; i++)
  {
    if(parent[i] == x)
      res = Math.max(res, 1+depth(parent, i));
  }
  return res;
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