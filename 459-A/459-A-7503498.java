import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int x1 = input.nextInt(), y1 = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
    if(x1 == x2)
    {
        System.out.println((x1 + (y2-y1))+" "+y1+" "+(x2 + (y2-y1))+" "+y2);
    }
    else if(y1 == y2)
    {
        System.out.println(x1+" "+(y1 + x2 - x1)+" "+x2+" "+(y2 + x2 - x1));
    }
    else if(Math.abs(y1-y2) == Math.abs(x1-x2))
    {
        System.out.println(x1+" "+y2+" "+x2+" "+y1);
    }
    else
        System.out.println(-1);
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