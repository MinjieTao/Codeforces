import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    if(n == 2)
    {
        out.println(1);
        out.println(1);
    }
    else if(n == 3)
    {
        out.println(2);
        out.println(1+" "+3);
    }
    else if(n == 4)
    {
        out.println(4);
        out.println("2 4 1 3");
    }
    else
    {
    int[] res = new int[n];
    for(int i = 0; i<n; i++)
    {
        if(i%2 == 0) res[i] = i/2;
        else res[i] = i/2 + (n+1)/2;
    }
    out.println(n);
    for(int i = 0; i<n; i++) out.print((res[i]+1)+" ");
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