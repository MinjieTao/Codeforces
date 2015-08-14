import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    Random r = new Random();
    int n =input.nextInt(), q = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    for(int i = 0; i<2*n; i++)
    {
        int x1 = r.nextInt(n), x2 = r.nextInt(n);
        int temp = data[x1];
        data[x1] = data[x2];
        data[x2] = temp;
    }
    Arrays.sort(data);
    int[] c = new int[n];
    for(int i = 0; i<q; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        c[a]++;
        if(b<n-1)c[b+1]--;
    }
    for(int i = 1; i<n; i++) c[i] += c[i-1];
    for(int i = 0; i<2*n; i++)
    {
        int x1 = r.nextInt(n), x2 = r.nextInt(n);
        int temp = c[x1];
        c[x1] = c[x2];
        c[x2] = temp;
    }
    Arrays.sort(c);
    long res = 0;
    for(int i = 0; i<n; i++)
        res += (long)data[i]*c[i];
    out.println(res);
    out.close();
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