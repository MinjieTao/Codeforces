import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt(), m = input.nextInt(), x = input.nextInt() & 3, y = input.nextInt() & 3, z = input.nextInt() & 3, p = input.nextInt();
    int[] rs = new int[p], cs = new int[p];
    for(int i = 0; i<p; i++)
    {
        rs[i] = input.nextInt()-1;
        cs[i] = input.nextInt()-1;
    }
    for(int i =0; i<x; i++)
    {
        int tmp = n; n = m; m = tmp;
        for(int j = 0; j<p; j++)
        {
            int c = m - 1 - rs[j], r = cs[j];
            cs[j] = c; rs[j] = r;
        }
    }
    for(int i = 0; i<y; i++)
        for(int j = 0; j<p; j++)
            cs[j] = m - 1 - cs[j];
    for(int i = 0; i<z; i++)
    {
        int tmp = n; n = m; m = tmp;
        for(int j = 0; j<p; j++)
        {
            int c = rs[j], r = n - 1 - cs[j];
            cs[j] = c; rs[j] = r;
        }
    }
    for(int i = 0; i<p;i++) out.println((rs[i]+1)+" "+(cs[i]+1)); 
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