import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), res = 0;
  for(int a = 1; a<=n; a++)
    for(int b = a; b<=n; b++)
    {
      int sq = a*a+b*b;
      if(sq <= n*n && Math.sqrt(sq) == (int)Math.sqrt(sq)) res++;
    }
  out.println(res);
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