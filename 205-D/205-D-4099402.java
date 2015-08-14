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
  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  int n = input.nextInt();
  int max = 1;
  int[] as = new int[n], bs = new int[n];
  for(int i = 0; i<n; i++)
  {
    as[i] = input.nextInt(); bs[i] = input.nextInt();
  }
  int[] cs = new int[2*n];
  for(int i = 0; i<n; i++)
  {
    cs[2*i] = as[i];
    cs[2*i+1] = bs[i];
  }
  Arrays.sort(cs);
  boolean okay = false;
  for(int i = 0; i<2*n; i++)
    okay |= i+(n-1)/2 < 2*n && cs[i+(n-1)/2] == cs[i];
  if(!okay) out.println(-1);
  else
  {
    for(int i = 0; i<n; i++)
    {
      if(as[i] != bs[i])
      {
        if(!map.containsKey(as[i])) map.put(as[i], 1);
        else
          {
          int x = map.get(as[i])+1;
          max = Math.max(max, x);
          map.put(as[i], x);
          }
      }
      if(!map.containsKey(bs[i])) map.put(bs[i], 1);
      else
      {
        int x = map.get(bs[i])+1;
        max = Math.max(max, x);
        map.put(bs[i], x);
      }
      if((max + n-i-1)*2 <n) break;
    }
    int min = 987654321;
    if(max*2 >= n)
    for(int x: map.keySet())
    {
      if(map.get(x)*2 < n) continue;
      int count = 0;
      for(int i = 0; i<n; i++) if(as[i] == x) count++;
      min = Math.min(Math.max(0,(n+1)/2 - count), min);
    }
    out.println(min == 987654321 ? -1 : min);
  }

  out.close();
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

  /**
   * @return
   */
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