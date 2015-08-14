import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int n = input.nextInt();
  Cup[] data = new Cup[n];
  for(int i = 0; i<n; i++)
    data[i] = new Cup(input.nextInt(), i+1);
  Arrays.sort(data);
  if(data[0].x == data[n-1].x) out.println("Exemplary pages.");
  else if((data.length == 2 || (data[1].x == data[n-2].x && data[1].x-data[0].x == data[n-1].x-data[1].x)) && data[n-1].x%2==data[0].x%2)
    out.printf("%d ml. from cup #%d to cup #%d.\n", (data[n-1].x-data[0].x)/2, data[0].i, data[n-1].i);
  else out.println("Unrecoverable configuration.");



  out.close();

}
static class Cup implements Comparable<Cup>
{
  int x, i;
  public Cup(int xx, int ii)
  {
    x = xx; i = ii;
  }
  @Override
  public int compareTo(Cup o) {
    // TODO(mkirsche): Auto-generated method stub
    return this.x - o.x;
  }
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