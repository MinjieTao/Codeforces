import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] as = new int[n];
    int[] bs = new int[n-1];
    int[] cs = new int[n-2];
    for(int i = 0; i<n; i++) as[i] = input.nextInt();
    for(int i = 0; i<n-1; i++) bs[i] = input.nextInt();
    for(int i = 0; i<n-2; i++) cs[i] = input.nextInt();
    Arrays.sort(as);
    Arrays.sort(bs);
    Arrays.sort(cs);
    for(int i = 0; i<n; i++)
    {
        if(i == n-1 || as[i] != bs[i])
        {
            System.out.println(as[i]);
            break;
        }
    }
    for(int i = 0; i<n-1; i++)
    {
        if(i == n-2 || bs[i] != cs[i])
        {
            System.out.println(bs[i]);
            break;
        }
    }
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