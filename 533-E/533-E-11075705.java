import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    String s = input.next(), t = input.next();
    System.out.println(go(s, t) + go(t, s));
}
static int go(String s, String t)
{
    int n = s.length();
    int a = 0, b = n - 1;
    while(a < n && s.charAt(a) == t.charAt(a)) a++;
    while(b >= 0 && s.charAt(b) == t.charAt(b)) b--;
    //a++;
    while(a < n-1 && s.charAt(a+1) == t.charAt(a)) a++;
    //b--;
    if(a >= b) return 1;
    //System.out.println(a+" "+b);
    for(int i = a; i<=b; i++) if(s.charAt(i) != t.charAt(i)) return 0;
    return 1;
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