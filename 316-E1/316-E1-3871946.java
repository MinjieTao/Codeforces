import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), m = input.nextInt();
  long[] data = new long[n];
  long[] fib = new long[n+10];
  fib[0] = fib[1] = 1;
  for(int i = 2; i<n; i++) fib[i] = (fib[i-1]+fib[i-2])%mod;
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  for(int i = 0; i<m; i++)
  {
    int t = input.nextInt();
    if(t==1)
    {
      int x = input.nextInt()-1, v = input.nextInt();
      data[x] = v;
    }
    else
    {
      int a = input.nextInt()-1, b = input.nextInt()-1;
      long res = 0;
      for(int j = 0; j<=b-a; j++)
      {
        res += fib[j] * data[a+j];
        res %= mod;
      }
      out.println(res);
    }
  }
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