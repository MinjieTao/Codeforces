import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    
    int n = input.nextInt();
    int height = n;
    int res = 0;
    for(int i = 1; i<=n; i++)
    {
        int y = (int)Math.sqrt((long)n*n - (long)i*i);
        if(y == height) res++;
        else res += (height - y);
        height = y;
    }
    if(n == 0) out.println(1);
    else out.println(4*res);
    
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