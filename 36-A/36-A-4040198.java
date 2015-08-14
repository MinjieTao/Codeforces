import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  //input.init(System.in);
  Scanner input = new Scanner(new File("input.txt"));
  PrintWriter out = new PrintWriter(new File("output.txt"));

  int n = input.nextInt();
  String s = input.next();
  ArrayList<Integer> d = new ArrayList<Integer>();
  int last = -1;
  for(int i = 0; i<n; i++)
  {
    if(s.charAt(i) == '1')
    {
      if(last >-1)
      {
        d.add(i-last);
      }
      last = i;
    }
  }
  Collections.sort(d);
  out.println(d.get(0) == d.get(d.size()-1) ? "YES":"NO");

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