import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    char[][] grid = new char[n][m];
    for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
    int[][] vs = new int[n][m];
    int res = 0;
    for(int i = n-1; i>=0; i--)
        for(int j = m-1; j>=0; j--)
        {
            int need = grid[i][j] == 'B' ? 1 : -1;
            if(vs[i][j] != need)
            {
                int d = need - vs[i][j];
                res++;
                for(int ii = 0; ii<=i; ii++)
                    for(int jj = 0; jj<=j; jj++)
                        vs[ii][jj] += d;
            }
        }
    out.println(res);
    
    
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