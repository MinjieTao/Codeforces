import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
    public static int mod = 1000000007;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n= input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
        data[i] = input.nextInt();
    int res = Math.min(data[0], data[n-1]);
    for(int i = 0; i<n-1; i++)
        res = Math.min(res, Math.max(data[i], data[i+1]));
    System.out.println(res);
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