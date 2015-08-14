import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(System.in);
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n =input.nextInt(), m = input.nextInt();
    int[][] a = new int[n][20];
    TreeSet<Integer>[] zeroes =new TreeSet[20];
    for(int i =0; i<20; i++)
    {
        zeroes[i] = new TreeSet<Integer>();
    }
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt();
        for(int j =0; j<20; j++)
        {
            a[i][j] = (x & (1<<j)) == 0 ? 0 : 1;
            if(a[i][j] == 0) zeroes[j].add(i);
        }
    }
    long[] sums = new long[20];
    for(int j = 0; j<20; j++)
    {
        int count = 0;
        for(int i = 0; i<n; i++)
        {
            if(a[i][j] == 1) count++;
            else
            {
                sums[j] += choose(count);
                count = 0;
            }
        }
        sums[j] += choose(count);
    }
    for(int q = 0; q<m; q++)
    {
        int p = input.nextInt()-1, x = input.nextInt();
        long sum = 0;
        for(int j =0; j<20; j++)
        {
            int old = a[p][j];
            int now = (x & (1<<j)) == 0 ? 0 : 1;
            if(old == now)
            {
                sum += sums[j] * (1<<j);
                continue;
            }
            Integer ceil = zeroes[j].ceiling(p+1), floor = zeroes[j].floor(p-1);
            int max = ceil == null ? n-1 : ceil - 1;
            int min = floor == null ? 0 : floor+1;
            long delta = choose(max - min+1) - choose(max-p) - choose(p - min);
            if(old == 0)
            {
                sums[j] += delta;
                zeroes[j].remove(p);
                a[p][j] = 1;
            }
            else
            {
                sums[j] -= delta;
                zeroes[j].add(p);
                a[p][j] = 0;
            }
            sum += sums[j] * (1<<j);
        }
        out.println(sum);
    }
    out.close();
}
static long choose(long x)
{
    return x * (x+1)/2;
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