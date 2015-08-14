import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), m = input.nextInt();
  long[] ls = new long[n], rs = new long[n];
  for(int i = 0; i<n; i++)
  {
    ls[i] = input.nextLong();
    rs[i] = input.nextLong();
  }
  Interval[] data = new Interval[n-1];
  for(int i = 0; i<n-1; i++) data[i] = new Interval(ls[i+1] - rs[i], rs[i+1] - ls[i], i);
  Arrays.sort(data);
  Interval[] bridge = new Interval[m];
  for(int i = 0; i<m; i++) bridge[i] = new Interval(input.nextLong(), 0, i);
  Arrays.sort(bridge);
  TreeMap<Interval, Integer> map = new TreeMap<Interval, Integer>();
  int at = 0;
  int[] res = new int[n-1];
  for(int i = 0; i<m; i++)
  {
    while(at < n-1 && data[at].a <= bridge[i].a)
    {
      inc(map, new Interval(data[at].b, 0, data[at].i));
      at++;
    }
    //System.out.println(bridge[i].a+" "+map);
    Interval cur = map.ceilingKey(new Interval(bridge[i].a, 0, 0));
    if(cur != null)
    {
      res[cur.i] = bridge[i].i;
      dec(map, cur);
    }
  }
  if(at < n-1 || map.size() > 0) out.println("No");
  else
  {
    out.println("Yes");
    for(int x : res) out.print((x+1)+" ");
  }
  
  
  out.close();
}
static void dec(TreeMap<Interval, Integer> map, Interval x)
{
  map.put(x, map.get(x) - 1);
  if(map.get(x) == 0) map.remove(x);
}
static void inc(TreeMap<Interval, Integer> map, Interval x)
{
  map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
}
static class Interval implements Comparable<Interval>
{
  int i;
  long a, b;
  public Interval(long aa, long bb, int ii)
  {
    a = aa; b = bb; i = ii;
  }
  @Override
  public int compareTo(Interval o) {
    if(a == o.a) return i - o.i;
    return Long.signum(a - o.a);
  }
  public String toString()
  {
    return "("+a+" "+b+" "+i+")";
  }
}
public static class input {
  static BufferedReader reader;
  static StringTokenizer tokenizer;
  static void init(InputStream input) {
      reader = new BufferedReader(
                   new InputStreamReader(input) );
      tokenizer = new StringTokenizer("");
  }
  static String next() throws IOException {
      while ( ! tokenizer.hasMoreTokens() ) {
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
}
}