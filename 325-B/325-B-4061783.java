import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
//  boolean[] primes = new boolean[10000001];
//  for(int i = 0; i<primes.length; i++) primes[i] = true;
//  primes[0] = false;
//  primes[1] = false;
//  for(int i = 2; i<=Math.sqrt(primes.length); i++)
//  {
//      if(primes[i])
//      {
//          for(int j = i*i; j < primes.length; j+=i)
//              primes[j] = false;
//      }
//  }
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  long n = input.nextLong();
  TreeSet<Long> res = new TreeSet<Long>();
  for(long pow = 60; pow >= 0; pow--)
  {
      if((1l << pow) > 1+n) continue;
      long lo = 1, hi = Math.min((long)2e9, (long)(3e18/(1l<<pow)));
      while(hi>lo+1)
      {
          long mid = (hi+lo)/2;
          long ans = mid*(mid-1)/2 + ((1l<<pow)-1)*mid;
          if(ans <= n) lo = mid;
          else hi = mid;
      }
      if(lo*(lo-1)/2 + ((1l<<pow) -1)*lo == n && lo%2==1)
          res.add((1l<<pow)*lo);
  }
  for(long x: res) out.println(x);
  if(res.size()==0) out.println(-1);

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