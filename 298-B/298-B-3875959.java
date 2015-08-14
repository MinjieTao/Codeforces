import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int t = input.nextInt(), sx = input.nextInt(), sy = input.nextInt(), ex = input.nextInt(), ey = input.nextInt();
  String s = input.next();
  boolean done = false;
  for(int i = 0; i<t; i++)
  {
    char c = s.charAt(i);
    if(c=='N' && ey > sy) sy++;
    else if(c=='S' && ey<sy) sy--;
    else if(c=='W' && ex<sx) sx--;
    else if(c=='E' && ex>sx) sx++;
    if(sx == ex && sy == ey)
    {
      out.println((i+1));
      done = true;
      break;
    }
  }
  if(!done) out.println(-1);
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