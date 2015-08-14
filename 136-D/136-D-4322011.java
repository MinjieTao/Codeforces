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
  xs = new int[8]; ys = new int[8];
  String[] orders = {"0123","0132","0213","0231","0312","0321",
          "1023","1032","1203","1230","1302","1320",
          "2013","2031","2103","2130","2301","2310",
          "3012","3021","3102","3120","3201","3210"};
  for(int i = 0; i<8; i++)
  {
      xs[i] = input.nextInt();
      ys[i] = input.nextInt();
  }
  boolean found = false;
  for(int i = 0; i<8; i++)
      for(int j = 0; j<8; j++)
          for(int k = 0; k<8; k++)
              for(int l = 0; l<8; l++)
              {
                  if(i==j||i==k||i==l||j==k||j==l||k==l) continue;
                  int[] first = {i,j,k,l};
                  ArrayList<Integer> secondlist = new ArrayList<Integer>();
                  for(int m = 0; m<8; m++)
                      if(m != i && m != j && m != k && m != l) secondlist.add(m);
                  int[] second = new int[4];
                  for(int m = 0; m<4; m++)
                  {
                      second[m] = secondlist.get(m);
                  }
                  for(int x = 0; x<24; x++)
                  {
                      if(found) break;
                      for(int y = 0; y<24; y++)
                      {
                          int[] sortedx = new int[4];
                          for(int z = 0; z<4; z++)
                              sortedx[z] = first[orders[x].charAt(z)-'0'];
                          int[] sortedy = new int[4];
                          for(int z = 0; z<4; z++)
                              sortedy[z] = second[orders[y].charAt(z)-'0'];
                          int dist = dist(sortedx[0], sortedx[1]);
                          if(dist != dist(sortedx[1], sortedx[2])) continue;
                          if(dist != dist(sortedx[3], sortedx[2])) continue;
                          if(dist != dist(sortedx[0], sortedx[3])) continue;
                          if(dist + dist != dist(sortedx[0], sortedx[2])) continue;
                          int dist1 = dist(sortedy[0], sortedy[1]), dist2 = dist(sortedy[2], sortedy[1]);
                          if(dist1 != dist(sortedy[2], sortedy[3])) continue;
                          if(dist2 != dist(sortedy[3], sortedy[0])) continue;
                          if(dist1+dist2 != dist(sortedy[0], sortedy[2])) continue;
                          found = true;
                          out.println("YES");
                          for(int xx: sortedx) out.print((xx+1)+" ");
                          out.println();
                          for(int yy: sortedy) out.print((yy+1)+" ");
                          break;
                      }
                      if(found) break;
                  }
                  if(found) break;
              }
  if(!found) out.println("NO"); 
  out.close();
}
static int[] xs, ys;
static int dist(int a, int b)
{
    return (xs[a]-xs[b])*(xs[a]-xs[b]) + (ys[a]-ys[b])*(ys[a]-ys[b]);
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