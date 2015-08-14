import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
  int n = input.nextInt(), m = input.nextInt();
  int[] xs = new int[3], ys = new int[3];
  int at = 0;
  for(int i = 0; i<n; i++)
  {
    String s = input.next();
    for(int j = 0; j<m; j++)
      if(s.charAt(j) == '*')
      {
        ys[at] = i;
        xs[at] = j;
        at++;
      }
  }
  boolean found = false;
  for(int i = 0; i<3; i++)
    for(int j= 0; j<3; j++)
    {
      if(found) break;
      if(i==j) continue;
      int dx = xs[j]-xs[i], dy = ys[j]-ys[i];
      int third = 0;
      for(int k = 0; k<3; k++)
        if(k!=i && k!=j) third = k;
      int nx = xs[third] + dx, ny = ys[third]+dy;
      if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
      if(xs[third] - xs[i] == nx - xs[j] && ys[third] - ys[i] == ny - ys[j] && ((nx==xs[j]&&(ny==ys[i]||ny==ys[third])||ny==ys[j]&&(nx==xs[i]||nx==xs[third]))))
      {
        out.println((ny+1)+" "+(nx+1));
        found = true;
        break;
      }
      else if(xs[third] - xs[j] == nx - xs[i] && ys[third] - ys[j] == ny - ys[i] && ((nx==xs[i]&&(ny==ys[j]||ny==ys[third])||ny==ys[i]&&(nx==xs[j]||nx==xs[third]))))
      {
        out.println((ny+1)+" "+(nx+1));
        found = true;
        break;
      }
    }
  //if(!found) out.println(-1);


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