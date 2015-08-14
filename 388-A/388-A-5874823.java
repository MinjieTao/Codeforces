import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] a = new int[n];
    for(int i = 0; i<n; i++) a[i] = input.nextInt();
    Arrays.sort(a);
    int res = 0;
    boolean[] mark = new boolean[n];
    int count = 0;
    for(int i = 0; i<n; i++)
    {
        if(count == n) break;
        res++;
        int last = -1;
        for(int j = 0; j<n; j++)
        {
            if(mark[j]) continue;
            if(a[j] == last) continue;
            mark[j] = true;
            count++;
            last++;
        }
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