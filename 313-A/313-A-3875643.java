import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  int res = n;
  res = Math.max(res, n/10);
  if(Math.abs(n) > 9) res = Math.max(res, (n - 10*((n/10)%10))/10+n%10);
  System.out.println(res);
  out.close();
}
static int N;
static int[] ss;
static int[][] memo;
static int possible(int sum, int at)
{
  if(sum < 0) return 0;
  if(at==N && sum > 0) return 0;
  if(sum == 0) return 1;
  if(memo[sum][at] != -1) return memo[sum][at];
  return memo[sum][at] = possible(sum, at+1) | possible(sum-ss[at], at+1);
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
}
}