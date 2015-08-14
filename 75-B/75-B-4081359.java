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
  String me = input.next();
  int n = input.nextInt();
  HashMap<String, Integer> map = new HashMap<String, Integer>();
  for(int i = 0; i<n; i++)
  {
    String s1 = input.next();
    int points = 0;
    String action = input.next();
    if(action.equals("likes"))
    {
      points = 5;
    }
    else
    {
      input.next();
      if(action.equals("posted")) points = 15;
      else points = 10;
    }
    String s2 = input.next();
    s2 = s2.substring(0, s2.length()-2);
    input.next();
    if(!s1.equals(me) && !s2.equals(me))
    {
      if(!map.containsKey(s1)) map.put(s1,0);
      if(!map.containsKey(s2)) map.put(s2,0);
      continue;
    }
    if(s1.equals(me))
    {
      String temp = s1;
      s1 = s2;
      s2 = temp;
    }
    if(!map.containsKey(s1)) map.put(s1, points);
    else map.put(s1,points+map.get(s1));
  }
  ArrayList<Friend> sorted = new ArrayList<Friend>();
  for(String s: map.keySet()) sorted.add(new Friend(s, map.get(s)));
  Collections.sort(sorted);
  for(Friend s: sorted) out.println(s.name);

  out.close();
}
static class Friend implements Comparable<Friend>
{
  String name;
  int points;
  public Friend(String n, int p)
  {
    name = n;
    points = p;
  }
  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Friend that) {
    // TODO(mkirsche): Auto-generated method stub
    if(this.points == that.points) return this.name.compareTo(that.name);
    return that.points - this.points;
  }
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