import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int n = input.nextInt(), t = input.nextInt();
  int[] as = new int[n], bs = new int[n];
  for(int i = 0; i<n; i++) as[i] = input.nextInt();
  for(int i = 0; i<n; i++) bs[i] = input.nextInt();
  double min = 1.*bs[0]/as[0];
  for(int i = 1; i<n; i++) min = Math.min(min, 1.*bs[i]/as[i]);
  double res = 0;
  for(int i = 0; i<n; i++) res += as[i]*min;
  out.println(Math.min(res, t));

  out.close();

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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}