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
  mod = (long)2e18;
  Long a = input.nextLong(), b = input.nextLong();
  //out.println(count(a-1)+" "+count(b));
  out.println(count(b) - count(a-1));


  out.close();
}
static long count(long x)
{
  if(x<10) return x;
  int len = (x+"").length();
  long res = 0;
  for(int i = 1; i<len; i++) res += i==1 ? 9: pow(10,i-2)*9;
  int[] data = new int[len];
  for(int i = 0; i<len; i++)
  {
    //System.out.println(x%10);
    data[i] = (int)(x%10);
    x /= 10;
  }
  //System.out.println("hi: "+go(data,1,0, 1));
  for(int i = 1; i<10; i++)
  res += go(data, 1, data[0] >= i ? 0 : 1, i);

  return res;
}
static long go(int[] data, int at, int big, int last)
{
  //if(at==data.length) return big>0 ? 0 : 1;
  if(at == data.length -1)
  {
    //System.out.println(at+" "+last+" "+big);
    if(big>0) return last < data[at] ? 1 : 0;
    else return last <= data[at] ? 1 : 0;
  }
  //System.out.println(at+" "+big+" "+data[at]);
  if(big>0) return (10-data[at])*go(data, at+1, 1, last) + (data[at])*go(data, at+1, 0, last);
  return (9-data[at])*go(data, at+1, 1, last) + (1+data[at])*go(data, at+1, 0, last);
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