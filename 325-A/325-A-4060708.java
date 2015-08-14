import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
//  boolean[] primes = new boolean[10000001];
//  for(int i = 0; i<primes.length; i++) primes[i] = true;
//  primes[0] = false;
//  primes[1] = false;
//  for(int i = 2; i<=Math.sqrt(primes.length); i++)
//  {
//      if(primes[i])
//      {
//          for(int j = i*i; j < primes.length; j+=i)
//              primes[j] = false;
//      }
//  }
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt();
  long area = 0;
  int minx = 999999, maxx = 0, miny = 999999, maxy = 0;
  for(int i = 0; i<n; i++)
  {
      int x1 = input.nextInt(), y1 = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
      area += Math.abs((long)(y2-y1)*(x2-x1));
      minx = Math.min(minx, Math.min(x1,x2));
      miny = Math.min(miny, Math.min(y1,y2));
      maxx = Math.max(maxx, Math.max(x1,x2));
      maxy = Math.max(maxy, Math.max(y1,y2));
  }
  boolean b = ((maxx-minx) == (maxy-miny)) && area == (long)(maxx-minx)*(maxy-miny);
  out.println(b?"YES":"NO");
 

  out.close();
}
static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
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