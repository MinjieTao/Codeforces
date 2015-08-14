import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt(), p = input.nextInt();
    long[][] data = new long[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            data[i][j] = input.nextInt();
    PriorityQueue<MyLong> rows = new PriorityQueue<MyLong>(), cols = new PriorityQueue<MyLong>();
    long[] rowSums = new long[k], colSums = new long[k];
    for(int i = 0; i<n; i++)
    {
        long sum = 0;
        for(int j = 0; j<m; j++) sum += data[i][j];
        rows.add(new MyLong(sum));
    }
    for(int i = 0; i<m; i++)
    {
        long sum = 0;
        for(int j = 0; j<n; j++) sum += data[j][i];
        cols.add(new MyLong(sum));
    }
    for(int i = 0; i<k; i++)
    {
        long cur = rows.poll().a;
        rowSums[i] = cur + (i == 0 ? 0 : rowSums[i-1]);
        rows.add(new MyLong(cur - m*p));
        cur = cols.poll().a;
        colSums[i] = cur + (i == 0 ? 0 : colSums[i-1]);
        cols.add(new MyLong(cur - n*p));
    }
    //System.out.println(Arrays.toString(colSums));
    long max = (long)-1e18;
    for(int i = 0; i<=k; i++)
    {
        long rowVal = i == 0 ? 0 : rowSums[i-1];
        long colVal = i == k ? 0 : colSums[k-i-1];
        //System.out.println(i+" "+rowVal+" "+colVal);
        max = Math.max(max, rowVal + colVal - (long)i * (k-i) * p);
    }
    out.println(max);
    out.close();
}
static class MyLong implements Comparable<MyLong>
{
    long a;
    public MyLong(long aa)
    {
        a = aa;
    }
    @Override
    public int compareTo(MyLong o) {
        // TODO Auto-generated method stub
        return (int)Long.signum(o.a - a);
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