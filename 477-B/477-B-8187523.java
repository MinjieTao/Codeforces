import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    boolean found = false;
    int m = 0;
    while(!found)
    {
        m+=k;
        int count = m/k;
        int odds = (count+1)/2;
        if(odds < 3*n) continue;
        found = true;
        System.out.println(m);
        for(int i = 0; i<n; i++)
        {
            int first = (6*i+1)*k, second = first + 2*k, third = second + 2*k, fourth = first + k;
            out.println(first+" " +second+" "+third+" "+fourth);
        }
    }
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