import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    long mod = (long)(1e9+7);
    input.init(System.in);
    int[] fs = new int[26];
    int n =input.nextInt();
    String s = input.next();
    for(int i = 0; i<s.length(); i++)
    {
        fs[s.charAt(i) - 'A']++;
    }
    int max = 0;
    for(int x : fs) max = Math.max(max, x);
    int count = 0;
    for(int x : fs) if(x == max) count++;
    long res = 1;
    for(int i = 0; i<n; i++)
    {
        res = (res * count)%mod;
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