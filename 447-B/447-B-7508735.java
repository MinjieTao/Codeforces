import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    int k = input.nextInt();
    int[] data = new int[26];
    for(int i = 0; i<26; i++) data[i] = input.nextInt();
    int res = 0, max = 0;
    for(int i = 0; i<26; i++) max = Math.max(max, data[i]);
    for(int i = 0; i<s.length(); i++) res += (i+1) * (data[s.charAt(i) - 'a']);
    for(int i = 0; i<k; i++) res += max * (i+1+s.length());
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