import java.util.*;
import java.io.*;
public class b {
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
    }
    scc();
    //System.out.println(Arrays.toString(id));
    HashSet<Integer>[] dag = dag();
    int res = 0;
    int[] sizes = new int[count];
    for(int i = 0; i<n; i++) sizes[id[i]]++;
    //for(int i = 0; i<count; i++) if(sizes[i] > 1) res += sizes[i];
    //System.out.println(res);
    boolean[] vis = new boolean[count];
    for(int i = 0; i<count; i++)
    {
        if(vis[i]) continue;
        int size = 0;
        vis[i] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i);
        boolean flag = false;
        while(!q.isEmpty())
        {
            int at = q.poll();
            if(sizes[at] > 1) flag = true;
            size+= sizes[at];
            for(int e : dag[at])
            {
                if(vis[e]) continue;
                vis[e] = true;
                q.add(e);
            }
        }
        //System.out.println(flag+" "+size);
        res += flag ? size : size - 1;
    }
    System.out.println(res);
}
static HashSet<Integer>[] dag()
{
    HashSet<Integer>[] res = new HashSet[count];
    for(int i = 0; i<count; i++) res[i] = new HashSet<Integer>();
    for(int i = 0; i<g.length; i++)
    {
        for(int x : g[i])
            if(id[i] != id[x])
            {
                res[id[i]].add(id[x]);
                res[id[x]].add(id[i]);
            }
    }
    return res;
}
static boolean[] marked;
static int[] id, low, stk;
static int pre, count;
static void scc()
{
    id = new int[g.length]; low = new int[g.length]; stk = new int[g.length+1];
    pre = count = 0;
    marked = new boolean[g.length];
    for(int i =0; i<g.length; i++)
        if(!marked[i]) dfs(i);
}
static void dfs(int i)
{
    marked[stk[++stk[0]]=i] = true;
    int min = low[i] = pre++;
    for(int j: g[i])
    {
        if(!marked[j]) dfs(j);
        if(low[j] < min) min = low[j];
    }
    if(min < low[i]) low[i] = min;
    else
    {
        while(stk[stk[0]] != i)
        {
            int j =stk[stk[0]--];
            id[j] = count;
            low[j] = g.length;
        }
        id[stk[stk[0]--]] = count++;
        low[i] = g.length;
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