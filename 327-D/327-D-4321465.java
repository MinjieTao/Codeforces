import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000009;
    static char[][] res;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  n = input.nextInt(); m = input.nextInt();
  char[][] data = new char[n][m];
  res = new char[n][m];
  for(int i = 0; i<n; i++) res[i] = data[i] = input.next().toCharArray();
  count = 0;
  is = new ArrayList<Integer>();
  js = new ArrayList<Integer>();
  cs = new ArrayList<Character>();
  for(int i = 0; i<n; i++)
  {
      for(int j = 0; j<m; j++)
      {
          if(res[i][j] == '.') dfs(i, j, i, j);
      }
  }
  out.println(count);
  for(int i = 0; i<is.size(); i++)
  {
      out.println(cs.get(i)+" " +is.get(i)+" "+js.get(i));
      if(cs.get(i) == 'D')
          out.println('R'+" "+is.get(i)+" "+js.get(i));
  }
  out.close();
}
static int count;
static ArrayList<Integer> is;
static ArrayList<Integer> js;
static ArrayList<Character> cs;
static int n, m;
static void dfs(int i, int j, int badi, int badj)
{
    int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    res[i][j] = 'B';
    is.add(i+1);
    js.add(j+1);
    cs.add('B');
    count++;
    for(int k = 0; k<4; k++)
    {
        int ny = i+dy[k], nx = j+dx[k];
        if(ny<0||nx<0||ny>=n||nx>=m) continue;
        if(res[ny][nx] == '.')
        {
            dfs(ny, nx, badi, badj);
        }
    }
    if(i==badi && j ==badj) return;
    count +=2;
    cs.add('D');
    is.add(i+1);
    js.add(j+1);
    res[i][j] = 'R';
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