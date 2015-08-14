import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(System.out);
  int n = input.nextInt(), m = input.nextInt();
  int[] rs = new int[m], cs = new int[m];
  char[] types = new char[m];
  TreeSet<Integer> set = new TreeSet<Integer>();
  set.add(-1);
  for(int i = 0; i<m; i++)
  {
    cs[i] = input.nextInt()-1;
    rs[i] = input.nextInt()-1;
    set.add(cs[i]);
    set.add(rs[i]);
    types[i] = input.next().charAt(0);
  }
  HashMap<Integer, Integer> compress = new HashMap<Integer, Integer>();
  int[] rev = new int[set.size()];
  int at = 0;
  for(int x : set)
  {
    compress.put(x, at);
    rev[at] = x;
    at++;
  }
  n = set.size();
  IT rows = new IT(n), cols = new IT(n);
  for(int i = 0; i<m; i++)
  {
    int realRow = rs[i], realCol = cs[i];
    int col = compress.get(cs[i]), row = compress.get(rs[i]);
    char c = types[i];
    int query = (c == 'U') ? cols.get(col, col) : rows.get(row, row);
    if(query < 0) query = 0;
    out.println((c == 'U') ? realRow - rev[query] : realCol - rev[query]);
    if(c == 'U')
    {
      rows.add(query+1, row, col);
      cols.add(col, col, row);
    }
    else
    {
      cols.add(query+1, col, row);
      rows.add(row, row, col);
    }
  }
  out.close();
}
//Minimum Interval Tree
static class IT
{
  static int oo = 987654321;
  int[] left,right, val, a, b, prop;
  IT(int n)
  {
      left = new int[4*n];
      right = new int[4*n];
      val = new int[4*n];
      prop = new int[4*n];
      a = new int[4*n];
      b = new int[4*n];
      init(0,0, n-1);
  }
  int init(int at, int l, int r)
  {
      a[at] = l;
      b[at] = r;
      if(l==r)
      {
        val[at]= prop[at] = -oo;
          left[at] = right [at] = -1;
      }
      else 
      {
          int mid = (l+r)/2;
          left[at] = init(2*at+1,l,mid);
          right[at] = init(2*at+2,mid+1,r);
          val[at] = prop[at] = -oo;
      }
      return at++;
  }
  //return the max over [x,y]
  int get(int x, int y)
  {
      return go(x,y, 0);
  }
  void push(int at)
  {
      if(prop[at] != -oo)
      {
          go3(a[left[at]], b[left[at]], prop[at], left[at]);
          go3(a[right[at]], b[right[at]], prop[at], right[at]);
          prop[at] = -oo;
      }
  }
  int go(int x,int y, int at)
  {
      if(at==-1 || y<a[at] || x>b[at]) return -oo;
      if(x <= a[at] && y>= b[at]) return val[at];
      push(at);
      return Math.max(go(x, y, left[at]), go(x, y, right[at]));
  }
  //max v to elements x through y
  void add(int x, int y, int v)
  {
      go3(x, y, v, 0);
  }
  void go3(int x, int y, int v, int at)
  {
      if(at==-1) return;
      if(y < a[at] || x > b[at]) return;
      x = Math.max(x, a[at]);
      y = Math.min(y, b[at]);
      if(y == b[at] && x == a[at])
      {
          val[at] = Math.max(val[at], v);
          prop[at] = Math.max(prop[at], v);
          return;
      }
      push(at);
      go3(x, y, v, left[at]);
      go3(x, y, v, right[at]);
      val[at] = Math.max(val[left[at]], val[right[at]]);
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