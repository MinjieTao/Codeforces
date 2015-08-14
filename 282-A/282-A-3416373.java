import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int x  =0;
    for(int i = 0, n = input.nextInt(); i<n; i++) x += input.next().indexOf('+') >= 0 ? 1 : -1;
    out.println(x);
    
    out.close();
}
public static class input {
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
}
}