import java.util.*;
import java.io.*;
public class h {
public static void main(String[] args) throws IOException
{
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    long a = input.nextInt(), b = input.nextInt(), c = input.nextInt(), d = input.nextInt();
    if(a*d == b*c)
    {
        out.println(0);
        out.close();
        return;
    }
    boolean x = a*d > b*c;
    double res = 1e12;
    for(int i = 0; i<(1<<4); i++)
    {
        int[] ds = new int[4];
        Arrays.fill(ds, 1);
        for(int j = 0; j<4; j++)
        {
            if((i & (1<<j)) > 0) ds[j] = -1;
        }
        double lo = 0, hi = 1e12;
        for(int iter = 0; iter < 500; iter++)
        {
            double mid = (lo+hi)/2;
            double na = a + ds[0] * mid;
            double nb = b + ds[1] * mid;
            double nc = c + ds[2] * mid;
            double nd = d + ds[3] * mid;
            boolean y = na * nd > nb * nc;
            if(x == y) lo = mid;
            else hi = mid;
        }
        res = Math.min(res, hi);
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