import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  int a = input.nextInt(), b = input.nextInt(), c = input.nextInt(), d = input.nextInt();
  long nu = 0, de = 0;
  if(d*a>b*c)
  {
      nu = c;
      de = a;
  }
  else
  {
      nu = d;
      de = b;
  }
  long num = (long)a*nu*b*nu;
  long denom = (long)de*de*c*d;
  long gcd = gcd(num, denom);
  num /= gcd;
  denom /= gcd;
  System.out.println(denom-num +"/"+denom);
  
  out.close();
}
static long gcd(long a, long b)
{
    if(b==0) return a;
    return gcd(b, a%b);
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