import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    char[][] data = new char[n][m];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(data[i][j] != '.') continue;
            if((i+j)%2 == 1) data[i][j] = 'W';
            else data[i][j] = 'B';
        }
    for(int i = 0; i<n; i++) System.out.println(new String(data[i]));
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