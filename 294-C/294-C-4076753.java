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
  int n = input.nextInt(), m = input.nextInt();
  int[] data = new int[m];
  for(int i = 0; i<m; i++) data[i] = input.nextInt();
  Arrays.sort(data);
  long[][] comb = comb(n);
  long res = 1;
  int sum = 0;
  ArrayList<Integer> list = new ArrayList<Integer>();
  if(data[0] > 1) list.add(data[0]-1);
  if(data[m-1] < n) list.add(n-data[m-1]);
  for(int i = 0; i<m-1; i++)
  {
    int size = data[i+1] - data[i] - 1;
    if(size > 0)
    {
      res = (res*pow(2, size-1))%mod;
      list.add(size);
    }
  }
  for(int x: list) sum += x;
  for(int i = 0; i<list.size(); i++)
  {
    res = (res * comb[sum][list.get(i)])%mod;
    sum -= list.get(i);
  }
  out.println(res);

  out.close();
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