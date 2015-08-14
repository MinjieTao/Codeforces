import java.util.*;
import java.io.*;
public class aa {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    
    int[] sieve = new int[10000001];
    for(int i = 0; i<sieve.length; i++) sieve[i] = i;
    for(int  i= 2; i < sieve.length; i++)
    {
        if(sieve[i] != i) continue;
        for(long j = (long)i*i; j<sieve.length; j+=i) sieve[(int)j] = i;
    }
    int[] count = new int[10000001];
    for(int i = 0; i<n; i++)
    {
        while(data[i] > 1)
        {
            int p = sieve[data[i]];
            count[p]++;
            while(data[i] % p == 0) data[i] /= p;
        }
    }
    for(int i = 1; i<count.length; i++) count[i] += count[i-1];
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        if(a > b || a > 10000000)
        {
            out.println(0);
            continue;
        }
        b = Math.min(b, 10000000);
        out.println(count[b] - count[a-1]);
    }
    
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