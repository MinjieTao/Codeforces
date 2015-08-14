import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  long p = input.nextLong(), q = input.nextLong();
  int n = input.nextInt();
  long[] data = new long[n];
  for(int i = 0; i<n; i++)
  {
    data[i] = input.nextLong();
  }
  boolean okay = true;
  long num = data[n-1], denom = 1;
  for(int i = 0; i<n-1; i++)
  {
    long temp = num;
    num = denom;
    denom = temp;
    if(1e19/denom < data[n-2-i]) okay = false;
    num += denom*data[n-2-i];
  }
  //out.println(num+" "+denom);
  if(num<0 || denom<0 || !okay) out.println("NO");
  else
  {
    long g1 = gcd(p, q);
    p/=g1;
    q/=g1;
    long g2 = gcd(num, denom);
    num /= g2;
    denom /= g2;
    out.println(num == p && denom == q ? "YES":"NO");
  }

  out.close();

}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b,a%b);
}
//static long choose(int n, int k)
//{
//  long num = 1, denom = 1;
//  for(int i = 0; i<k; i++)
//  {
//    num = (num*(n-i))%mod;
//    denom = (denom*(k-i))%mod;
//  }
//  return (num * modinv(denom, mod))%mod;
//}
//static long[] gcd(long p, long q) {
//  if (q == 0)
//     return new long[] { p, 1, 0 };
//  long[] vals = gcd(q, p % q);
//  long d = vals[0];
//  long a = vals[2];
//  long b = vals[1] - (p / q) * vals[2];
//  return new long[] { d, a, b };
//}
//
//static long modinv(long k, long n) {
//  long[] vals = gcd(k, n);
//  long d = vals[0];
//  long a = vals[1];
//  long b = vals[2];
//  if (a > 0) return a;
//  return n + a;
//}
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