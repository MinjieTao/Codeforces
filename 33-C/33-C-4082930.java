import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
    boolean[] primes = new boolean[10000001];
    for(int i = 0; i<primes.length; i++) primes[i] = true;
    primes[0] = false;
    primes[1] = false;
    for(int i = 2; i<primes.length; i++)
    {
        if(primes[i])
        {
            for(int j = 2*i; j < primes.length; j+=i)
                primes[j] = false;
        }
    }
    
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt();
  int[] data = new int[n];
  int[] sums = new int[n];
  sums[0] = 0;
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  sums[0] = data[0];
  for(int i = 1; i<n; i++) sums[i] = data[i] + sums[i-1];
  int[][] dp = new int[n][2];
  dp[0][0] = -data[0];
  dp[0][1] = data[0];
  for(int i = 1; i<n; i++)
  {
      dp[i][0] = -1*sums[i];
      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]) + data[i];
  }
  //for(int i = 0; i<n; i++) out.println(dp[i][0]+" "+dp[i][1]);
  int[] sum2 = new int[n];
  sum2[n-1] = data[n-1];
  for(int i = n-2; i>=0; i--) sum2[i] = data[i]+sum2[i+1];
  int[][] dp2 = new int[n][2];
  dp2[n-1][0] = -data[n-1];
  dp2[n-1][1] = data[n-1];
  for(int i = n-2; i>=0; i--)
  {
      dp2[i][1] = Math.max(dp2[i+1][0], dp2[i+1][1])+data[i]; 
      dp2[i][0] = -1*sum2[i];
  }
  int max = 0;
  for(int i = 0; i<n-1; i++)
      max = Math.max(max, Math.max(dp[i][0], dp[i][1])+Math.max(dp2[i+1][0],dp2[i+1][1]));
  out.println(n==1 ? Math.abs(data[0]):max);
  out.close();
}

static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
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
  
  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}