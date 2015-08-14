import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n =input.nextInt();
    int[][] data = new int[n][n];
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++) data[i][j] = input.nextInt();
    }
    int init = 0;
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<n; j++)
        {
            init = (init + data[i][j] * data[j][i])&1;
        }
    }
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int type = input.nextInt();
        if(type == 3) out.print(init);
        else
        {
            input.nextInt();
            init ^= 1;
        }
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