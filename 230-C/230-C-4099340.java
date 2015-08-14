import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));

  int n = input.nextInt(), m = input.nextInt();
  boolean[][] ones = new boolean[n][m];
  boolean okay = true;
  for(int i = 0; i<n; i++)
  {
    String s = input.next();
    okay &= s.indexOf('1') > -1;
    for(int j = 0; j<m; j++) ones[i][j] = s.charAt(j) == '1';
  }
  if(!okay) out.println(-1);
  else
  {
    int[] tot = new int[m];
    for(int i = 0; i<n; i++)
    {
      int[] left = new int[m], right = new int[m];
      left[0] = ones[i][0] ? 0 : 100000;
      for(int j = 1; j<m; j++)
        if(ones[i][j]) left[j] = 0;
        else left[j] = left[j-1] == 100000 ? 100000 : 1+left[j-1];
      for(int j = 0; j<m; j++) left[j] = Math.min(left[j], j+1+left[m-1]);
      right[m-1] = ones[i][m-1] ? 0 : 100000;
      for(int j = m-2; j>=0; j--)
        if(ones[i][j]) right[j] = 0;
        else right[j] = right[j+1] == 100000 ? 100000 : 1+right[j+1];
      for(int j = m-1; j>=0; j--) right[j] = Math.min(right[j], m-j+right[0]);
      for(int j = 0; j<m; j++)
      {
        if(left[j] == -1) tot[j] += right[j];
        else if(right[j] == -1) tot[j] += left[j];
        else tot[j] += Math.min(left[j], right[j]);
      }
    }
    //for(int t: tot) out.println(t);
    int min = tot[0];
    for(int i = 1; i<m; i++) min = Math.min(min, tot[i]);
    out.println(min);
  }

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