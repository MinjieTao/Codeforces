import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    char[][] data = new char[n][m];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    int[] res = new int[m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(data[i][j] == 'U' && i%2 == 0) res[j]++;
            if(data[i][j] == 'R' && j+i<m) res[j+i]++;
            if(data[i][j] == 'L' && i <= j) res[j-i]++;
        }
    for(int x: res) out.print(x+" ");
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