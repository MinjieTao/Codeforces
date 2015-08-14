import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int a = input.nextInt(), b = input.nextInt(), n = input.nextInt();
  boolean found = false;
  for(int i = -1000; i<=1000; i++)
  {
    int pow = 1;
    boolean small = true;
    for(int j = 0; j<n; j++)
    {
      pow *= i;
      if(Math.abs(pow) > Math.abs(b)) small = false;
    }
    if(!small) continue;
    if(a*pow == b)
    {
      out.println(i);
      found = true;
      break;
    }
  }
  if(!found) out.println("No solution");

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