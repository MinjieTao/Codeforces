import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
    public static int mod = 1000000007;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    int[] array = array(s);
    int[] bytemax = array("127");
    int[] shortmax = array("32767");
    int[] intmax = array("2147483647");
    int[] longmax = array("9223372036854775807");
    if(compare(array, bytemax) <= 0) System.out.println("byte");
    else if(compare(array, shortmax) <= 0) System.out.println("short");
    else if(compare(array, intmax) <= 0) System.out.println("int");
    else if(compare(array, longmax) <= 0) System.out.println("long");
    else System.out.println("BigInteger");
}
public static int[] array(String s)
{
    int[] res = new int[s.length()];
    for(int i = 0; i<s.length(); i++)
        res[i] = s.charAt(i)-'0';
    return res;
}
public static int compare(int[] a, int[] b)
{
    if(a.length > b.length)
        return 1;
    if(b.length > a.length)
        return -1;
    for(int i =0; i<a.length; i++)
        if(a[i] > b[i]) return 1;
        else if(b[i] > a[i]) return -1;
    return 0;
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