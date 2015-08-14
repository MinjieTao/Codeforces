import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int[] boy = new int[2], girl = new int[2];
    for(int i = 0;i<2; i++) girl[i] = input.nextInt();
    for(int j = 0; j<2; j++) boy[j] = input.nextInt();
    boolean res = false;
    for(int i = 0; i<2; i++)
    {
        int a = boy[i], b = girl[1-i];
        if(a >= b-1 && a <= 2*(b+1))
            res = true;
    }
    System.out.println(res?"YES":"NO");
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