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
  int n = input.nextInt();
  last = new int[n];
  Arrays.fill(last, -1);
  visited = new int[n];
  adj = new boolean[n][n];
  for(int i = 0; i<n; i++)
  {
    String s = input.next();
    for(int j = 0; j<n; j++)
    {
      if(s.charAt(j) == '1')
      {
        adj[i][j] = true;
      }

    }
  }
  res = -1;
  for(int i = 0; i<n; i++) dfs(i);
  if(res == -1)out.println(res);
  if(res>-1)
  {
    for(int i = 0; i<n+1; i++) res = last[res];
    int len = 1, at = res;
    while(last[at] != res)
    {
      //out.println(at);
      at = last[at];
      len++;
      //out.println(at);
    }
    while(len > 3)
    {
      int c = res, b = last[res], a = last[last[res]];
      if(adj[c][a])
      {
        last[a] = c;
        len = 3;
      }
      else
      {
        last[c] = a;
        len--;
      }
    }
    out.println((last[last[res]]+1) + " " + (last[res]+1) + " "+(res+1));
  }



  out.close();
}
static boolean[][] adj;
static int[] last, visited;
static int res;
static void dfs(int x)
{
  visited[x] = 1;
  for(int i = 0; i<adj.length; i++)
  {
    if(!adj[x][i]) continue;
    if(visited[i] == 0)
    {
      last[i] = x;
      dfs(i);
    }
    else if(visited[i] == 1)
    {
      last[i] = x;
      res = i;
    }
  }
  visited[x] = 2;
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