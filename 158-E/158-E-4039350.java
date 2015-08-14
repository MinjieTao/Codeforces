import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int n = input.nextInt(), k = input.nextInt();

  Call[] data = new Call[n];
  for(int i = 0; i<n; i++) data[i] = new Call(input.nextInt(), input.nextInt());
  //data[n] = new Call(86401, 0);
  Arrays.sort(data);
  int[][] dp = new int[n+1][k+1];
  Arrays.fill(dp[0], 1);
  for(int i = 1; i<=n; i++)
  {
    dp[i][0] = Math.max(dp[i-1][0], data[i-1].a) + data[i-1].b;
    for(int j = 1; j<=k; j++)
    {
      dp[i][j] = Math.min(dp[i-1][j-1], Math.max(dp[i-1][j], data[i-1].a)+data[i-1].b);
      //out.println(i+" "+j+" "+dp[i][j]);
    }
  }
  int res = 0;
  for(int i = 0; i<n; i++)
  {
    res = Math.max(res, data[i].a - dp[i][k]);
  }
  res = Math.max(res, 86401-dp[n][k]);
  out.println(res);
  out.close();

}
static class Call implements Comparable<Call> {
  int a, b;
  public Call(int aa, int bb)
  {
    a = aa; b = bb;
  }
  @Override
  public int compareTo(Call o) {
    // TODO(mkirsche): Auto-generated method stub
    return this.a - o.a;
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