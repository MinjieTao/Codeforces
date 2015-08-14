import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));

  int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
  int[] as = new int[n], bs = new int[m];
  for(int i = 0; i<n; i++) as[i] = input.nextInt();
  for(int i = 0; i<m; i++) bs[i] = input.nextInt();
  if(n>m) out.println("YES");
  else
  {
    Arrays.sort(as);
    Arrays.sort(bs);
    boolean can = false;
    for(int i = 0; i<as.length; i++) can |= as[i] > bs[i+m-n];
    out.println(can?"YES":"NO");
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