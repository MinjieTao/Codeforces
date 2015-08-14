import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt(), k = input.nextInt(), l = input.nextInt(), r = input.nextInt();
    int sall = input.nextInt(), sk = input.nextInt();
    int[] res = new int[n];
    Arrays.fill(res, l);
    int tot = n*l, subtot = k*l;
    while(subtot < sk)
    {
        for(int i =0; i<k; i++)
        {
            res[i]++;
            tot++;
            subtot++;
            if(subtot == sk) break;
        }
    }
    while(tot < sall)
    {
        for(int i = k; i<n; i++)
        {
            res[i]++;
            tot++;
            if(tot == sall) break;
        }
    }
    for(int i =0; i<n; i++) out.print(res[i]+" ");
    out.close();
}
static class Edge
{
    int to, d;
    public Edge(int tt, int dd)
    {
        to = tt;
        d = dd;
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