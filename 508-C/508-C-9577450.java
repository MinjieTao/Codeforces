import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int m = input.nextInt(), t = input.nextInt(), r = input.nextInt();
    boolean[] light = new boolean[601];
    boolean good = true;
    int lit = 0;
    for(int i = 0; i<m; i++)
    {
        int w = input.nextInt()+300;
        int count = 0;
        for(int j = w-1; j>= w-t && j >= 0; j--)
        {
            if(light[j]) count++;
        }
        for(int j = w-1; j>= w-t && j >= 0 && count < r; j--)
        {
            if(!light[j])
            {
                light[j] = true;
                count++;
                lit++;
            }
        }
        //System.out.println(count+" "+r);
        good &= count >= r;
    }
    out.println(!good?-1:lit);
    
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