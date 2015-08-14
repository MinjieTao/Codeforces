import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    long p = input.nextLong(), d = input.nextLong();
    long x = 1;
    long best = p;
    for(int i = 0; i<18; i++)
    {
        long at = x*((p+1)/x)-1;
        //System.out.println(at);
        if(at >= 0 && p-at <= d) best = at;
        x*=10;
    }
    System.out.println(best);
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