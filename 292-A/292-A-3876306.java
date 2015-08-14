import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  int[] ts = new int[n], cs = new int[n];
  for(int i = 0; i<n; i++)
  {
    ts[i] = input.nextInt(); cs[i] = input.nextInt();
  }
  int maxSize = cs[0], size = cs[0];
  for(int i = 1; i<n; i++)
  {
    size = Math.max(0, size - (ts[i]-ts[i-1])) + cs[i];
    maxSize = Math.max(size, maxSize);
  }
  int end = size + ts[n-1];
  out.println(end+" "+maxSize);
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