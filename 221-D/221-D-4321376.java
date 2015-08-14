import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000009;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt(), m = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  PriorityQueue<Query> qs = new PriorityQueue<Query>();
  for(int i = 0; i<m; i++)
  {
      int l = input.nextInt(), r = input.nextInt();
      qs.add(new Query(i, l-1, r-1));
  }
  IT it = new IT(n);
  HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
  int[] res = new int[m];
  for(int i = 0; i<n; i++)
  {
      if(!map.containsKey(data[i]))
          map.put(data[i], new ArrayList<Integer>());
      ArrayList<Integer> list = map.get(data[i]);
      (map.get(data[i])).add(i);
      if(list.size() >= data[i])
      {
          int leftUp = list.size() > data[i] ? 1 + list.get(list.size()-1-data[i]) : 0;
          int rightUp = list.get(list.size()-data[i]);
          it.add(rightUp, rightUp, 1);
          if(list.size() > data[i])
          {
              int leftDown = list.size() > data[i]+1 ? 1 + list.get(list.size()-2-data[i]) : 0;
              int rightDown = list.get(list.size()-data[i]-1);
              it.add(rightDown, rightDown, -2);
              if(list.size() > data[i]+1)
              {
                  rightUp = list.get(list.size()-data[i]-2);
                  it.add(rightUp, rightUp, 1);
              }
          }
      }
      while(!qs.isEmpty() && qs.peek().r == i)
      {
          Query q = qs.poll();
          res[q.i] = it.get(q.l, q.r);
      }
  }
  for(int x: res) out.println(x);
  
  out.close();
}
static class Query implements Comparable<Query>
{
    int i, l, r;
    public Query(int ii, int ll, int rr)
    {
        i = ii; l = ll; r = rr;
    }
    @Override
    public int compareTo(Query that) {
        // TODO Auto-generated method stub
        return this.r - that.r;
    }
}
static long pow(long x, long p)
{
    if(p==0) return 1;
    if((p&1) > 0)
    {
        return (x*pow(x, p-1))%mod;
    }
    long sqrt = pow(x, p/2);
    return (sqrt*sqrt)%mod;
}
static long gcd(long a, long b)
{
    if(b==0) return a;
    return gcd(b, a%b);
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
/*
Sum Interval Tree - uses O(n) space
Updates and queries over a range of values in log(n) time
Note: If querying all elements, use difference array instead.
*/
static class IT
{
    int[] left,right, val, a, b;
    IT(int n)
    {
        left = new int[4*n];
        right = new int[4*n];
        val = new int[4*n];
        a = new int[4*n];
        b = new int[4*n];
        init(0,0, n);
    }
    int init(int at, int l, int r)
    {
        a[at] = l;
        b[at] = r;
        if(l==r)
            left[at] = right [at] = -1;
        else 
        {
            int mid = (l+r)/2;
            left[at] = init(2*at+1,l,mid);
            right[at] = init(2*at+2,mid+1,r);
        }
        return at++;
    }
    //return the sum over [x,y]
    int get(int x, int y)
    {
        return go(x,y, 0);
    }
    int go(int x,int y, int at)
    {
        if(at==-1) return 0;
        if(x <= a[at] && y>= b[at]) return val[at];
        if(y<a[at] || x>b[at]) return 0;
        return go(x, y, left[at]) + go(x, y, right[at]);
    }
    //add v to elements x through y
    void add(int x, int y, int v)
    {
        go3(x, y, v, 0);
    }
    void go3(int x, int y, int v, int at)
    {
        if(at==-1) return;
        if(y < a[at] || x > b[at]) return;
        val[at] += (Math.min(b[at], y) - Math.max(a[at], x) + 1)*v;
        go3(x, y, v, left[at]);
        go3(x, y, v, right[at]);
    }
}
}