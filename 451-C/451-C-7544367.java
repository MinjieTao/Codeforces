import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int T = input.nextInt();
    for(int t = 0; t<T; t++)
    {
        long n = input.nextLong(), k = input.nextLong(), d1 = input.nextLong(), d2 = input.nextLong();
        if(n%3 != 0) out.println("no");
        else
        {
            if(k >= 2*d1 + d2 && (k-2*d1-d2)%3 == 0 && d1+d2+(k-2*d1-d2)/3 <= n/3) out.println("yes");
            else if(k >= d1 + 2*d2 && (k-d1-2*d2)%3 == 0 && d1+d2+(k-d1-2*d2)/3 <= n/3) out.println("yes");
            else if(k >= d1 + d2 && (k-d1-d2)%3 == 0 && Math.max(d1, d2) + (k-d1-d2)/3 <= n/3) out.println("yes");
            else if(k >= 2*Math.max(d1, d2)-Math.min(d1, d2) && (k-2*Math.max(d1, d2)+Math.min(d1, d2))%3 == 0 && Math.max(d1, d2) + (k-2*Math.max(d1, d2)+Math.min(d1, d2))/3 <= n/3) out.println("yes");
            else out.println("no");
        }
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