import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int[] pos = new int[n], data = new int[n];
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt()-1;
        pos[x] = i;
        data[i] = x;
    }
    long res = 0;
    for(int i = 0; i<m; i++)
    {
        int x = input.nextInt()-1;
        int old = pos[x];
        res += 1+old/k;
        if(old > 0)
        {
            int other = data[old-1];
            data[old] = other;
            data[old-1] = x;
            pos[x]--;
            pos[other]++;
        }
    }
    out.println(res);
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