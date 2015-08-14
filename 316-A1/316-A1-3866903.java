import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  String s = input.next();
  long res = 1;
  boolean[] found = new boolean[10];
  int qs = 0;
  for(int i = 0; i<s.length(); i++)
  {
    char c = s.charAt(i);
    if(c=='?') qs++;
    else if(c >= 'A' && c<= 'J') found[c-'A'] = true;
  }
  int count = 0;
  for(int i = 0; i<10; i++) if(found[i]) count++;
  for(int i = 0; i<count; i++)
  {
    res *= (i==0 && s.charAt(0) >= 'A' && s.charAt(0) <= 'J') ? 9 : (10-i);
  }
  if(s.charAt(0) == '?')
  {
    res *= 9;
    qs--;
  }
  PrintWriter out = new PrintWriter(System.out);
  out.print(res);
  for(int i = 0; i<qs; i++) out.print('0');
  out.println();
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
}
}