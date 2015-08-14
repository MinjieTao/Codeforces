import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int n = input.nextInt(), a = input.nextInt(), b = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  if(a == b)
  {
    for(int i = 0; i<n/2; i++) out.print("1 ");
    for(int i = 0; i<n/2; i++) out.print("2 ");
  }
  else
  {
    int[] freq = new int[5];
    for(int i = 0; i<n; i++) freq[data[i]-1]++;
    int[] needed = new int[5];
    int start = a > b ? 0 : 4, change = a > b ? 1 : -1, found = 0;
    while(found < a)
    {
      found += needed[start] = Math.min(a-found, freq[start]);
      start += change;
    }
    for(int i = 0; i<n; i++)
    {
      if(needed[data[i]-1] > 0)
      {
        out.print("1 ");
        needed[data[i]-1]--;
      }
      else
        out.print("2 ");
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
  static long nextLong() throws IOException {
    return Long.parseLong( next() );
}

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}