import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000000l;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  int[] count = new int[1001], can = new int[1001];
  boolean[] same = new boolean[1001];
  for(int i = 0; i<n; i++)
  {
    int a, b;
    count[a=input.nextInt()]++;
    can[b=input.nextInt()]++;
    if(a==b) same[a] = true;
  }
  int res = 0;
  for(int i = 0; i<1001; i++)
  {
    if(can[i] == 0) res += count[i];
    else if(can[i] == 1 && same[i]) res++;
  }
  out.println(res);
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