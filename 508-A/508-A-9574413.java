import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    boolean[][] grid = new boolean[n+2][m+2];
    int res = 0;
    for(int q = 0; q<k; q++)
    {
        int i = input.nextInt(), j = input.nextInt();
        grid[i][j] = true;
        if(grid[i+1][j] && grid[i][j+1] && grid[i+1][j+1]) res = q+1;
        if(grid[i-1][j] && grid[i][j+1] && grid[i-1][j+1]) res = q+1;
        if(grid[i+1][j] && grid[i][j-1] && grid[i+1][j-1]) res = q+1;
        if(grid[i-1][j] && grid[i][j-1] && grid[i-1][j-1]) res = q+1;
        if(res == q+1) break;
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