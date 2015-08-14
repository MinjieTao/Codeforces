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
  String s = input.next();
  int n = s.length();
  int[][] memo = new int[n][2];
  if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z')
  {
    memo[0][0] = 1;
  }
  for(int i = 1; i<n; i++)
  {
    boolean lo = s.charAt(i) >= 'a' && s.charAt(i) <= 'z';
    memo[i][0] = memo[i-1][0] + (lo ? 1 : 0);
    memo[i][1] = Math.min(memo[i-1][0], memo[i-1][1] + (lo?0:1));
  }
  out.println(Math.min(memo[n-1][0], memo[n-1][1]));


  out.close();
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