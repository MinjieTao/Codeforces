import java.util.*;
import java.io.*;
public class bb {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] as = new int[n], bs = new int[n];
    for(int i =0; i<n; i++)
    {
        as[i] = input.nextInt();
        bs[i] = input.nextInt();
    }
    boolean[] awin = new boolean[n], bwin = new boolean[n];
    int ata = 0, atb = 0;
    for(int i= 0; i<n; i++)
    {
        if(as[ata] < bs[atb]) awin[ata++] = true;
        else bwin[atb++] = true;
    }
    for(int i = 0; i<n/2; i++)
    {
        awin[i] = bwin[i] = true;
    }
    if(n%2 == 1)
    {
        if(as[n/2] < bs[n/2]) awin[n/2] = true;
        else bwin[n/2] = true;
    }
    for(int i = 0; i<n; i++) out.print(awin[i] ? 1 : 0);
    out.println();
    for(int i = 0; i<n; i++) out.print(bwin[i] ? 1 : 0);
    out.println();
    
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