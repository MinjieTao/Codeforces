import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    long k = input.nextLong();
    long[] f = new long[n+1];
    f[0] = 1;
    f[1] = 1;
    for(int i = 2; i<=n; i++) f[i] = f[i-1] + f[i-2];
    //System.out.println(Arrays.toString(f));
    int[] p = new int[n];
    for(int i = 0; i<n; i++) p[i] = i;
    for(int i = 0; i<n-1; i++)
    {
        int cur = n - i;
        //System.out.println(f[cur-1]+" "+k+" "+i);
        if(f[cur-1] >= k) continue;
        else
        {
            k -= f[cur-1];
            int temp = p[i];
            p[i] = p[i+1];
            p[i+1] = temp;
            i++;
        }
    }
    
    for(int i = 0; i<n; i++) out.print((p[i]+1)+" ");
    
    
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