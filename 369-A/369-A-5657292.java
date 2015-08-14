import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt(), b = input.nextInt(), p = input.nextInt();
    int res = 0;
    for(int i = 0; i<n; i++)
    {
        int a = input.nextInt();
        if(a==1)
        {
            if(b>0) b--;
            else res++;
        }
        else
        {
            if(p>0) p--;
            else if(b>0) b--;
            else res++;
        }
    }
    out.println(res);
    out.close();
}
static class Edge
{
    int to, d;
    public Edge(int tt, int dd)
    {
        to = tt;
        d = dd;
    }
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