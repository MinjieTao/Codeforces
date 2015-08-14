import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));

  String s = input.nextLine();
  int level = 0;
  while(s.length()>0)
  {
    String first = s.substring(0, s.indexOf('>')+1);
    s = s.substring(s.indexOf('>')+1);
    if(first.charAt(1) == '/')
    {
      level--;
      for(int i = 0; i<level; i++) out.print("  ");
      out.println(first);
    }
    else
    {
      for(int i = 0; i<level; i++) out.print("  ");
      out.println(first);
      level++;
    }
  }

  out.close();
}
static class Cottage implements Comparable<Cottage>
{

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  int x, a;
  public Cottage(int xx, int aa)
  {
    x = xx; a = aa;
  }
  @Override
  public int compareTo(Cottage o) {
    // TODO(mkirsche): Auto-generated method stub
    return this.x - o.x;
  }

}
static long pow(long a, long p)
{
  if(p==0) return 1;
  if((p&1) == 0)
  {
    long sqrt = pow(a, p/2);
    return (sqrt*sqrt)%mod;
  }
  else
    return (a*pow(a,p-1))%mod;
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