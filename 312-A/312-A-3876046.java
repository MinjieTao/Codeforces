import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int T = input.nextInt();
  for(int t = 0; t<T; t++)
  {
  String s = input.nextLine();
  int res = 0, n = s.length();
  if(n>=5 && s.substring(n-5,n).equals("lala.")) res |= 1;
  if(n>=5 && s.substring(0,5).equals("miao.")) res |= 2;
  if(res ==0) res = 3;
  String[] st = {"Freda's", "Rainbow's", "OMG>.< I don't know!"};
  out.println(st[res-1]);
  }
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