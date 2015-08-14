import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String s = input.next()+input.next()+input.next()+input.next();
    int[] off = {0,1,4,5};
    boolean good = false;
    for(int i= 0; i<3; i++) for(int j = 0; j<3; j++)
    {
        int count = 0;
        for(int k = 0; k<off.length; k++) if(s.charAt(4*i+j+off[k]) == '.') count++;
        good |= count !=2;
    }
    out.println(good?"YES":"NO");
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