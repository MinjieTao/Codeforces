import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    char[][] data = new char[n][m];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    int res = 0;
    boolean[][] good = new boolean[n][n];
    for(int i = 0; i<m; i++)
    {
        boolean okay = true;
        for(int j = 0; j<n; j++)
            for(int k = j+1; k<n; k++)
            {
                if(good[j][k]) continue;
                if(data[j][i] > data[k][i]) okay = false;
            }
        if(!okay) res++;
        else
        {
            for(int j = 0; j<n; j++)
                for(int k = 0; k<n; k++)
                    if(data[j][i]< data[k][i])
                        good[j][k] = true;
        }
    }
    System.out.println(res);
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