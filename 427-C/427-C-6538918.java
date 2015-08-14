import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
    }
    scc();
    int[] mins = new int[count], counts = new int[count];
    Arrays.fill(mins, 1987654321);
    for(int i =0; i<n; i++)
    {
        int x = id[i];
        if(data[i] < mins[x])
        {
            mins[x] = data[i];
            counts[x] = 1;
        }
        else if(data[i] == mins[x]) counts[x]++;
    }
    long sum = 0, ways = 1;
    for(int i = 0; i<count; i++)
    {
        sum += mins[i];
        ways = (ways * counts[i]) % 1000000007;
    }
    System.out.println(sum+" "+ways);
}
/*
 * Tarjan's Strongly Connected Componenets - O(n)
 * Initialize g beforehand.
 * After it's run, id will have SCC's in reverse topological order
 * Indices with same id represent nodes in same SCC
 */
static ArrayList<Integer>[] g;
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