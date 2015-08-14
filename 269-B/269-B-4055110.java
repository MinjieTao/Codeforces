import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static int n, m;
  static int[] data;
  static int[][] memo;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  n = input.nextInt();
  m = input.nextInt();
  data = new int[n];
  for(int i = 0; i<n; i++)
  {
    data[i] = input.nextInt();
    input.nextDouble();
  }
  memo = new int[n+1][m+1];
  for(int[] A: memo) Arrays.fill(A,-1);
  out.println(go(0,0));

  out.close();
}
static int go(int at, int max)
{
  if(at==n) return 0;
  if(memo[at][max] != -1) return memo[at][max];
  if(data[at] < max) return memo[at][max]= 1 + go(at+1, max);
  else return memo[at][max]= Math.min(go(at+1, data[at]), 1+go(at+1, max));
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