import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    int[] as = new int[m], bs = new int[m], cs = new int[m];
    IT it = new IT(n);
    for(int i = 0; i<m; i++)
    {
        as[i] = input.nextInt()-1;
        bs[i] = input.nextInt()-1;
        cs[i] = input.nextInt();
        it.add(as[i], bs[i], cs[i]);
    }
    boolean good = true;
    for(int i = 0; i<m; i++)
    {
        good &= it.get(as[i], bs[i]) == cs[i];
    }
    if(good)
    {
        out.println("YES");
        for(int i = 0; i<n; i++) out.print(it.get(i, i)+" ");
    }
    else out.println("NO");
    out.close();
}
//Minimum Interval Tree
static class IT
{
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
            left[at] = right [at] = -1;
        else 
        {
            int mid = (l+r)/2;
            left[at] = init(2*at+1,l,mid);
            right[at] = init(2*at+2,mid+1,r);
        }
        return at++;
    }
    //return the min over [x,y]
    int get(int x, int y)
    {
        return go(x,y, 0);
    }
    void push(int at)
    {
        if(prop[at] != 0)
        {
            go3(a[left[at]], b[left[at]], prop[at], left[at]);
            go3(a[right[at]], b[right[at]], prop[at], right[at]);
            prop[at] = 0;
        }
    }
    int go(int x,int y, int at)
    {
        if(at==-1 || y<a[at] || x>b[at]) return (1<<30) - 1;
        if(x <= a[at] && y>= b[at]) return val[at];
        push(at);
        return go(x, y, left[at]) & go(x, y, right[at]);
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
        x = Math.max(x, a[at]);
        y = Math.min(y, b[at]);
        if(y == b[at] && x == a[at])
        {
            val[at] |= v;
            prop[at] |= v;
            return;
        }
        push(at);
        go3(x, y, v, left[at]);
        go3(x, y, v, right[at]);
        val[at] = val[left[at]] & val[right[at]];
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