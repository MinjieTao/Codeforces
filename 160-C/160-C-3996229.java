import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt();
  long k = input.nextLong();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  Random ra = new Random();
  for(int i = 0; i<2*n; i++)
  {
      int a = ra.nextInt(n), b = ra.nextInt(n);
      int temp = data[a];
      data[a] = data[b];
      data[b] = temp;
  }
  Arrays.sort(data);
  int[] left = new int[n], right = new int[n];
  left[0] = 0;
  for(int i = 1; i<n; i++)
  {
      if(data[i] == data[i-1]) left[i] = left[i-1];
      else left[i] = i;
  }
  right[n-1] = n-1;
  for(int i = n-2; i>=0; i--)
  {
      if(data[i] == data[i+1]) right[i] = right[i+1];
      else right[i] = i;
  }
  long first = (k-1)/n;
  long l = left[(int)first], r = right[(int)first], count = (r-l+1);
  long used = l*n;
  long second = (k-1-used)/count;
  out.println(data[(int)first]+" "+data[(int)second]);
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
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}