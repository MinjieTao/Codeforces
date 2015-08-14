import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int m = input.nextInt();
    int[] qs = new int[m];
    for(int i =0; i<m; i++) qs[i] = input.nextInt();
    int n = input.nextInt();
    int[] ps = new int[n];
    for(int i =0; i<n; i++) ps[i] = input.nextInt();
    Arrays.sort(qs);
    Arrays.sort(ps);
    int bestq = qs[0];
    int mod = 0;
    long res = 0;
    for(int i = n-1; i>=0; i--)
    {
        int cur = ps[i];
        if(mod < bestq)
            res += cur;
        mod++;
        mod%=(bestq+2);
    }
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