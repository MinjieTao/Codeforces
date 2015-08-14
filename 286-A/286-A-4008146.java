import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  int n = input.nextInt();
  int[] res = new int[n+1];
  if(n%4 == 2 || n%4 == 3)
  {
    out.println(-1);
  }
  else if(n%4 == 1)
  {
    res[(n+1)/2] = (n+1)/2;
    int at = (n+1)/2;
    for(int i = 0; i<n/4; i++)
    {
      res[at+1+2*i] = res[at]-2-2*i;
      res[at+2+2*i] = res[at]+1+2*i;
      res[at-1-2*i] = res[at]+2+2*i;
      res[at-2-2*i] = res[at]-1-2*i;
    }
    for(int i = 1; i<=n; i++) out.print(res[i]+" ");
  }
  else if(n%4 == 0)
  {
    int at = n/2;
    res[at] = n/2+2;
    for(int i = 0; i<n/4; i++)
    {
      res[at+1+2*i] = res[at]-3-2*i;
      res[at-2*i] = res[at]+2*i;
      res[at-1-2*i] = res[at]-2-2*i;
      res[at+2+2*i] = res[at]-1+2*i;
    }
    for(int i = 1; i<=n; i++) out.print(res[i]+" ");
  }


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