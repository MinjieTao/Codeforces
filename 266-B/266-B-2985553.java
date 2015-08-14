import java.io.*;
import java.util.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), t = input.nextInt();
    char[] s = input.next().toCharArray();
    for(int i = 0; i<t; i++)
    {
        ArrayList<Integer> swaps = new ArrayList<Integer>();
        for(int j = 0; j<n-1; j++)
            if(s[j] == 'B' && s[j+1] == 'G')
                swaps.add(j);
        for(int j: swaps)
        {
            s[j] = 'G';
            s[j+1] = 'B';
        }
    }
    for(int i = 0; i<n; i++)
        System.out.print(s[i]);
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