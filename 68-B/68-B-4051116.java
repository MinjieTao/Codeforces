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
  int n = input.nextInt(), k = input.nextInt();
  double[] data = new double[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  Arrays.sort(data);
  double lo = 0, hi = 1001;
  double coeff = 1.-k/100.;
  while((hi-lo) > 1e-9)
  {
    double mid = .5*(lo+hi);
    boolean possible = true;
    double[] en = new double[n];
    double extra = 0;
    for(int i = 0; i<n; i++) en[i] = data[i];
    for(int i = n-1; i>=0; i--)
    {
      possible &= en[i]+coeff*extra >= mid-1e-9;
      if(i==0) break;
      if(en[i] < mid)
      {
        extra -= (mid-en[i])/coeff;
      }
      else if(en[i]>mid)
      {
        extra += en[i]-mid;
      }
    }
    if(possible) lo = mid;
    else hi = mid;
  }
  out.println(lo);

  out.close();
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