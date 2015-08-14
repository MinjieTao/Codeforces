import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    
    
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt(), m = input.nextInt();
  int[] as = new int[n], bs = new int[n];
  int[] ls = new int[m], rs = new int[m];
  for(int i = 0; i<n; i++) as[i] = input.nextInt();
  for(int i = 0; i<n; i++) bs[i] = input.nextInt();
  //IT it = new IT(n);
  int[] tree = new int[4 * n + 10];
  initTree(tree, 0, 0, n - 1);
  for(int i = 0; i<m; i++)
  {
      int type = input.nextInt();
      if(type == 1)
      {
          int x = input.nextInt()-1, y = input.nextInt()-1, k = input.nextInt();
          ls[i] = x; rs[i] = y;
          //it.add(y, y+k-1, i+1);
          updateTree(tree, 0, 0, n-1, y,y+k-1,i+1);
      }
      else
      {
          int index = input.nextInt()-1;
          //int query = it.get(index);
          int query = getFromTree(tree, 0, 0, n - 1, index);
          if(query == UNCHANGED) out.println(bs[index]);
          else out.println(as[ls[query-1] + (index - rs[query-1])]);
      }
  }
  out.close();
}
static private int getFromTree(int[] tree, int root, int rl, int rr, int pos) {
    if (tree[root] != MIXED) return tree[root];
    int rm = (rl + rr) / 2;
    if (pos > rm)
        return getFromTree(tree, root * 2 + 2, rm + 1, rr, pos);
    else
        return getFromTree(tree, root * 2 + 1, rl, rm, pos);
}
static final int UNCHANGED = (int) 1e9;
static final int MIXED = (int) 1e9 + 1;
static private void updateTree(int[] tree, int root, int rl, int rr, int left, int right, int value) {
    if (left > right) return;
    if (rl == left && rr == right) {
        tree[root] = value;
        return;
    }
    if (tree[root] != MIXED) {
        tree[root * 2 + 1] = tree[root];
        tree[root * 2 + 2] = tree[root];
        tree[root] = MIXED;
    }
    int rm = (rl + rr) / 2;
    updateTree(tree, root * 2 + 1, rl, rm, left, Math.min(right, rm), value);
    updateTree(tree, root * 2 + 2, rm + 1, rr, Math.max(rm + 1, left), right, value);
}

static private void initTree(int[] tree, int root, int rl, int rr) {
    if (rl == rr) {
        tree[root] = UNCHANGED;
    } else {
        int rm = (rl + rr) / 2;
        initTree(tree, root * 2 + 1, rl, rm);
        initTree(tree, root * 2 + 2, rm + 1, rr);
        tree[root] = MIXED;
    }
}
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
    //return the max over [x,y]
    int get(int x)
    {
        return go(x, 0);
    }
    int go(int x, int at)
    {
        if(at==-1) return 0;
        if(x == a[at] && x== b[at]) return val[at];
        if(x<a[at] || x>b[at]) return 0;
        return Math.max(go(x, left[at]), go(x, right[at]));
    }
    //max v with elements x through y
    void add(int x, int y, int v)
    {
        go3(x, y, v, 0);
    }
    void go3(int x, int y, int v, int at)
    {
        if(at==-1) return;
        if(y < a[at] || x > b[at]) return;
        if(v>val[at])
        {
            val[at] = v;
            go3(x, y, v, left[at]);
            go3(x, y, v, right[at]);
        }
    }
}
static long pow (long a, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(a, p/2);
        return (sqrt*sqrt)%mod;
    }
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