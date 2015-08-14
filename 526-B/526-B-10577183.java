import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int depth = input.nextInt();
    int n = (1<<(depth+1));
    int[] as = new int[n];
    for(int i = 2; i<n; i++) as[i] = input.nextInt();
    int[] paths = new int[n];
    int max = 0;
    ArrayList<Integer>[] under = new ArrayList[n];
    for(int i = 0; i<n; i++) under[i] = new ArrayList<Integer>();
    for(int i = (1<<(depth)); i < n; i++)
    {
        int cur = i;
        while(cur > 1)
        {
            under[cur].add(i);
            paths[i] += as[cur];
            cur /= 2;
        }
        max = Math.max(max, paths[i]);
    }
    int res = 0;
    for(int i = 2; i<n; i++)
    {
        int cm = 0;
        for(int x : under[i]) cm = Math.max(cm, paths[x]);
        int diff = max - cm;
        res += diff;
        for(int x : under[i]) paths[x] += diff;
    }
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