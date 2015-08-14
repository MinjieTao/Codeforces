import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  int n = input.nextInt(), d = input.nextInt();
  long[] data = new long[n+1];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  data[n] = 2000000001;
  long res = 0;
  for(int i = 0; i<n; i++)
  {
    long at = data[i];
    int lo = i, hi = n;
    while(hi>lo+1)
    {
      int mid = (hi+lo)/2;
      if(data[mid] - at <= d)
        lo = mid;
      else hi = mid;
    }
    long count = lo - i;
    res += count*(count-1)/2;
  }
  out.println(res);


  out.close();

}
//static long gcd(long a, long b)
//{
//  if(b==0) return a;
//  return gcd(b,a%b);
//}
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