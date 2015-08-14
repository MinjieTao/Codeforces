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
  int[] data = new int[n],freq = new int[100001],sindex = new int[100001], count = new int[n+1];
  for(int i = 0; i<n; i++) freq[data[i] = input.nextInt()]++;
  boolean good = true;
  for(int i = 1; i<100000; i++) good &= freq[i+1] <= freq[i];
  ArrayList<Integer> sizes = new ArrayList<Integer>();
  for(int i = n; i>=1; i--)
  {
    int x = sizes.size();
    while(freq[i]-- > x) sizes.add(i);
  }
  Collections.sort(sizes);
  //for(int s: sizes) out.println(s);
  int last = 0;
  for(int i = 0; i<sizes.size(); i++) 
    if(i==0 || sizes.get(i) > sizes.get(i-1)) 
      for(int j = i == 0 ? 1 :sizes.get(i-1)+1; j<=sizes.get(i); j++) 
        sindex[j] = i;
  if(!good) out.println(-1);
  else{
  out.println(sizes.size());
  for(int i = 0; i<n; i++) 
  {
    //out.println(sindex[data[i]]+" "+ (++count[data[i]]));
    out.print((sindex[data[i]] +(++count[data[i]]))+" ");
  }
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