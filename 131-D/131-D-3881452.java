import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    boolean[][] adj = new boolean[n][n];
    int[] as = new int[n], bs = new int[n];
    for(int i = 0; i<n; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        as[i]=a; bs[i]=b;
        adj[a][b] = adj[b][a] = true;
    }
    int[] parent = new int[n];
    Arrays.fill(parent, -2);
    parent[0] = -1;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int i = 0; i<n; i++)
            if(adj[at][i] && parent[i] == -2)
            {
                parent[i] = at;
                q.add(i);
            }
    }
    HashSet<Integer> cycle = new HashSet<Integer>();
    int x1 = 0, x2 = 0;
    for(int i = 0; i<n; i++)
    {
        if(as[i] != parent[bs[i]] && bs[i] != parent[as[i]])
        {
            cycle.add(x1=as[i]);
            cycle.add(x2=bs[i]);
        }
    }
    int d1 = 0, d2 = 0, at1 = x1, at2 = x2;
    while(at1>0)
    {
        at1 = parent[at1];
        d1++;
    }
    while(at2>0)
    {
        at2 = parent[at2];
        d2++;
    }
    at1 = x1; at2 = x2;
    while(true)
    {
        if(at1 == at2)
        {
            cycle.add(at1);
            break;
        }
        if(d1 >= d2)
        {
            cycle.add(at1);
            at1 = parent[at1];
            d1--;
        }
        else
        {
            cycle.add(at2);
            at2 = parent[at2];
            d2--;
        }
    }
    int[] visited = new int[n];
    Arrays.fill(visited, -1);
    for(int x: cycle)
    {
        visited[x] = 0;
        q.add(x);
    }
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int i = 0; i<n; i++)
            if(adj[at][i] && visited[i] == -1)
            {
                visited[i] = 1 + visited[at];
                q.add(i);
            }
    }
    for(int i = 0; i<n; i++)
        out.print(visited[i]+" ");
    
    
    out.close();
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