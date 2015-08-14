import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int[] data = new int[9];
    for(int i = 0; i<9; i++) data[i] = input.nextInt();
    boolean[][] b = new boolean[9][9];
    for(int i = 0; i<9; i++) for(int j = 0; j<9; j++) b[i][j] = (Math.abs(i-j) ==1&&i/3==j/3) || Math.abs(i-j) == 3;
    for(int i = 0; i<9; i++)
    {
        int x = 0;
        for(int j = 0; j<9; j++)
            if(j==i || b[i][j])
                x = (x+data[j])%2;
        System.out.print(1-x);
        if(i%3==2)System.out.println();
    }
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