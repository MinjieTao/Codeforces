import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] dp1 = new int[n], dp2 = new int[n];
    dp1[0] = dp2[n-1] = 1;
    for(int i = 1; i<n; i++) if(data[i] > data[i-1]) dp1[i] = 1 + dp1[i-1]; else dp1[i] = 1;
    for(int i = n-2; i>=0; i--) if(data[i] < data[i+1]) dp2[i] = 1 + dp2[i+1]; else dp2[i] = 1;
    int res = 1;
    for(int i = 0; i<n; i++)
    {
        int left = i == 0 ? 0 : dp1[i-1];
        int right = i == n-1 ? 0 : dp2[i+1];
        res = Math.max(res, 1+left);
        res = Math.max(res, 1+right);
        if(i != 0 && i != n-1 && data[i+1] < 2 + data[i-1]) continue;
        res = Math.max(res, 1 + left + right);
    }
    out.println(res);
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