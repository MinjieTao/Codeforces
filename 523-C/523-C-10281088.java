import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next(), t = input.next();
    int a = first(s, t), b = last(s, t);
    int res = 0;
    if(a > -1 && b > -1 && b > a) res = b-a;
    System.out.println(res);
}
static int first(String s, String t)
{
    int pos = 0;
    int i = 0;
    for(i = 0; i<t.length() && pos < s.length(); i++)
    {
        if(t.charAt(i) == s.charAt(pos))
        {
            pos++;
        }
    }
    return pos == s.length() ? i - 1 : -1;
}
static int last(String s, String t)
{
    int pos = s.length()-1;
    int i = t.length()-1;
    for(i = t.length()-1; i >= 0 && pos >= 0; i--)
    {
        if(t.charAt(i) == s.charAt(pos)) pos--;
    }
    return pos == -1 ? i + 1 : -1;
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