import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt();
    boolean[][] g = new boolean[n][n];
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        for(int j = 0; j<n; j++)
        {
            g[i][j] = s.charAt(j) == '1';
        }
    }
    int[] as = new int[n];
    for(int i = 0; i<n; i++) as[i] = input.nextInt();
    boolean z = false;
    for(int x: as) if(x == 0) z = true;
    if(!z)
    {
        out.println(0);
        out.close();
        return;
    }
    Queue<Integer> q = new LinkedList<Integer>();
    int[] ms = new int[n];
    for(int i = 0; i<n; i++)
    {
        if(ms[i] == as[i])
        {
            q.add(i);
            ms[i]++;
        }
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    while(!q.isEmpty())
    {
        int at = q.poll();
        res.add(at);
        for(int j = 0; j<n; j++)
        {
            if(at == j) continue;
            if(g[at][j])
            {
                ms[j]++;
                if(as[j] == ms[j])
                {
                    ms[j]++;
                    q.add(j);
                }
            }
        }
    }
    Collections.sort(res);
    out.println(res.size());
    for(int x : res) out.println(x+1);
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