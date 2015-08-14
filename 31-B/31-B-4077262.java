import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  String s = input.nextLine();
  int n = s.length();
  if(s.indexOf('@') == -1 || s.charAt(0) == '@' || s.charAt(n-1) == '@') out.println("No solution");
  else
  {
    boolean found = false;
    for(int i = n-2; i>=1; i--)
    {
      if(s.charAt(i) == '@')
      {
        if(!found) found = true;
        else
        {
          s = s.substring(0, i+2)+","+s.substring(i+2);
        }
      }
    }
    boolean good = true;
    for(int i = 0; i<s.length()-1; i++)
    {
      char c1 = s.charAt(i), c2 = s.charAt(i+1);
      if(c1 == ',' && c2 == '@' || c1 == '@' && c2 == '@') good = false;
    }
    if(good) out.println(s);
    else out.println("No solution");
  }


  out.close();
}
static int reverse(int x)
{
  String s = Integer.toBinaryString(x);
  while(s.length()<8) s = '0'+s;
  String t = "";
  for(int i = 7; i>=0; i--) t += s.charAt(i);
  return Integer.parseInt(t, 2);

}
static long[][] comb(int n)
{
  long[][] res = new long[n+1][n+1];
  Arrays.fill(res[0], 0);
  for(int i = 0; i<=n; i++) res[i][0] = 1;
  for(int i = 1; i<=n; i++)
    for(int j = 1; j<=n; j++)
      res[i][j] = (res[i-1][j-1] + res[i-1][j])%mod;
  return res;
}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b, a%b);
}
static long pow(long a, long p)
{
  if(p<=0) return 1;
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