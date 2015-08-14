import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int[] sum = new int[k];
    for(int i = 0; i<n; i++) sum[i%k] += data[i];
    int min = 987654321, mindex = 0;
    for(int i = 0; i<k; i++)
    {
        if(sum[i] < min)
        {
            min = sum[i];
            mindex = i;
        }
    }
    out.println(1+mindex);
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