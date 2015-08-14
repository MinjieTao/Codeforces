import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    //Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    ArrayList<Edge>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Edge>();
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, t = input.nextInt();
        boolean v = t == 2;
        g[a].add(new Edge(b, v));
        g[b].add(new Edge(a, v));
    }
    int[] ps = new int[n];
    boolean[] need = new boolean[n];
    Arrays.fill(ps, -2);
    ps[0] = -1;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    ArrayList<Integer>[] children = new ArrayList[n];
    for(int i =0; i<n; i++) children[i] = new ArrayList<Integer>();
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(Edge e: g[at])
        {
            int next = e.to;
            if(ps[next] != -2) continue;
            children[at].add(next);
            ps[next] = at;
            need[next] = e.v;
            q.add(next);
        }
    }
    Queue<Integer> cs = new LinkedList<Integer>();
    for(int i = 0; i<n; i++)
    {
        if(children[i].size() == 0)
        {
            cs.add(i);
        }
    }
    boolean[] mark = new boolean[n];
    ArrayList<Integer> list = new ArrayList<Integer>();
    int res = 0;
    int[] left = new int[n];
    for(int i = 0; i<n; i++) left[i] = children[i].size();
    boolean[] process = new boolean[n];
    while(!cs.isEmpty())
    {
        int at = cs.poll();
        if(left[at] != 0) continue;
        if(process[at]) continue;
        process[at] = true;
        if(need[at])
        {
            int cur = at;
            if(!mark[at])
            {
                res++;
                list.add(at+1);
            }
            while(cur != 0)
            {
                if(mark[cur]) break;
                mark[cur] = true;
                cur = ps[cur];
            }
        }
        if(at != 0)
        {
            cs.add(ps[at]);
        }
        if(at != 0) left[ps[at]]--;
    }
    out.println(res);
    for(int x: list) out.println(x);
    out.close();
}
static class Edge
{
    int to;
    boolean v;
    public Edge(int tt, boolean vv)
    {
        to = tt;
        v = vv;
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