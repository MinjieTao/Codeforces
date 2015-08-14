import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  String s = input.next();
  int n = s.length();
  int best = -1;
  for(int i = 1; i<n; i++)
      for(int j = i+1; j<n; j++)
      {
          String s1 = s.substring(0,i), s2 = s.substring(i, j), s3 = s.substring(j);
          //out.println(s1+" "+s2+" "+s3);
          if(s1.length()>1 && s1.charAt(0) == '0' || s2.length()>1 && s2.charAt(0) == '0' || s3.length()>1 && s3.charAt(0) == '0')
              continue;
          if(s1.length()>7 || s2.length()>7 || s3.length()>7) continue;
          int a = Integer.parseInt(s1), b = Integer.parseInt(s2), c = Integer.parseInt(s3);
          if(a>1000000 || b > 1000000 || c>1000000) continue;
          best = Math.max(best, a+b+c);
      }
  out.println(best);
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