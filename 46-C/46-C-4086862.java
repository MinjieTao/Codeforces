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
  String s = input.next();
  int min = 987654;
  for(int i = 0; i<n; i++)
  {
    //out.println("i: "+i);
    int a = i, b = (i+n-1)%n;
    char c = s.charAt(a);
    int diff = 0, res = 0;
    while(diff < n)
    {
      while(s.charAt(a) == c)
      {
        a = (a+1)%n;
        diff++;
      }
      while(s.charAt(b) != c)
      {
        b = (b+n-1)%n;
        diff++;
      }
      //swap a and b
      //out.println(diff);
      if(diff < n)
      {
        res++;
        a = (a+1)%n;
        b = (b+n-1)%n;
        diff+=2;
      }
    }
    min = Math.min(min, res);
  }
  out.println(min);

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