import java.io.*;
import java.util.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n =input.nextInt(), m = input.nextInt();
    int[][] data = new int[n][m];
    for(int i =0; i<n; i++)
    {
        String s = input.next();
        for(int j = 0; j<m; j++)
            data[i][j] = s.charAt(j) - '0';
    }
    int[][] dp = new int[n][m];
    for(int i = 0; i<n; i++)
    {
        for(int j = m-1; j>=0; j--)
        {
            if(j == m-1) dp[i][j] = data[i][j];
            else dp[i][j] = (data[i][j] == 1) ? 1 + dp[i][j+1] : 0;
        }
    }
    int res = 0;
    for(int j = 0; j<m; j++)
    {
        int[] sizes = new int[n];
        for(int i = 0; i<n; i++)
            sizes[i] = dp[i][j];
        Arrays.sort(sizes);
        for(int k = n-1; k>=0; k--)
        {
            int cur = (n-1-k+1)*(sizes[k]);
            res = Math.max(res, cur);
        }
    }
    System.out.println(res);
    
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