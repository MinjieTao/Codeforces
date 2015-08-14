import java.util.*;
import java.io.*;
public class e {
    static ArrayList<Integer> start, end;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    g = new ArrayList[n];
    for(int  i= 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i =0; i<n; i++) g[i].add(input.nextInt()-1);
    int[] in = new int[n];
    for(int i = 0; i<n; i++)
    {
        in[g[i].get(0)]++;
    }
    start = new ArrayList<Integer>(); end = new ArrayList<Integer>();
    boolean[] visited = new boolean[n];
    boolean found = false;
    for(int i = 0; i<n; i++)
    {
        if(in[i] == 0)
        {
            found = true;
            visited[i] = true;
            int at = i;
            start.add(i);
            while(true)
            {
                int next = g[at].get(0);
                if(visited[next])
                {
                    end.add(at);
                    break;
                }
                else
                {
                    visited[next] = true;
                    at = next;
                }
            }
        }
    }
    int cc = 0;
    for(int i = 0; i<n; i++)
    {
        if(visited[i]) continue;
        cc++;
        visited[i] = true;
        int at = i;
        start.add(i);
        end.add(i);
        while(true)
        {
            int next = g[at].get(0);
            if(visited[next])
                break;
            else
            {
                visited[next] = true;
                at = next;
            }
        }
    }
    if(!found && cc == 1) out.println(0);
    else
    {
        int res = end.size();
        out.println(res);
        for(int i = 0; i<res; i++)
            out.println((1+end.get(i)) + " " + (1+start.get((i+1)%res)));
    }
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