import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    if(n < 4)
    {
        out.println("NO");
        out.close();
        return;
    }
    out.println("YES");
    if(n%2 == 0)
    {
        out.println("2 * 3 = 6");
        out.println("6 * 4 = 24");
        for(int i = 5; i<n; i+=2)
        {
            out.println((i+1) +" - "+i+" = 1");
            out.println("24 * 1 = 24");
        }
        out.println("24 * 1 = 24");
    }
    else
    {
        out.println("5 - 1 = 4");
        out.println("4 - 2 = 2");
        out.println("4 * 3 = 12");
        out.println("12 * 2 = 24");
        for(int i = 6; i<n; i+=2)
        {
            out.println((i+1) +" - "+i+" = 1");
            out.println("24 * 1 = 24");
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