import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int a = input.nextInt(), x = input.nextInt(), y = input.nextInt();
    int row = (int)y/a;
    if(y%a == 0 || row<0) System.out.println(-1);
    else if(row<2)
    {
        if(Math.abs(x)<.5*a) System.out.println((row+1));
        else System.out.println(-1);
    }
    else if(row%2 == 0)
    {
        if(0 < x && x<a)
            System.out.println(3*(row/2)+1);
        else if(-a < x && x<0)
            System.out.println(3*(row/2));
        else
            System.out.println(-1);
    }
    else
    {
        if(-.5*a < x && x<.5*a)
            System.out.println(3*(row/2)+2);
        else
            System.out.println(-1);
    }
}
public static long gcd(long a, long b)
{
if(b == 0) return a;
return gcd(b, a%b);
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