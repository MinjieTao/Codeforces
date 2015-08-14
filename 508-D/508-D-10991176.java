import java.util.*;
import java.io.*;
public class D288 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    g = new ArrayList[256*256];
    for(int i = 0; i<g.length; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++)
    {
        char[] cs = input.next().toCharArray();
        g[(cs[0])*256+cs[1]].add(cs[1]*256+cs[2]);
        //g[(cs[1])*256+cs[2]].add(cs[0]*256+cs[1]);
    }
    ArrayList<Integer> path = eulerPath();
    if(path == null) out.println("NO");
    else
    {
        out.println("YES");
        out.print(new String(decode(path.get(0))));
        for(int i = 1; i<path.size(); i++) out.print(decode(path.get(i))[1]);
        out.println();
    }
    out.close();
}
static char[] decode(int x)
{
    return new char[]{(char)(x/256), (char)(x%256)};
}
static int[] ptrs;
static ArrayList<Integer>[] g, rev;
static ArrayList<Integer> eulerPath;
static ArrayList<Integer> eulerPath()
{
    int n = g.length;
    rev = new ArrayList[n];
    for(int i = 0; i<n; i++) rev[i] = new ArrayList<Integer>();
    eulerPath = new ArrayList<Integer>();
    int start = 0;
    int[] in = new int[n], out = new int[n];
    int diff = 0, edges = 0;
    for(int i = 0; i<n; i++)
    {
        edges += in[i] = g[i].size();
        for(int e : g[i])
        {
            rev[e].add(i);
            out[e]++;
        }
    }
    while(out[start] == 0) start++;
    for(int i = 0; i<n; i++)
    {
        if(out[i] > in[i]) start = i;
        diff += Math.abs(in[i] - out[i]);
    }
    if(diff > 2) return null;
    ptrs = new int[n];
    dfs(start);
    eulerPath.add(start);
    if(eulerPath.size() < edges + 1) return null;
    return eulerPath;
}
static void dfs(int at)
{
    while(ptrs[at] < rev[at].size())
    {
        int p = ptrs[at];
        dfs(rev[at].get(ptrs[at]++));
        eulerPath.add(rev[at].get(p));
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