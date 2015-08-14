import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    ArrayList<Integer>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }
    int count = 0;
    boolean[] vis = new boolean[n];
    for(int i = 0; i<n; i++)
    {
        if(vis[i]) continue;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i);
        vis[i] = true;
        count++;
        while(!q.isEmpty())
        {
            int at = q.poll();
            for(int x: g[at])
            {
                if(vis[x]) continue;
                vis[x] = true;
                q.add(x);
            }
        }
    }
    long res = 1l << (n - count);
    out.println(res);
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