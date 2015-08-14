import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt(), d = input.nextInt();
    boolean good = false;
    long cur = 1;
    for(int i = 0; i<d; i++)
    {
        cur *= k;
        if(cur >= n) good = true;
    }
    if(!good) out.println(-1);
    else
    {
        int[][] res = new int[d][n];
        long div = 1;
        for(int i = 0; i<d; i++)
        {
            
            for(int j = 0; j<n; j++)
            {
                res[i][j] = 1+(int)((j/div)%k);
            }
            if(div < n) div *= k;
        }
        for(int[] A: res)
        {
            for(int x: A) out.print(x+" ");
            out.println();
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