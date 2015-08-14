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
  int[] ans = new int[]{
      1,
      0,
      18,
      0,
      1800,
      0,
      670320,
      0,
      734832000,
      0,
      890786230,
      0,
      695720788,
      0,
      150347555,
      0
  };
  int n = input.nextInt();
  out.println(ans[n-1]);
//  long[] data = new long[17];
//  for(int i = 1; i<=n; i++)
//  {
//    count = 0;
//    perm(new boolean[i], new boolean[i], i, 0);
//    for(int j = 1; j<=i; j++)
//      count = (count*j)%mod;
//    System.out.println(count);
//  }
  //out.println(data[n]);

  out.close();
}
static long count;
static void perm(boolean[] data, boolean[] used, int n, int at)
{
  if(at==n) count++;
  for(int i = 0; i<n; i++)
  {
    int res = (i+at)%n;
    if(!used[i] && !data[res])
    {
      data[res] = true;
      used[i] = true;
      perm(data, used, n, at+1);
      data[res] = false;
      used[i] = false;
    }
  }
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