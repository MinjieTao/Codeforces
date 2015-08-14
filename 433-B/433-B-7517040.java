import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    long[] sum1 = new long[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
        sum1[i] = data[i] + (i == 0 ? 0 : sum1[i-1]);
    }
    long[] sum2 = new long[n];
    Random ra = new Random();
    for(int i = 0; i<100000; i++)
    {
        int a = ra.nextInt(n), b = ra.nextInt(n);
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    Arrays.sort(data);
    for(int i = 0; i<n; i++) sum2[i] = data[i] + (i == 0 ? 0 : sum2[i-1]);
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int type = input.nextInt(), l = input.nextInt()-1, r = input.nextInt()-1;
        if(type == 1)
        {
            out.println(sum1[r] - (l == 0 ? 0 : sum1[l-1]));
        }
        else
            out.println(sum2[r] - (l == 0 ? 0 : sum2[l-1]));
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