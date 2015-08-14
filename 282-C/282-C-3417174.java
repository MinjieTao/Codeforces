import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String a = input.next(), b = input.next();
    int c1 = 0, c2 = 0;
    for(int i =0; i<a.length(); i++) if(a.charAt(i)=='1') c1++;
    for(int i =0 ; i<b.length();i++) if(b.charAt(i)=='1') c2++;
    if(a.length()==b.length() && (c1>0 && c2>0) || a.equals(b)) out.println("YES");
    else out.println("NO");
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