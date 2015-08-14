import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    int mod = 1000000007;
    input.init(System.in);
    long x = input.nextInt(), y = input.nextInt(), n = input.nextInt();
    long[] data = new long[]{x, y, y+mod-x, mod-x, mod-y, x+mod-y};
    System.out.println((5l*mod+data[(int)(n-1)%6])%mod);
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