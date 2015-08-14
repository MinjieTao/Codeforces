import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  long n = input.nextInt();
  //out.println(n<3?n:( n%2==0?(n==4?12:(n-3)*(n-1)*(n) ):n*(n-1)*(n-2)));
  if(n<3) out.println(n);
  else if(n==4) out.println(12);
  else if(n==6) out.println(60);
  else if(n%2 != 0) out.println(n*(n-1)*(n-2));
  else if(n%3 != 0) out.println(n*(n-1)*(n-3));
  else out.println((n-1)*(n-2)*(n-3));




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