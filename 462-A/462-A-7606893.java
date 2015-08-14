import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    char[][] data = new char[n][n];
    int[][] count = new int[n][n];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            if(data[i][j] == 'x') continue;
            if(i > 0) count[i-1][j]++;
            if(j > 0) count[i][j-1]++;
            if(i < n-1) count[i+1][j]++;
            if(j < n-1) count[i][j+1]++;
        }
    boolean good = true;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
            if(count[i][j]%2 == 1) good = false;
    System.out.println(good ? "YES" : "NO");
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