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
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  if(n<3) out.println(-1);
  else
  {
    boolean allSame = true;
    for(int i = 1; i<n; i++) allSame &= data[i] == data[0];
    if(allSame)out.println(-1);
    else
    {
      int firstdiff = 0;
      for(int i = 1; i<n; i++) if(data[i] != data[0])
      {
        firstdiff = i;
        break;
      }
      int third = -1;
      for(int i = firstdiff + 1; i<n; i++) if(data[i] != data[0] && data[i] != firstdiff) third = i;
      if(n>3) third = firstdiff == 1 ? 2: 1;
      if(third == -1) out.println(-1);
      else if(go(data, 0, firstdiff)) out.println(1+" "+(firstdiff+1));
      else if(data[third] != data[0] && go(data, 0, third)) out.println(1+" "+(third+1));
      else if(data[firstdiff] != data[third] && go(data, firstdiff, third)) out.println((firstdiff+1)+" "+(third+1));
      else
      {
        int fourth = firstdiff == 3 ? 2 : 3;
        if(data[0] != data[fourth] && go(data, 0, fourth)) out.println(1+" "+(fourth+1));
        else if(data[firstdiff] != data[fourth] && go(data, firstdiff, fourth)) out.println((firstdiff+1)+" "+(fourth+1));
      }
    }
  }

  out.close();
}
static boolean go(int[] a, int x, int y)
{
  int[] b = new int[a.length];
  for(int i = 0; i<a.length; i++) b[i] = a[i];
  b[x] = a[y];
  b[y] = a[x];
  boolean up = false, down = false;
  for(int i = 0; i<b.length - 1; i++)
  {
    up |= b[i+1]>b[i];
    down |= b[i+1]<b[i];
  }
  return up && down;
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