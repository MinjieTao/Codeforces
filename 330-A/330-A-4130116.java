import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  int n = input.nextInt(), m = input.nextInt();
  char[][] grid = new char[n][m];
  boolean[] rows = new boolean[n], cols = new boolean[m];
  for(int i = 0; i<n; i++)
  {
      String s = input.next();
      for(int j =0; j<m; j++)
      {
          grid[i][j] = s.charAt(j);
          if(grid[i][j] != 'S') continue;
          rows[i] = true;
          cols[j] = true;
      }
  }
  int res = n*m;
  for(int i = 0; i<n; i++)
      for(int j = 0; j<m; j++)
          if(rows[i] && cols[j])
              res --;
  out.println(res);
  out.close();
}
public static long[] gcd(long p, long q)
{
    if(q==0)
        return new long[] {p, 1, 0};
    long[] vals = gcd(q, p%q);
    return new long[] {vals[0], vals[2], vals[1] - (p/q)*vals[2]};
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