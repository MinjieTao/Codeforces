import java.util.*;
import java.io.*;
public class a {
    static int[][] g;
    static int max;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    g = new int[5][5];
    for(int i = 0; i<5; i++)
        for(int j = 0; j<5; j++)
            g[i][j] = input.nextInt();
    max = 0;
    go(new int[5], 0, new boolean[5]);
    System.out.println(max);
}
static int s(int[] p, int i, int j)
{
    return g[p[i]][p[j]] + g[p[j]][p[i]];
}
static void go(int[] p, int at, boolean[] used)
{
    if(at == 5)
    {
        int score = s(p,0,1) + s(p, 2, 3) + s(p, 1, 2) + s(p, 3, 4) + s(p, 2, 3) + s(p, 3, 4);
        max = Math.max(max,  score);
    }
    for(int i = 0; i<5; i++)
    {
        if(used[i]) continue;
        p[at] = i;
        used[i] = true;
        go(p, at+1, used);
        used[i] = false;
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