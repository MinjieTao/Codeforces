import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000009;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  int[] xs = new int[8], ys = new int[8];
  for(int i = 0; i<8; i++)
  {
      xs[i] = input.nextInt(); ys[i] = input.nextInt();
  }
  TreeSet<Integer> x = new TreeSet<Integer>();
  TreeSet<Integer> y = new TreeSet<Integer>();
  for(int i: xs) x.add(i);
  for(int i: ys) y.add(i);
  boolean good = true;
  if(x.size() != 3 || y.size() != 3) good = false;
  else
  {
      ArrayList<Integer> xlist = new ArrayList<Integer>();
      ArrayList<Integer> ylist = new ArrayList<Integer>();
      for(int i: x) xlist.add(i);
      for(int i: y) ylist.add(i);
      for(int i = 0; i<3; i++)
          for(int j = 0; j<3; j++)
          {
              if(i==1 && j == 1) continue;
              boolean found = false;
              for(int k = 0; k<8; k++)
              {
                  if(xs[k] == xlist.get(i) && ys[k] == ylist.get(j)) found = true;
              }
              good &= found;
          }
  }
  out.println(good ? "respectable" : "ugly");
  out.close();
}
static long pow(long x, long p)
{
    if(p==0) return 1;
    if((p&1) > 0)
    {
        return (x*pow(x, p-1))%mod;
    }
    long sqrt = pow(x, p/2);
    return (sqrt*sqrt)%mod;
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