import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    IT it = new IT(n, data);
    int m = input.nextInt();
    input.nextLine();
    for(int i = 0; i<m; i++)
    {
        String[] query = input.nextLine().split(" ");
        int a = Integer.parseInt(query[0]), b = Integer.parseInt(query[1]);
        if(query.length == 2)
        {
            out.println(it.get(a,  b));
        }
        else
        {
            int v = Integer.parseInt(query[2]);
            it.add(a, b, v);
        }
        
    }
    out.close();
}
static class IT
{
    int[] left,right, val, a, b, prop;
    int n;
    IT(int nn, int[] data)
    {
        n = nn;
        left = new int[4*n];
        right = new int[4*n];
        val = new int[4*n];
        prop = new int[4*n];
        a = new int[4*n];
        b = new int[4*n];
        init(0,0, n-1, data);
    }
    int init(int at, int l, int r, int[] data)
    {
        a[at] = l;
        b[at] = r;
        if(l==r)
        {
            val[at] = data[l];
            left[at] = right [at] = -1;
        }
        else 
        {
            int mid = (l+r)/2;
            left[at] = init(2*at+1,l,mid, data);
            right[at] = init(2*at+2,mid+1,r, data);
            val[at] = Math.min(val[left[at]], val[right[at]]);
        }
        return at++;
    }
    //return the min over [x,y]
    int get(int x, int y)
    {
        if(x <= y) return go(x,y, 0);
        else return Math.min(go(x, n-1, 0), go(0, y, 0));
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
        if(at==-1 || y<a[at] || x>b[at]) return 987654321;
        if(x <= a[at] && y>= b[at]) return val[at];
        push(at);
        return Math.min(go(x, y, left[at]), go(x, y, right[at]));
    }
    //add v to elements x through y
    void add(int x, int y, int v)
    {
        if(x <= y)
            go3(x, y, v, 0);
        else
        {
            go3(x, n-1, v, 0);
            go3(0, y, v, 0);
        }
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