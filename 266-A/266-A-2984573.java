import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    String s = input.next();
    for(int i = 0; i<s.length()-1; i++)
    {
        if(s.charAt(i) == s.charAt(i+1))
        {
            s = s.substring(0, i)+s.substring(i+1);
            i--;
        }
    }
    System.out.println(n-s.length());
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