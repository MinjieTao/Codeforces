import java.util.*;
import java.io.*;
public class a {
    static int mod = 1000000007;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    String s = input.next();
    int n = s.length();
    long mult = pow(n-1);
    long tot = 0;
    long x = 1;
    for(int i =0; i<n; i++)
    {
        char c = s.charAt(n-1-i);
        if(c=='1') tot += x;
        x = (x*2)%mod;
        tot%=mod;
    }
    out.println((mult*tot)%mod);
    out.close();
}
public static long pow(int p)
{
    if(p==0) return 1;
    if(p%2 == 0)
    {
        long sqrt = pow(p/2);
        return (sqrt*sqrt)%mod;
    }
    return (2*pow(p-1))%mod;
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