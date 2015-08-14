import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt();
  int[] data = new int[n];
  int ones = 0;
  for(int i = 0; i<n; i++)
  {
      data[i] = input.nextInt();
      if(data[i] == 1) ones++;
  }
  int res = 0;
  for(int i = 0; i<n; i++)
      for(int j = i; j<n; j++)
      {
          int count = ones;
          for(int k = i; k<=j; k++)
              if(data[k] == 0) count++;
              else count--;
          res =Math.max(res,count);
      }
  out.println(res);
  
  
  out.close();
  
}
static long pow(long base, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(base, p/2);
        return (sqrt*sqrt)%mod;
    }
    return (base*pow(base, p-1))%mod;
}
static long modinv(long x)
{
    return pow(x, mod-2);
}
/*
Sum Interval Tree - uses O(n) space
Updates and queries over a range of values in log(n) time
*/
static class IT
{
    int[] left,right, a, b;
    long[] val;
    IT(int n)
    {
        left = new int[4*n];
        right = new int[4*n];
        val = new long[4*n];
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
    long get(int x, int y)
    {
        return go(x,y, 0);
    }
    long go(int x,int y, int at)
    {
        if(at==-1) return 0;
        if(x <= a[at] && y>= b[at]) return val[at];
        if(y<a[at] || x>b[at]) return 0;
        return go(x, y, left[at]) + go(x, y, right[at]);
    }
    //add v to elements x through y
    void add(int x, int y, long v)
    {
        go3(x, y, v, 0);
    }
    void go3(int x, int y, long v, int at)
    {
        if(at==-1) return;
        if(y < a[at] || x > b[at]) return;
        val[at] += (Math.min(b[at], y) - Math.max(a[at], x) + 1)*v;
        go3(x, y, v, left[at]);
        go3(x, y, v, right[at]);
    }
}
static ArrayList<Integer>[] g;
static boolean[] marked;
static int[] id, low, stk;
static int pre, count;
static void scc()
{
    id = new int[g.length]; low = new int[g.length]; stk = new int[g.length+1];
    pre = count = 0;
    marked = new boolean[g.length];
    for(int i =0; i<g.length; i++)
        if(!marked[i]) dfs(i);
}
static void dfs(int i)
{
    marked[stk[++stk[0]]=i] = true;
    int min = low[i] = pre++;
    for(int j: g[i])
    {
        if(!marked[j]) dfs(j);
        if(low[j] < min) min = low[j];
    }
    if(min < low[i]) low[i] = min;
    else
    {
        while(stk[stk[0]] != i)
        {
            int j =stk[stk[0]--];
            id[j] = count;
            low[j] = g.length;
        }
        id[stk[stk[0]--]] = count++;
        low[i] = g.length;
    }
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