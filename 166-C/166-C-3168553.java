import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int less = 0, eq = 0, greater = 0;
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt();
        if(x<k)less++;
        else if(x==k)eq++;
        else greater++;
    }
    int res = 0;
    while(true)
    {
        int pos = (less+eq+greater+1)/2;
        if(pos>less && pos<=less+eq)
            break;
        else
        {
            res++;
            eq++;
        }
    }
    System.out.println(res);
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