import java.util.*;
import java.io.*;
public class j {
public static void main(String[] args) throws Exception
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i =0; i<n; i++) data[i] = input.nextInt();
    int m = input.nextInt();
    for(int i =0 ; i<m; i++)
    {
        int x = input.nextInt()-1, y = input.nextInt();
        int a = y - 1, b = data[x] - y;
        if(x>0) data[x-1] += a;
        if(x<n-1) data[x+1] += b;
        data[x] = 0;
    }
    for(int i = 0; i<n; i++) out.println(data[i]);
    out.close();
}
//Fast Scanner
//throw IOException
//input.init(System.in);
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