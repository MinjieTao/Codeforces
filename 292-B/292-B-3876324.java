import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), m = input.nextInt();
  int[] deg = new int[n];
  for(int i = 0; i<m; i++)
  {
    deg[input.nextInt()-1]++;
    deg[input.nextInt()-1]++;
  }
  Arrays.sort(deg);
  if(deg[0] == 2 && deg[n-1] == 2) out.println("ring topology");
  else if(deg[1] == 1 && deg[n-1] == 2) out.println("bus topology");
  else if(deg[n-2] == 1 && deg[n-1] == n-1) out.println("star topology");
  else out.println("unknown topology");
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