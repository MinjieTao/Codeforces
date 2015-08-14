import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] as = new int[n], bs = new int[m];
    for(int i = 0; i<n; i++) as[i] = input.nextInt();
    for(int i = 0; i<m; i++) bs[i] = input.nextInt();
    System.out.println(Math.min(go(as, bs), go(bs, as)));
}
static long go(int[] a, int[] b)
{
    long sum = 0;
    for(int x : b) sum += x;
    long res = 0;
    int max = 0;
    for(int i = 0; i<a.length; i++)
    {
        max = Math.max(max, a[i]);
        res += Math.min(a[i], sum);
    }
    return res + sum - Math.min(max,  sum);
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