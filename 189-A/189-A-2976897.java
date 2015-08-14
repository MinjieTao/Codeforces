import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for(int i = 0; i<n; i++)
    {
        if(dp[i] == -1) continue;
        if(i+a <= n) dp[i+a] = Math.max(dp[i+a], dp[i]+1);
        if(i+b <= n) dp[i+b] = Math.max(dp[i+b], dp[i]+1);
        if(i+c <= n) dp[i+c] = Math.max(dp[i+c], dp[i]+1);
    }
    System.out.println(dp[n]);
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