import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int oo = 10000000;
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i =0; i<n; i++) data[i] = input.nextInt();
    IT it = new IT(n);
    IT it2 = new IT(n+1);
    
    for(int i = 0; i<n; i++)
    {
        it2.add(data[i], i+1);
        int x = it2.get(data[i]+1, n);
        //out.println(i+" "+x);
        int toPut = 0;
        if(x-1 == -1) toPut = oo;
        else if(x-1 == i-1) toPut = 1;
        else toPut = it.get(x-1+1, i-1)+1;
        it.add(i, toPut);
    }
    int res = 0;
    for(int i = 0; i<n; i++)
    {
        int cur = it.get(i, i);
        //out.println(cur);
        if(cur != oo) res = Math.max(res, cur);
    }
    out.println(res);

    out.close();
}
static class IT
{
    int[] left,right, val, a, b;
    IT(int n)
    {
        left = new int[4*n];
        right = new int[4*n];
        val = new int[4*n];
        //Arrays.fill(val, -1);
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
        return Math.max(go(x, y, left[at]), go(x, y, right[at]));
    }
    //add v to elements x through y
    void add(int x, int v)
    {
        go3(x, v, 0);
    }
    void go3(int x, int v, int at)
    {
        if(at==-1) return;
        if(x < a[at] || x > b[at]) return;
        if(x >= a[at] && x <= b[at]) val[at] = Math.max(val[at], v);
        go3(x, v, left[at]);
        go3(x, v, right[at]);
    }
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
//static class IT2
//{
//  int[] left,right, val, a, b;
//  IT2(int n)
//  {
//      left = new int[4*n];
//      right = new int[4*n];
//      val = new int[4*n];
//      Arrays.fill(val, 10000000);
//      a = new int[4*n];
//      b = new int[4*n];
//      init(0,0, n);
//  }
//  int init(int at, int l, int r)
//  {
//      a[at] = l;
//      b[at] = r;
//      if(l==r)
//          left[at] = right [at] = -1;
//      else 
//      {
//          int mid = (l+r)/2;
//          left[at] = init(2*at+1,l,mid);
//          right[at] = init(2*at+2,mid+1,r);
//      }
//      return at++;
//  }
//  //return the sum over [x,y]
//  int get(int x, int y)
//  {
//      return go(x,y, 0);
//  }
//  int go(int x,int y, int at)
//  {
//      if(at==-1) return 0;
//      if(x <= a[at] && y>= b[at]) return val[at];
//      if(y<a[at] || x>b[at]) return 0;
//      return Math.min(go(x, y, left[at]), go(x, y, right[at]));
//  }
//  //add v to elements x through y
//  void add(int x, int v)
//  {
//      go3(x, v, 0);
//  }
//  void go3(int x, int v, int at)
//  {
//      if(at==-1) return;
//      if(x < a[at] || x > b[at]) return;
//      if(x >= a[at] && x <= b[at]) val[at] = Math.min(val[at], v);
//      go3(x, v, left[at]);
//      go3(x, v, right[at]);
//  }
//}
}