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
  int n = input.nextInt();
  int[][] data = new int[n][n];
  for(int i = 0; i<n; i++)
    for(int j = 0; j<n; j++)
      data[i][j] = input.nextInt();
  int[] list = new int[n];
  for(int i = 0; i<n; i++) list[i] = input.nextInt();
  for(int i = 0; i<n; i++)
  {
    boolean found = false;
    for(int j = 0; j<n; j++)
    {
      if(data[i][j] == i+1) continue;
      boolean good = true;
      for(int k = 0; k<n; k++)
      {
        if(list[k] == data[i][j]) break;
        if(list[k] < data[i][j] && list[k] != i+1) {good = false; break;}
      }
      if(good)
      {
        found = true;
        out.print(data[i][j]+" ");
        break;
      }
    }
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