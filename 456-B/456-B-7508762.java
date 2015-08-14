import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    int pow = s.charAt(s.length()-1) - '0';
    if(s.length() > 1) pow += 10 * s.charAt(s.length() -2) - '0';
    pow %= 4;
    int res = 0;
    for(int i = 1; i<=4; i++)
    {
        int cur = 1;
        for(int j = 0; j<pow; j++) cur = (cur * i)%5;
        res = (res+cur)%5;
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