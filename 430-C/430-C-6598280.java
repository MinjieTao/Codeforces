import java.util.*;
import java.io.*;
public class a {
    static ArrayList<Integer>[] tree;
    static int[] start, goal;
    static int[] level;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    ArrayList<Integer>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }
    Queue<Integer> q = new LinkedList<Integer>();
    boolean[] vis = new boolean[n];
    vis[0] = true;
    q.add(0);
    tree = new ArrayList[n];
    for(int i = 0; i<n; i++) tree[i] = new ArrayList<Integer>();
    level = new int[n];
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int e: g[at])
        {
            if(vis[e]) continue;
            level[e] = 1-level[at];
            vis[e] = true;
            q.add(e);
            tree[at].add(e);
        }
    }
    start = new int[n];
    goal = new int[n];
    for(int i = 0; i<n; i++) start[i] = input.nextInt();
    for(int i = 0; i<n; i++) goal[i] = input.nextInt();
    res = new ArrayList<Integer>();
    go(0, false, false);
    out.println(res.size());
    for(int x: res)
        out.println(x);
    out.close();
}
static ArrayList<Integer> res;
static void go(int at, boolean flipOdd, boolean flipEven)
{
    int cur = start[at];
    if(level[at] == 0 && flipEven) cur ^= 1;
    if(level[at] == 1 && flipOdd) cur ^= 1;
    if(cur == goal[at])
    {
        for(int e: tree[at])
            go(e, flipOdd, flipEven);
    }
    else
    {
        res.add(at+1);
        boolean nOdd = flipOdd;
        boolean nEven = flipEven;
        if(level[at] == 0) nEven = !nEven;
        else nOdd = !nOdd;
        for(int e: tree[at]) go(e, nOdd, nEven);
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