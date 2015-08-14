import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static int n, m, c0, d0;
  static int[][] data;
  static int[][] memo;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  n = input.nextInt(); m = input.nextInt(); c0 = input.nextInt(); d0 = input.nextInt();
  data = new int[m][4];
  for(int i = 0; i<m; i++)
    for(int j = 0; j<4; j++)
      data[i][j] = input.nextInt();
  memo = new int[m+1][n+1];
  for(int[] A: memo) Arrays.fill(A, -1);
  out.println(go(0, n));

  out.close();
}
static int go(int at, int left)
{
  if(at==m) return (left/c0)*d0;
  if(left == 0) return 0;
  if(memo[at][left] != -1) return memo[at][left];
  int canUse = Math.min(data[at][0]/data[at][1], left/data[at][2]);
  int res = 0;
  for(int i = 0; i<=canUse; i++) res = Math.max(res, i*data[at][3] + go(at+1, left - i*data[at][2]));
  return memo[at][left] = res;
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