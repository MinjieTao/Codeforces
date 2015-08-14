import java.util.*;
import java.io.*;
public class cf {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<2*n; i++) if(i%2==0)data[i/2] = input.nextInt(); else input.nextInt();
    char[] res =new char[n];
    int diff = 0;
    for(int i = 0; i<n; i++)
    {
        if(diff - (1000-data[i]) >= -500)
        {
            diff -= (1000-data[i]);
            res[i] = 'G';
        }
        else
        {
            diff += data[i];
            res[i] = 'A';
        }
        //out.println(diff);
    }
    if(Math.abs(diff) > 500) out.println(-1);
    else out.println(new String(res));
        
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