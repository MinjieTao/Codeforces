import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000009;
    static ArrayList<Integer>[] tree;
    static long[] data;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt(), m = input.nextInt();
  int[] maxrow = new int[n], minrow = new int[n], maxcol = new int[n], mincol = new int[n];
  int[] maxsum = new int[2*n+1], minsum = new int[2*n+1], mindiff = new int[2*n+1], maxdiff = new int[2*n+1];
  Arrays.fill(minrow, 987654321);
  Arrays.fill(mincol, 987654321);
  Arrays.fill(minsum, 987654321);
  Arrays.fill(mindiff, 987654321);
  int[] rs = new int[m], cs = new int[m];
  for(int i = 0; i<m; i++)
  {
      rs[i] = input.nextInt()-1;
      cs[i] = input.nextInt()-1;
      maxrow[rs[i]] = Math.max(maxrow[rs[i]], cs[i]);
      minrow[rs[i]] = Math.min(minrow[rs[i]], cs[i]);
      maxcol[cs[i]] = Math.max(maxcol[cs[i]], rs[i]);
      mincol[cs[i]] = Math.min(mincol[cs[i]], rs[i]);
      maxsum[rs[i]+cs[i]] = Math.max(maxsum[rs[i]+cs[i]], rs[i]);
      minsum[rs[i]+cs[i]] = Math.min(minsum[rs[i]+cs[i]], rs[i]);
      maxdiff[rs[i]-cs[i]+n] = Math.max(maxdiff[rs[i]-cs[i]+n], rs[i]);
      mindiff[rs[i]-cs[i]+n] = Math.min(mindiff[rs[i]-cs[i]+n], rs[i]);
  }
  int[] freq = new int[9];
  for(int i = 0; i<m; i++)
  {
      int count = 0;
      if(maxrow[rs[i]] > cs[i]) count++;
      if(minrow[rs[i]] < cs[i]) count++;
      if(maxcol[cs[i]] > rs[i]) count++;
      if(mincol[cs[i]] < rs[i]) count++;
      if(maxsum[rs[i]+cs[i]] > rs[i]) count++;
      if(minsum[rs[i]+cs[i]] < rs[i]) count++;
      if(maxdiff[rs[i]-cs[i]+n] > rs[i]) count++;
      if(mindiff[rs[i]-cs[i]+n] < rs[i]) count++;
      //out.println(count);
      freq[count]++;
  }
  for(int x: freq) out.print(x+" ");
  out.close();
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