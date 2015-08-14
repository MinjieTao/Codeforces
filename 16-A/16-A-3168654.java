import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    char[][] data = new char[n][m];
    for(int i = 0; i<n; i++)
    {
        String s = input.next();
        for(int j =0; j<m; j++)
            data[i][j] = s.charAt(j);
    }
    boolean good = true;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(i>0) good &= data[i][j] != data[i-1][j];
            if(j>0) good &= data[i][j] == data[i][j-1];
        }
    System.out.println(good?"YES":"NO");
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