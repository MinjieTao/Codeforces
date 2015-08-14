import java.util.*;
import java.io.*;
public class a {
  static long mod  = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt();
  for(int i = 0; i<n; i++) {int x = input.nextInt(); out.println(x==1 ? 0:x-2);}

  out.close();
}
static short[][][][] dp;
static short go(int num, int top, int second, int third, char[] suits, char[] nums)
{
  if(num==1) return 1;
  if(num == 2)
    return (short) ((nums[top] == nums[second] || suits[top] == suits[second]) ? 1 : 0);
  if(num==3)
    return (short) (((nums[top] == nums[second] || suits[top] == suits[second]) 
        && (nums[top] == nums[third] || suits[top] == suits[third])) ? 1 : 0);
  if(dp[num-1][top][second][third] != -1) return dp[num-1][top][second][third];
  if((nums[top] == nums[second] || suits[top] == suits[second]) && go(num-1,top,third, num-4, suits, nums)>0)
    return dp[num-1][top][second][third]=1;
  if(num >= 3)
    if((nums[top] == nums[num-4] || suits[top] == suits[num-4]) && go(num-1,second,third, top, suits, nums)>0)
      return dp[num-1][top][second][third]=1;
  return dp[num-1][top][second][third]=0;
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
  public static boolean hasNext() {
    // TODO(mkirsche): Auto-generated method stub
    return tokenizer.hasMoreTokens();
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