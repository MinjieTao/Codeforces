import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    boolean[] sieve = new boolean[1000001];
    Arrays.fill(sieve, true);
    sieve[0]=sieve[1]=false;
    for(int i = 2; i<sieve.length; i++) if(sieve[i]) for(long j = (long)i*i; j<sieve.length; j+=i) sieve[(int)j] = false;

    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    PrintWriter out = new PrintWriter(System.out);

    input.init(System.in);
    int n = input.nextInt();
    t = new ArrayList[n]; 
    k = input.nextInt();
    tg2 = new ArrayList[n];
    for(int i = 0; i<n; i++)
    {
        t[i] = new ArrayList<Integer>();
        tg2[i] = new ArrayList<Integer>();
    }
    for(int i = 0; i<n-1; i++)
    {
        int a= input.nextInt()-1, b = input.nextInt()-1;
        t[a].add(b);
        t[b].add(a);
    }
//  Queue<Integer> q = new ArrayDeque<Integer>();
//    boolean[] visited = new boolean[n];
//    Arrays.fill(visited, false);
//    visited[0]=true;
//    q.add(0);
//    while(!q.isEmpty()) {
//      int at = q.poll();
//      for(int adj : t[at])
//        if(!visited[adj]) {
//          visited[at] = true;
//          tg2[at].add(adj);
//          q.add(adj);
//        }
//    }
    int h = tree(0,-1);
    if(2*h < k)
    {
        out.println(0);
        out.close();
        return;
    }
    depth = new int[n][k+1];
    deep(0);
//  Stack<Integer> stk = new Stack<Integer>();
//  stk.push(0);
//  boolean[] done = new boolean[n];
//  depth[0][0]++;
//  while(!stk.isEmpty())
//  {
//      int at = stk.pop();
//      if(!done[at]) 
//      {
//          stk.push(at);
//          for(int a: tg2[at])
//              {
//                  depth[a][0]++;
//                  stk.push(a);
//              }
//          done[at] = true;
//      }
//      else
//      for(int a: tg2[at])
//          for(int j = 0; j<k; j++)
//              depth[at][j+1] += depth[a][j];
//  }
    
//  for(int i = 0; i<n; i++)
//  {
//      for(int j = 0; j<=k; j++)
//          out.print(depth[i][j] + " ");
//      out.println();
//  }
    long res = 0;
    for(int i = 0; i<n; i++)
        res += depth[i][k];
    for(int i = 0; i<n; i++)
    {
        if(tg2[i].size()==0)continue;
//      int[] kk = new int[k+1];
//      for(int j = 1; j<=k; j++)
//      {
//          for(int p:tg2[i]) kk[j] += depth[p][j-1];           
//      }
//      long toAdd = 0;
        for(int j = 0; j<k-1; j++)
        {
            int x= 0;
            for(int p:tg2[i])
            {
                res += (long)depth[p][j]*(x);
                x += depth[p][k-j-2];
            }
        }
//      res+=toAdd;
    }
    out.println(res);
    out.close();
}
static ArrayList<Integer>[] t, tg2;
static int[][] depth;
static int k;
static int tree(int at, int parent)
{
    int height = 0;
    for(int i: t[at])
        if(i!= parent)
        {
            tg2[at].add(i);
            height = Math.max(height,tree(i,at));
        }
    return height+1;
}
static void deep(int at)
{
    depth[at][0]++;
    for(int i: tg2[at])
        deep(i);
    for(int i: tg2[at])
        for(int j = 0; j<k; j++)
            depth[at][j+1] += depth[i][j];
            
}
static class X implements Comparable<X>
{
    int a;
    double b;
    public X(int a, double b)
    {
        this.a = a; this.b = b;
    }
    @Override
    public int compareTo(X that) {
        // TODO Auto-generated method stub
        if(this.b == that.b) return this.a-that.a;
        return (int)Math.signum(that.b-this.b);
    }
}
public static long gcd(long a, long b)
{
if(b == 0) return a;
return gcd(b, a%b);
}
public static class input {
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
}
static class IT
{
    int[] left,right, val, a, b;
    IT(int n)
    {
        left = new int[3*n];
        right = new int[3*n];
        val = new int[3*n];
        a = new int[3*n];
        b = new int[3*n];
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