import java.util.*;
import java.io.*;
public class a {
  static long mod  = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), k = input.nextInt();
  long[] data = new long[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  sums = new long[n+1];
  sums[0] = 0;
  for(int i = 1; i<=n; i++) sums[i] = sums[i-1]+data[i-1];
  dp = new long[n][3];
  for(long[] A: dp) Arrays.fill(A, -1);
  trace = new boolean[n][3];
  go(0, 2, n, k);
  int at = 0;
  int found = 0;
  while(at<n && found<2)
  {
    int f = found;
    if(trace[at][2-f])
    {
      found++;
      out.print((at+1)+" ");
    }
    at = trace[at][2-f] ? at+k : at+1;
  }
  out.close();
}
static long[][] dp;
static long[] sums;
static boolean[][] trace;
static long go(int at, int left, int n, int k)
{
  if(at>n) return -987654321;
  if(left == 0) return 0;
  if(at==n) return -987654321;
  if(dp[at][left] != -1) return dp[at][left];
  long res = go(at+1, left, n, k);
  long old = res, next = -1;
  if(at+k<=n) res = Math.max(res, next = sums[at+k] - sums[at] + go(at+k, left-1, n, k));
  if(next>=old)
  {
    trace[at][left] = true;
  }
  return dp[at][left] = res;
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