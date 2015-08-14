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

  int x = input.nextInt();
  String text = input.nextLine();
  int n = text.length();
  ArrayList<Integer> punc = new ArrayList<Integer>();
  for(int i = 0; i<n; i++)
  {
    char c = text.charAt(i);
    if(c=='.' || c == '?' || c ==  '!') punc.add(i);
  }
  boolean possible = punc.get(0)+1 <= x;
  for(int i = 0; i<punc.size()-1; i++) if(punc.get(i+1)-punc.get(i) > x+1) possible = false;
  if(!possible) out.println("Impossible");
  else
  {
    int i = 0, count = 0, pc = 0, left = x;
    while(i<n)
    {
      int len = punc.get(pc)-i+1;
      if(len <= left)
      {
        left -= len;
        i = punc.get(pc)+1;
        pc++;
      }
      else
      {
        count++;
        left = x;
        i++;
      }
    }
    if(left != x) count++;
    out.println(count);
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