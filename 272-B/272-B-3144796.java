import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    int[] freq = new int[100];
    for(int  i=0; i<n; i++)
    {
        freq[go(data[i])]++;
        //System.out.println(go(data[i]));
    }
    long res = 0;
    for(int i = 0; i<freq.length; i++)
    {
        res += (long)freq[i]*(freq[i]-1)/2;
    }
    System.out.println(res);
}
public static int go(int n)
{
    if(n==0) return 0;
    if(n%2 == 0) return go(n/2);
    return go(n/2)+1;
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