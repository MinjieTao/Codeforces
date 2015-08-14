import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), m = input.nextInt();
  int[] data = new int[n+1], qs = new int[m];
  for(int i = 0; i<n; i++) data[i+1] = data[i]+input.nextInt()*input.nextInt();
  for(int i = 0; i<m; i++) qs[i] = input.nextInt();
  int i = 0, j = 0;
  while(j<m)
  {
    if(qs[j] > data[i])
    {
      i++;
    }
    else
    {
      j++;
      out.println((i));
    }
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