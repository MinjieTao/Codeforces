import java.util.*;
import java.io.*;
public class a {
    static int length;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next(), t = input.next();
    length = Math.max(s.length(), t.length())+1;
    char[] a = reduce(s), b = reduce(t);
    int res = (new String(a)).compareTo(new String(b));
    if(res == 0) System.out.println("=");
    else if(res < 0) System.out.println("<");
    else System.out.println(">");
}
static char[] reduce(String s)
{
    char[] res = new char[length];
    Arrays.fill(res, '0');
    for(int i = 0; i<s.length(); i++) res[length-1-i] = s.charAt(s.length()-1-i);
    for(int i = 1; i<length-1; i++)
    {
        if(i > 0 && res[i] == '1' && res[i+1] == '1')
        {
            res[i] = res[i+1] = '0';
            res[i-1]++;
            i-=3;
        }
    }
    return res;
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