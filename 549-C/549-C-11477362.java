import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] fs = new int[2];
    for(int i = 0; i<n; i++) fs[input.nextInt()%2]++;
    int odd = fs[1];
    int even = fs[0];
    int h = (n - k) / 2;
    boolean b = false;
    if(k == n)
    {
        b = odd%2 == 0;
    }
    else if((n-k)%2 == 0)
    {
        b = k%2 == 0 || even > h;
    }
    else
    {
        b = k%2 == 0 && even <= h || odd <= h;
    }
    if(b)
    {
        out.println("Daenerys");
    }
    else out.println("Stannis");
    
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