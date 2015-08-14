import java.io.*;
import java.util.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n= input.nextInt();
    StringBuilder str = new StringBuilder("<3");
    for(int i = 0; i<n; i++) str.append(input.next()+"<3");
    String s = str.toString();
    n = s.length();
    String t = input.next();
    int at = 0;
    for(int i = 0; i<t.length(); i++)
    {
        if(at==n) break;
        if(s.charAt(at) == t.charAt(i)) at++;
    }
    System.out.println(at==n ? "yes" :"no");
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