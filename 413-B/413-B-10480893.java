import java.util.*;
import java.io.*;
public class CoderStrike2014_2B {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    boolean[][] in = new boolean[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            in[i][j] = (input.nextInt() == 1);
    int[] sub = new int[n];
    int[] chat = new int[m];
    for(int i = 0; i<k; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        sub[a]++;
        chat[b]++;
    }
    for(int i = 0; i<n; i++)
    {
        int cur = -sub[i];
        for(int j = 0; j<m; j++)
        {
            if(in[i][j]) cur += chat[j];
        }
        out.print(cur+" ");

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