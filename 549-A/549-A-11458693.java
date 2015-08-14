import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    char[][] grid = new char[n][m];
    for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
    int res = 0;
    for(int i = 0; i<n-1; i++)
        for(int j = 0; j<m-1; j++)
        {
            char[] a = (""+grid[i][j] + grid[i][j+1] + grid[i+1][j] + grid[i+1][j+1]).toCharArray();
            Arrays.sort(a);
            if(a[0] == 'a' && a[1] == 'c' && a[2] == 'e' && a[3] == 'f') res++;
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