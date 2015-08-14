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
  int[] ks = new int[3], ts = new int[3];
  for(int i = 0; i<3; i++) ks[i] = input.nextInt(); //max queue sizes
  for(int i = 0; i<3; i++) ts[i] = input.nextInt(); //queue processing times
  int n = input.nextInt();
  int[] starts = new int[n]; //for bookkeeping to help calculate final answer
  Queue<Integer> arr = new LinkedList<Integer>(); //people arriving
  for(int i = 0; i<n; i++) arr.add(starts[i]=input.nextInt());
  long t = 0; //current time
  //Note: The queues store the time at which people can leave them
  Queue<Long> q1 = new LinkedList<Long>(), q2 = new LinkedList<Long>(), q3 = new LinkedList<Long>();
  int numDone = 0;
  long[] ends = new long[n];
  for(int i = 0; i<4*n; i++) //each person will move four times, so no more than 4*n iterations needed
  {
    if(numDone == n) break;
    long newTime = (long)1e18;
    if(!q3.isEmpty())
      newTime = Math.min(newTime, q3.peek()-t);
    if(q3.size() < ks[2] && !q2.isEmpty())
      newTime = Math.min(newTime, q2.peek()-t);
    if(q2.size() < ks[1] && !q1.isEmpty())
      newTime = Math.min(newTime, q1.peek()-t);
    if(q1.size() < ks[0] && !arr.isEmpty())
      newTime = Math.min(newTime, arr.peek()-t);
    t += newTime;
    //out.println(t+" "+arr.size()+" "+q1.size()+" "+q2.size()+" "+q3.size());
    while(!q3.isEmpty() && q3.peek() <= t)
      ends[numDone++] = q3.poll();
    while(!q2.isEmpty() && q3.size() < ks[2] && q2.peek() <= t)
    {
      q2.poll();
      q3.add(t+ts[2]);
    }
    while(!q1.isEmpty() && q2.size() < ks[1] && q1.peek() <= t)
    {
      q1.poll();
      q2.add(t+ts[1]);
    }
    while(!arr.isEmpty() && q1.size() < ks[0] && arr.peek() <= t)
    {
      arr.poll();
      q1.add(t+ts[0]); 
    }
  }
  long max = 0;
  //for(long e: ends) out.println(e);
  for(int i = 0; i<n; i++) max = Math.max(max, ends[i]-starts[i]);
  out.println(max);
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