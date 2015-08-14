import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt(), k = input.nextInt();
    int count = n/2;
    if(k<count || (n == 1 && k > 0)) out.println(-1);
    else
    {
        int prev = 0;
        for(int i = 0; i<count-1; i++)
        {
            out.print((2*i+1)+" "+(2*i+2)+" ");
            prev = 2*i+2;
        }
        if(n>1)
        {
            int secondLast = (k-count+1), x = secondLast;
            //out.println(secondLast);
            while(x<= prev) x+= secondLast;
            out.print(x+" "+(x+secondLast)+" ");
        }
        if(n%2 == 1) out.print(1000000000);
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