import java.util.*;
import java.io.*;
public class D196 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt(), d = input.nextInt();
    ArrayList<Integer>[] g = new ArrayList[n], tree = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) tree[i] = new ArrayList<Integer>();
    int[] below = new int[n], above = new int[n];
    Arrays.fill(below, -987654321);
    Arrays.fill(above, -987654321);
    for(int i = 0; i<m; i++)
    {
        int x = input.nextInt()-1;
        below[x] = above[x] = 0;
    }
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }
    int[] ps = new int[n];
    Arrays.fill(ps, -1);
    ps[0] = -2;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    while(!q.isEmpty())
    {
        int at = q.poll();
        //System.out.println(at+" "+ps[at]);
        for(int e : g[at])
        {
            if(e == ps[at]) continue;
            ps[e] = at;
            q.add(e);
            tree[at].add(e);
        }
    }
    g = tree;
    
    int[] degs = new int[n];
    for(int i = 0; i<n; i++) degs[i] = g[i].size();
    for(int i = 0; i<n; i++)
    {
        if(degs[i] == 0) q.add(i);
    }
    while(!q.isEmpty())
    {
        int at = q.poll();
        if(ps[at] < 0) break;
        degs[ps[at]]--;
        if(degs[ps[at]] == 0) q.add(ps[at]);
        if(below[at] >= 0) below[ps[at]] = Math.max(below[ps[at]], 1 + below[at]);
    }
    q.add(0);
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int x : g[at])
        {
            above[x] = Math.max(above[x], 1 + above[at]);
            q.add(x);
        }
        int max = -987654321, max2 = -987654321;
        int maxi = -1;
        for(int e : g[at])
        {
            int cur = 2 + below[e];
            if(cur > max)
            {
                max2 = max;
                max = cur;
                maxi = e;
            }
            else if(cur > max2) max2 = cur;
        }
        for(int e : g[at])
        {
            if(e == maxi)
            {
                above[e] = Math.max(above[e], max2);
            }
            else above[e] = Math.max(above[e], max);
        }
    }
    
    
    PrintWriter out = new PrintWriter(System.out);
    //out.println(Arrays.toString(below));
    //out.println(Arrays.toString(above));
    int count = 0;
    for(int i = 0; i<n; i++)
        if(below[i] <= d && above[i] <= d)
            count++;
    out.println(count);
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
}