import java.util.*;
import java.io.*;
public class C223 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    s = input.next();
    int n = s.length();
    IT it = new IT(n);
    s = null;
    int m = input.nextInt();
    PrintWriter out = new PrintWriter(System.out);
    for(int i = 0; i<m; i++)
    {
        out.println(2*it.get(input.nextInt()-1, input.nextInt()-1)[0]);
    }
    out.close();
}
static String s;
//Minimum Interval Tree
static class IT
{
    int[] left,right, complete, open, close, a, b;
    IT(int n)
    {
        complete = new int[4*n];
        open = new int[4*n];
        close = new int[4*n];
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
            //left[at] = right [at] = -1;
            if(s.charAt(l) == '(') open[at] = 1;
            else close[at] = 1;
        }
        else 
        {
            int mid = (l+r)/2;
            //left[at] = init(2*at+1,l,mid);
            //right[at] = init(2*at+2,mid+1,r);
            init(2*at+1,l,mid);
            init(2*at+2,mid+1,r);
            int left = 2*at+1;
            int right = 2*at+2;
            int o1 = open[left], o2 = open[right];
            int c1 = close[left], c2 = close[right];
            int merge = Math.min(o1, c2);
            complete[at] = complete[left] + complete[right] + merge;
            open[at] = o1 + o2 - merge;
            close[at] = c1 + c2 - merge;
            //System.out.println(a[at]+" "+b[at]+" "+complete[at]+" "+open[at]+" "+close[at]);
        }
        return at++;
    }
    //return the min over [x,y]
    int[] get(int x, int y)
    {
        return go(x,y, 0);
    }
//  void push(int at)
//  {
//      if(prop[at] != 0)
//      {
//          go3(a[left[at]], b[left[at]], prop[at], left[at]);
//          go3(a[right[at]], b[right[at]], prop[at], right[at]);
//          prop[at] = 0;
//      }
//  }
    int[] go(int x,int y, int at)
    {
        if(at==-1 || y<a[at] || x>b[at]) return new int[]{0, 0, 0};
        if(x <= a[at] && y>= b[at]) return new int[]{complete[at], open[at], close[at]};
        //push(at);
        int left = 2*at+1, right = 2*at+2;
        int[] l = go(x, y, left), r = go(x, y, right);
        int merge = Math.min(l[1], r[2]);
        return new int[]{r[0]+l[0]+merge, r[1]+l[1]-merge, r[2]+l[2]-merge};
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
}