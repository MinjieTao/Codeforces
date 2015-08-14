import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  boolean[] primes = new boolean[1000];
  Arrays.fill(primes, true);
  primes[0]=primes[1]=false;
  ArrayList<Integer> pr = new ArrayList<Integer>();
  for(int i = 2; i<1000; i++)
  {
    if(primes[i])
    {
      pr.add(i);
      for(int j = i*i; j<1000; j+=i) primes[j] = false;
    }
  }
  int n = input.nextInt();
  if(n==2) out.println(-1);
  else
  {
    BigInteger bi = new BigInteger("1");
    for(int i = 0; i<n; i++) bi = bi.multiply(new BigInteger(""+pr.get(i)));
    for(int i = 0; i<n; i++) out.println(bi.divide(new BigInteger(""+pr.get(i))));
  }

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