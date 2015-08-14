import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    int n = s.length();
    double[] csum = new double[n];
    for(int i = 0; i<n; i++) csum[i] = i == 0 ? 1 : csum[i-1] + 1. / (i+1);
    double[] dp = new double[n];
    dp[0] = csum[n-1];
    for(int i = 1; i<n; i++) dp[i] = dp[i-1] - csum[i-1] + csum[n-i-1];
    double res = 0;
    for(int i = 0; i<n; i++)
    {
        char c = s.charAt(i);
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y')
            res += dp[i];
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