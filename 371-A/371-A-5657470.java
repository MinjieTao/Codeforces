import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int res = 0;
    for(int i =0; i<k; i++)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int j = i; j<n; j+=k) set.add(data[j]);
        int max = 1;
        for(int x: set)
        {
            int count = 0;
            for(int j = i; j<n; j+=k)
            {
                if(data[j] == x) count++;
            }
            max = Math.max(max, count);
        }
        res += (n/k) - max;
    }
    out.println(res);
    
    out.close();
}
static class Edge
{
    int to, d;
    public Edge(int tt, int dd)
    {
        to = tt;
        d = dd;
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