import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    Reader.init(System.in);
    int a = Reader.nextInt(), b = Reader.nextInt(), c = Reader.nextInt();
    int res = 0;
    while(a > 1 && b > 1 && c > 1)
    {
        res += 2*(a+b+c)-6;
        a--;
        b--;
        c--;
    }
    if(a == 1)
        res += b*c;
    else if (b==1)
        res += a*c;
    else
        res += a*b;
    System.out.println(res);
    //System.out.println(2*(a+b+c));
}
public static class Reader {
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
}
}