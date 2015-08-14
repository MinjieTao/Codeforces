import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  
  int n= input.nextInt(), m = input.nextInt(), k = input.nextInt();
  long[] data = new long[n];
  long[] diffs = new long[n];
  for(int i = 0; i<n; i++)
      data[i] = input.nextInt();
  int[] ls = new int[m], rs = new int[m], ds = new int[m];
  for(int i = 0; i<m; i++)
  {
      ls[i] = input.nextInt()-1;
      rs[i] = input.nextInt()-1;
      ds[i] = input.nextInt();
  }
  int[] qcount = new int[m];
  for(int i = 0; i<k; i++)
  {
      int a = input.nextInt()-1, b = input.nextInt()-1;
      qcount[a] ++;
      if(b<m-1) qcount[b+1]--;
  }
  long x = 0;
  for(int i = 0; i<m; i++)
  {
      x += qcount[i];
      diffs[ls[i]] += ds[i]*x;
      if(rs[i]<n-1) diffs[rs[i]+1] -= ds[i]*x;
  }
  x = 0;
  for(int i = 0; i<n; i++)
  {
      x += diffs[i];
      data[i] += x;
  }
  for(int i = 0; i<n; i++) out.print(data[i]+" ");
  
  out.close();
  
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