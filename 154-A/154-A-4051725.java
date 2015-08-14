import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  String s = input.next();
  boolean[][] bad = new boolean[27][27];
  int n = s.length(), m = input.nextInt();
  for(int i = 0; i<m; i++)
  {
    String pair = input.next();
    int c1 = pair.charAt(0)-'a', c2 = pair.charAt(1)-'a';
    bad[c1][c2] = bad[c2][c1] = true;
  }
  int[][] dp = new int[n][27];
  for(int[] A: dp) Arrays.fill(A, 987654321);
  dp[0][26] = 1;
  dp[0][s.charAt(0)-'a'] = 0;
  for(int i = 1; i<n; i++)
  {
    for(int j = 0; j<27; j++) dp[i][j] = 1+dp[i-1][j];
    for(int j = 0; j<27; j++)
    {
      if(!bad[j][s.charAt(i)-'a'])
      {
        //out.println(i+" "+j);
        dp[i][s.charAt(i)-'a'] = Math.min(dp[i][s.charAt(i)-'a'], dp[i-1][j]);
      }
    }
  }
  //for(int i = 0; i<3; i++) out.println(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]+" "+dp[i][26]);
  int min = 1000000000;
  for(int i = 0; i<27; i++)
    min = Math.min(min, dp[n-1][i]);
  out.println(min);

  out.close();
}
static long pow(long a, long p)
{
  if(p==0) return 1;
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