import java.util.*;
import java.io.*;
public class B188 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int k = input.nextInt();
    int max = 250;
    int[][] res = new int[max][max];
    res[max/2][max/2] = k;
    while(true)
    {
        boolean b = false;
        for(int i = 0; i<max; i++)
            for(int j = 0; j<max; j++)
            {
                if(res[i][j] < 4) continue;
                int x = res[i][j]/4;
                res[i+1][j] += x;
                res[i-1][j] += x;
                res[i][j+1] += x;
                res[i][j-1] += x;
                res[i][j] -= 4*x;
                b = true;
            }
        if(!b) break;
    }
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int x = input.nextInt(), y = input.nextInt();
        out.println(x+max/2 < 0 || x+max/2 >= max || y+max/2 < 0 || y+max/2 >= max ? 0 : res[x+max/2][y+max/2]);
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
    static String nextLine() throws IOException
    {
        return reader.readLine();
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