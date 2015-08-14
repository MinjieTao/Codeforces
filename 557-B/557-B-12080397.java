import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  int n = input.nextInt(), w = input.nextInt();
  int[] data = new int[2*n];
  for(int i = 0; i<n*2; i++) data[i] = input.nextInt();
  Arrays.sort(data);
  double res = w * 1.0 / n / 3;
  res = Math.min(res, data[0]);
  res = Math.min(res, data[n]/2.0);
  System.out.println(3*n*res);
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