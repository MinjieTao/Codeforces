import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[][] adj = new int[201][201];
    boolean[] has = new boolean[201];
    for(int i = 0; i<n*(n-1)/2; i++)
    {
        int k = input.nextInt();
        int[] data = new int[k];
        for(int j = 0; j<k; j++)
        {
            data[j] = input.nextInt();
            has[data[j]] = true;
        }
        for(int j = 0; j<k; j++)
            for(int m = j+1; m<k; m++)
            {
                adj[data[j]][data[m]]++;
                adj[data[m]][data[j]]++;
            }
    }
    ArrayList<Integer>[] res = new ArrayList[n];
    for(int i = 0; i<n; i++) res[i] = new ArrayList<Integer>();
    int at = 0;
    for(int i = 1; i<=200; i++)
    {
        if(!has[i]) continue;
        has[i] = false;
        res[at].add(i);
        for(int j = 1; j<=200; j++)
        {
            if(adj[i][j] > 1 && has[j])
            {
                has[j] = false;
                res[at].add(j);
            }
        }
        if(at != n-1)
        at++;
    }
    for(int i =0; i<n; i++)
    {
        out.print(res[i].size());
        for(int j = 0; j<res[i].size(); j++)
            out.print(" "+res[i].get(j));
        out.println();
    }
    out.close();
}
static class Soldier implements Comparable<Soldier> {
    int b, i;
    public Soldier(int bb, int ii)
    {
        b = bb; i = ii;
    }
    @Override
    public int compareTo(Soldier that) {
        // TODO Auto-generated method stub
        return that.b - this.b;
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