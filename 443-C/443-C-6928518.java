import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  int n = input.nextInt();
  String[] data = new String[n];
  int[] cs = new int[n], vs = new int[n];
  for(int i = 0; i<n; i++)
   {
    data[i] = input.next();
    char c = data[i].charAt(0);
    if(c == 'R') cs[i] = 0;
    else if(c == 'G') cs[i] = 1;
    else if(c == 'B') cs[i] = 2;
    else if(c == 'Y') cs[i] = 3;
    else cs[i] = 4;
    vs[i] = data[i].charAt(1) - '1';
   }
  int res = 8;
  for(int color = 0; color < (1<<5); color++)
    for(int num = 0; num < (1<<5); num++)
    {
      int cur = Integer.bitCount(color) + Integer.bitCount(num);
      boolean good = true;
      for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
        {
          if(data[i].equals(data[j])) continue;
          if(cs[i] != cs[j] && (((color & (1<<cs[i])) > 0 || ((color & (1<<cs[j])) > 0))))
              continue;
          if(vs[i] != vs[j] && (((num & (1<<vs[i])) > 0 || ((num & (1<<vs[j])) > 0))))
            continue;
          good  =false;
        }
      if(good) res = Math.min(res, cur);
    }
  System.out.println(res);
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