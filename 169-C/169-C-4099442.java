import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  String s = input.next(), t = input.next();
  int n = s.length(), m = t.length();
  int[][] dp = new int[n][m+1];
  for(int i = 1; i<m+1; i++) dp[0][i] = dp[0][i-1] + (s.charAt(0) == t.charAt(i-1) ? 1 : 0);
  for(int i = 1; i<n; i++)
      for(int j = 1; j<=m; j++)
      {
          char c1 = s.charAt(i), c2 = t.charAt(j-1);
          //out.println(i+" "+j+" "+c1+" "+c2);
          dp[i][j] = dp[i][j-1] + (c1==c2 ? 1+dp[i-1][j-1] : 0);
          dp[i][j] %= mod;
      }
  long res = 0;
//  for(int i = 0; i<n; i++)
//  {
//    for(int j = 0; j<=m; j++)
//        out.print(dp[i][j]+" ");
//    out.println();
//  }
  for(int i = 0; i<n; i++)
  {
      res = (res+dp[i][m])%mod;
  }
  out.println(res);
  

  out.close();
}
static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
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
  
  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}