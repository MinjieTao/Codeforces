import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int sum = 0;
    for(int x: data) sum += x;
    int[] ys = new int[n];
    int max = -987654321, min = 987654321;
    ys[0] = data[0];
    for(int i = 1; i<n; i++)
    {
        ys[i] = ys[i-1];
        if(i%2 == 0) ys[i] += data[i];
        else ys[i] -= data[i];
    }
    for(int x: ys)
    {
        max = Math.max(max, x);
        min = Math.min(min, x);
    }
    char[][] g = new char[max-Math.min(min, 0)][sum];
    for(char[] A: g) Arrays.fill(A, ' ');
    int atc = 0, atr = g.length-1;
    if(min < 0) atr = g.length-1+min;
    for(int i = 0; i<n; i++)
    {
        //System.out.println(atr+" "+atc+" "+g.length+" "+g[0].length);
        for(int k = 0; k<data[i]; k++)
        {
            if(i%2 == 0)
            {
                g[atr][atc] = '/';
                if(k != data[i] -1) atr--;
            }
            else
            {
                g[atr][atc] = '\\';
                if(k != data[i] - 1)atr++;
            }
            atc++;
        }
    }
    for(char[] A: g) out.println(new String(A));
    out.close();
}
static class Edge
{
    int to, cost;
    public Edge(int tt, int cc)
    {
        to = tt; cost = cc;
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