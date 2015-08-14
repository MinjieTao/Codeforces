import java.util.*;
import java.io.*;
public class b {
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
    int n =input.nextInt();
    String s = input.next();
    boolean res = true;
    if(n>0)
    res &= s.charAt(0) !='0';
    res &= s.length() == (n+"").length();
    int m = Integer.parseInt(s);
    int[] f1 = new int[10], f2 = new int[10];
    res &= (n+"").length() == (m+"").length();
    String s1 = n+"", s2 = m+"";
    if(res)
    for(int i = 0; i<(n+"").length(); i++)
    {
        f1[s1.charAt(i)-'0']++;
        f2[s2.charAt(i)-'0']++;
    }
    for(int i =0; i<10; i++)
        res &= f1[i] == f2[i];
    //if(s2.charAt(0)=='0') res = false;
    for(int i = 0; i<s2.length(); i++)
        for(int j = i+1; j<s2.length(); j++)
        {
            if(s2.charAt(j) < s2.charAt(i))
            {
                if(s2.charAt(j) == '0' && i == 0)
                    continue;
                res = false;
            }
        }
    out.println(res?"OK":"WRONG_ANSWER");
    out.close();
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