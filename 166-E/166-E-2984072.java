import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
    public static int mod = 1000000007;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    long[][] dp = new long[2][4];
    dp[0][0] = 1;
    for(int i = 1; i<=n; i++)
    {
        long sum = (dp[1-i&1][0] + dp[1-i&1][1] + dp[1-i&1][2] + dp[1-i&1][3]);
        for(int j = 0; j<4; j++)
        {
            dp[i&1][j] = (int)((sum - dp[1-i&1][j])%mod);
        }
    }
    System.out.println(dp[n&1][0]);
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