import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int t = input.nextInt();
  String s = input.next();
  int first = -1, last = -1;
  for(int i = 0; i<t; i++) if(s.charAt(i) == 'R')
  {
    first = i;
    break;
  }
  for(int i = 0; i<t; i++) if(s.charAt(i) == 'R')
  {
    last = i;
  }
  if(first == -1)
  {
    first = -1; last = -1;
    for(int i = 0; i<t; i++) if(s.charAt(i) == 'L')
    {
      first = i;
      break;
    }
    for(int i = 0; i<t; i++) if(s.charAt(i) == 'L')
    {
      last = i;
    }
    if(first == -1) out.println(1+" "+1);
    else out.println((last+1)+" "+(first));
  }
  else out.println((first+1)+" "+(last+2));
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