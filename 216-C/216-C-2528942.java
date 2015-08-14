import java.io.*;
import java.util.*;
public class c {
public static void main(String[] args) throws IOException
{
    Reader.init(System.in);
    int n = Reader.nextInt(), m = Reader.nextInt(), k = Reader.nextInt();
    if(k == 1)
    {
        if(n > m+1)
            System.out.println("2\n1 " + (int)(n));
        else if(n == 2 && m == 2)
            System.out.println("4\n1 2 3 4");
        else if(n==m)
            System.out.println("3\n1 " + (int)(n) + " " + (int)(n+2));
        else
            System.out.println("3\n1 " + (int)(n) + " " + (int)(n+1));

    }
    else
    {
        if(n==m)
        {
            System.out.println(2*k+1);
            for(int i =0; i<k; i++)
                System.out.print(1 + " ");
            System.out.print((n) + " ");
            for(int i = 0; i<k-1; i++)
                System.out.print((int)(n+1) + " ");
            System.out.println((int)(n+2));
        }
        else
        {
            System.out.println(2*k);
            for(int i = 0; i<k; i++)
                System.out.print(1 + " ");
            System.out.print(n+" ");
            for(int i = 0; i<k-2; i++)
                System.out.print((n+1) + " ");
            System.out.println((n+1));
        }
    }
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