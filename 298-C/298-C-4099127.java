import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  String s1 = input.next(), s2 = input.next();
  int a = 0, b = 0;
  for(int i = 0; i<s1.length(); i++) if(s1.charAt(i)=='1') a++;
  for(int i = 0; i<s2.length(); i++) if(s2.charAt(i)=='1') b++;
  boolean possible = true;
  if(b-a>1 || b>a && b%2 == 1) possible = false;

  out.println(possible?"YES":"NO");



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