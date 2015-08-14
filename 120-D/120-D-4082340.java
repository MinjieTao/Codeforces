import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  //input.init(System.in);
  //PrintWriter out = new PrintWriter(new PrintStream(System.out));
  input.init(new FileInputStream(new File("input.txt")));
  PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), m = input.nextInt();
  int[][] data = new int[n][m];
  int[] rows = new int[n], cols = new int[m];
  int total = 0;
  for(int i = 0; i<n; i++)
    for(int j = 0; j<m; j++)
    {
      data[i][j] = input.nextInt();
      total += data[i][j];
      rows[i] += data[i][j];
      cols[j] += data[i][j];
    }
  int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
  int[][] perms = new int[][]{{a,b,c},{a,c,b},{b,a,c},{b,c,a},{c,a,b},{c,b,a}};
  int[][] dirs = new int[][]{rows, cols};
  int res = 0;
  for(int[] d : dirs)
  {
    HashSet<String> seen = new HashSet<String>();
    for(int[] p : perms)
    {
      int x = p[0], y = p[1], z = p[2];
      String key = x+" "+y+" "+z;
      if(seen.contains(key)) continue;
      else seen.add(key);
      int sum = 0;
      int c1 = 0, c2 = 0;
      for(int i = 0; i<d.length; i++)
      {
        if(sum == x+y) res += c1;
        if(i>0 && sum == x) c1++;
        sum += d[i];
      }
      //out.println(c1+" "+c2);
      res += c1*c2;
    }
  }
  out.println(total==a+b+c?res:0);
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