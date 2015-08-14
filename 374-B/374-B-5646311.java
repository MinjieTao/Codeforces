import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    char[] num =  input.next().toCharArray();
    long res = 1;
    int n =num.length;
    int count = 0;
    for(int i = 2; i<n; i++)
    {
        if(num[i-2] == num[i] && num[i]+num[i-1] - '0' - '0' == 9)
        {
            count++;
        }
        else
        {
            if(count%2 == 1) res *= (count/2+2);
            count = 0;
        }
    }
    if(count%2 == 1) res *= (count/2+2);
    System.out.println(res);
    
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