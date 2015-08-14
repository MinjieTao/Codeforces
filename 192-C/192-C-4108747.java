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
  int[][] g = new int[26][26];
  int n = input.nextInt();
  for(int i = 0; i<n; i++)
  {
      String s = input.next();
      int start = s.charAt(0)-'a', end = s.charAt(s.length()-1)-'a';
      for(int j = 0; j<26; j++)
      {
          if(g[j][start] > 0 || j == start) g[j][end] = Math.max(g[j][end], g[j][start]+s.length());
      }
  }
  int max = 0;
  for(int i = 0; i<26; i++) max = Math.max(max, g[i][i]);
  out.println(max);
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