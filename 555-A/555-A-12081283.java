import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  int n = input.nextInt(), k = input.nextInt();
  int chain = 0;
  for(int i = 0; i<k; i++)
  {
    int m = input.nextInt();
    boolean good = false;
    for(int j = 0; j<m; j++)
    {
      int x = input.nextInt();
      if(x == 1 && j == 0) good = true;
      if(good && x == j + 1) chain++;
      else good = false;
    }
    good = false;
  }
  if(chain == 0) chain = 1;
  System.out.println(2*n - 2 - (k-1) - 2*(chain-1));
}
public static class input {
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  static void init(InputStream input) {
      reader = new BufferedReader(
                   new InputStreamReader(input) );
      tokenizer = new StringTokenizer("");
  }
  static String next() throws IOException {
      while ( ! tokenizer.hasMoreTokens() ) {
          tokenizer = new StringTokenizer(
                 reader.readLine() );
      }
      return tokenizer.nextToken();
  }
  static int nextInt() throws IOException {
      return Integer.parseInt( next() );
  }
}
}