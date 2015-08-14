import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    char[] s = (input.nextLong()+"").toCharArray();
    int k = input.nextInt();
    int n = s.length;
    for(int i = 0; i<n; i++)
    {
        int other = i;
        for(int j = i+1; j<=i+k && j < n; j++)
        {
            if(s[j] > s[other]) other = j;
        }
        k -= other - i;
        for(int j = other-1; j>=i; j--)
        {
            char temp = s[j];
            s[j] = s[j+1];
            s[j+1] = temp;
        }
    }
    System.out.println(new String(s));
    
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