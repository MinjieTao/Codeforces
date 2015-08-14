import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), min = input.nextInt(), max = input.nextInt();
    int a = 101, b = 0;
    for(int i = 0; i<m; i++)
    {
        int x = input.nextInt();
        a = Math.min(a, x);
        b = Math.max(b, x);
    }
    boolean good = true;
    if(a < min || b > max) good = false;
    if(n == m + 1 && (a != min && b != max)) good = false;
    out.println(good ? "Correct" : "Incorrect");
    out.close();
}
static int go(int n)
{
    if(n%4 == 0) return n;
    if(n%4 == 1) return 1;
    if(n%4 == 2) return n+1;
    return 0;
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