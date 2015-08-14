import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    int[] ss = new int[n], ms = new int[n];
    for(int i = 0; i<n; i++)
    {
        ss[i] = input.nextInt();
        ms[i] = input.nextInt();
    }
    PriorityQueue<Long> pq = new PriorityQueue<Long>();
    for(int i = 0; i<n; i++)
    {
        long start = Math.max(ss[i], pq.size() < k ? 0 : pq.poll());
        long end = start + ms[i];
        out.println(end);
        pq.add(end);
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