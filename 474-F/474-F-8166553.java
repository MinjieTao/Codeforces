import java.util.*;
import java.io.*;
public class f {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    aa = new int[n];
    for(int i = 0; i<n; i++) aa[i] = input.nextInt();
    IT it = new IT(n);
    preprocess();
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        int gcd = query(a, b);
        int[] min = it.get(a, b);
        //System.out.println(gcd+" "+min[0]+" "+min[1]);
        if(min[0] != gcd) out.println(b-a+1);
        else out.println(b-a+1-min[1]);
    }
    out.close();
}
//Minimum Interval Tree
static class IT
{
    int[] left,right, val, a, b, prop, count;
    IT(int n)
    {
        left = new int[4*n];
        right = new int[4*n];
        val = new int[4*n];
        prop = new int[4*n];
        a = new int[4*n];
        b = new int[4*n];
        count = new int[4*n];
        init(0,0, n-1);
    }
    int init(int at, int l, int r)
    {
        a[at] = l;
        b[at] = r;
        if(l==r)
        {
            count[at] = 1;
            val[at] = aa[l];
            left[at] = right [at] = -1;
        }
        else 
        {
            int mid = (l+r)/2;
            left[at] = init(2*at+1,l,mid);
            right[at] = init(2*at+2,mid+1,r);
            val[at] = Math.min(val[left[at]], val[right[at]]);
            count[at] = 0;
            //System.out.println(l+" "+r+" "+val[left[at]]+" "+val[right[at]]+" "+count[left[at]]+" "+count[right[at]]);
            if(val[left[at]] == val[at]) count[at] += count[left[at]];
            if(val[right[at]] == val[at]) count[at] += count[right[at]];
            //System.out.println(count[at]);
        }
        return at++;
    }
    //return the min over [x,y]
    int[] get(int x, int y)
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
    int[] go(int x,int y, int at)
    {
        if(at==-1 || y<a[at] || x>b[at]) return new int[]{1987654321, 0};
        if(x <= a[at] && y>= b[at]) return new int[]{val[at], count[at]};
        push(at);
        int[] l = go(x, y, left[at]);
        int[] r = go(x, y, right[at]);
        int min = Math.min(l[0], r[0]);
        int count = 0;
        if(l[0] == r[0]) count = l[1] + r[1];
        else if(l[0] < r[0]) count = l[1];
        else count = r[1];
        return new int[]{min, count};
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
            val[at] += v;
            prop[at] += v;
            return;
        }
        push(at);
        go3(x, y, v, left[at]);
        go3(x, y, v, right[at]);
        val[at] = Math.min(val[left[at]], val[right[at]]);
        count[at] = 0;
        if(val[left[at]] == val[at]) count[at] += count[left[at]];
        if(val[right[at]] == val[at]) count[at] += count[right[at]];
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
static int[][] rmq;
static int[] aa;
static int[] memo;
static int log(int x)
{
    if(memo[x] != -1) return memo[x];
    return memo[x] = Integer.numberOfTrailingZeros(Integer.highestOneBit(x));
}
static void preprocess()
{
    int n = aa.length;
    memo = new int[n+1];
    Arrays.fill(memo, -1);
    rmq = new int[n][log(n)+1];
    for(int i = 0; i<n; i++) rmq[i][0] = aa[i];
    for(int j = 1; (1<<j) <= n; j++)
        for(int i = 0; i + (1<<j) <= n; i++)
            rmq[i][j] = gcd(rmq[i][j-1], rmq[i+(1<<(j-1))][j-1]);
}
static int query(int i, int j)
{
    int k = log(j - i + 1);
    return gcd(rmq[i][k], rmq[j-(1<<k)+1][k]);
}
static int gcd(int a, int b)
{
    return b == 0 ? a : gcd(b, a%b);
}
}