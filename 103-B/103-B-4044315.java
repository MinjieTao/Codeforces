import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));

  int n = input.nextInt(), m = input.nextInt();
  boolean[][] adj = new boolean[n][n];
  for(int i = 0; i<m; i++)
  {
    int a = input.nextInt()-1, b = input.nextInt()-1;
    adj[a][b] = adj[b][a] = true;
  }
  for(int k = 0; k<n; k++)
    for(int i = 0; i<n; i++)
      for(int j = 0; j<n; j++)
        adj[i][j] |= (adj[i][k] && adj[k][j]);
  boolean good = n==m;
  for(int i = 0; i<n; i++) good &= adj[0][i];
  out.println(good?"FHTAGN!":"NO");

  out.close();
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