import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String s = input.next();
    int n = s.length();
    char[] res = new char[n];
    int[] flip = new int[n];
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        flip[input.nextInt()-1] ^= 1;
    }
    boolean b = false;
    for(int i = 0; i<= n/2; i++)
    {
        b ^= (flip[i] > 0);
        char c = s.charAt(i), c2 = s.charAt(n-1-i);
        res[i] = c;
        res[n-1-i] = c2;
        if(b)
        {
            res[i] = c2;
            res[n-1-i] = c;
        }
    }
    out.println(new String(res));
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