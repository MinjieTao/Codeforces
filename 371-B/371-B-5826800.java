import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int a = input.nextInt(), b = input.nextInt(), g = gcd(a, b), ns[] = new int[]{a/g, b/g}, res = 0, factors[] = new int[]{2, 3,5};
    for(int k = 0; k<2; k++)
    while(ns[k] > 1)
    {
        boolean found = false;
        for(int f: factors)
        {
            if(ns[k]%f == 0)
            {
                ns[k] /= f;
                found = true;
                res++;
                break;
            }
        }
        if(!found) break;
    }
    out.println(ns[0] == 1 && ns[1] == 1 ? res : -1);
    
    out.close();
}
static int gcd(int a, int b)
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