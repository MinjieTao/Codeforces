import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[][] data = new int[n][n];
    long[] sumsum = new long[2*n];
    long[] sumdiff = new long[2*n];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            data[i][j] = input.nextInt();
            sumsum[i+j] += data[i][j];
            sumdiff[i-j+n] += data[i][j];
        }
    Pair maxodd = new Pair(0, 1, -1);
    Pair maxeven = new Pair(0, 0 ,-1);
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
        {
            Pair cur = new Pair(i+1, j+1, sumsum[i+j] + sumdiff[i-j+n] - data[i][j]);
            if(cur.compareTo(maxodd) > 0 && (i+j)%2 == 1) maxodd = cur;
            if(cur.compareTo(maxeven) > 0 && (i+j)%2 == 0) maxeven = cur;
        }
    System.out.println(maxodd.val+maxeven.val);
    System.out.println(maxodd.a+" "+maxodd.b+" "+maxeven.a+" "+maxeven.b);
    
}
static class Pair implements Comparable<Pair>
{
    int a, b;
    long val;
    public Pair(int aa, int bb, long vv)
    {
        a = aa; b = bb; val = vv;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return (int)Long.signum(val - o.val);
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