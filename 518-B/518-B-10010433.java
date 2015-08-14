import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    String s = input.next(), t = input.next();
    int[] fs = f(s), ft = f(t);
    int y = 0;
    for(int i = 0; i<256; i++)
    {
        int min = Math.min(fs[i], ft[i]);
        y += min;
        fs[i] -= min;
        ft[i] -= min;
    }
    int w = 0;
    for(int i = 0; i<256; i++)
    {
        for(int j = 0; j<256; j++)
        {
            if(i >= 'a' && i <= 'z' && j == ('A' + i - 'a'))
            {
                int min = Math.min(fs[i], ft[j]);
                w += min;
                fs[i] -= min;
                ft[j] -= min;
            }
            if(i >= 'A' && i <= 'Z' && j == ('a' + i - 'A'))
            {
                int min = Math.min(fs[i], ft[j]);
                w += min;
                fs[i] -= min;
                ft[j] -= min;
            }
        }
    }
    out.println(y+" "+w);
    out.close();
}
static int[] f(String s)
{
    int[] res = new int[256];
    for(int i = 0; i<s.length(); i++) res[s.charAt(i)]++;
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