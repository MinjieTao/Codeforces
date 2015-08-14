import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  int a = input.nextInt(), b = input.nextInt(), n = input.nextInt();
  int curSum = n*a;
  long res = 0;
  long[] choose = new long[n+1];
  choose[0] = 1;
  for(int i = 1; i<=n; i++)
  {
    choose[i] = choose[i-1];
    choose[i] *= (n+1-i);
    choose[i] %= mod;
    choose[i] *= modinv(i, mod);
    choose[i] %= mod;
  }
  for(int i = 0; i<=n; i++)
  {
    String s = curSum+"";
    boolean good = true;
    for(int j = 0; j<s.length(); j++)
    {
      int digit = s.charAt(j) - '0';
      if(digit!=a && digit!= b)
      {
        good = false;
        break;
      }
    }
    if(good)
    {
      //out.println(i);
      res= (res+choose[i])%mod;
    }
    curSum += b-a;
  }
  out.println(res);

  out.close();

}
static long choose(int n, int k)
{
  long num = 1, denom = 1;
  for(int i = 0; i<k; i++)
  {
    num = (num*(n-i))%mod;
    denom = (denom*(k-i))%mod;
  }
  return (num * modinv(denom, mod))%mod;
}
static long[] gcd(long p, long q) {
  if (q == 0)
     return new long[] { p, 1, 0 };
  long[] vals = gcd(q, p % q);
  long d = vals[0];
  long a = vals[2];
  long b = vals[1] - (p / q) * vals[2];
  return new long[] { d, a, b };
}

static long modinv(long k, long n) {
  long[] vals = gcd(k, n);
  long d = vals[0];
  long a = vals[1];
  long b = vals[2];
  if (a > 0) return a;
  return n + a;
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
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}