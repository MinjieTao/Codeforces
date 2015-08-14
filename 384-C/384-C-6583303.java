import java.util.*;
import java.io.*;
public class aa {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
    }
    long left = 0, right = 0;
    int count = 0;
    for(int i = n-1; i>=0; i--)
    {
        if(data[i] == 0) count++;
        else right += count;
    }
    count = 0;
    for(int i = 0; i<n; i++)
    {
        if(data[i] == 1) count++;
        else left += count;
    }
    out.println(Math.min(left, right));
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