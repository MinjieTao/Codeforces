import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    RMQ[] rmqs = new RMQ[m];
    int[][] data = new int[m][n];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            data[j][i] = input.nextInt();
        }
    for(int i = 0; i<m; i++) rmqs[i] = new RMQ(data[i]);
    int max = 0;
    int[] need = new int[m];
    for(int i = 0; i<n; i++)
    {
        int lo = i-1, hi = n;
        while(lo < hi - 1)
        {
            int mid = (lo+hi)>>1;
            int[] cur = new int[m];
            for(int j = 0; j<m; j++)
            {
                cur[j] = rmqs[j].query(i, mid);
            }
            int sum = 0;
            for(int j = 0; j<m; j++)
            {
                sum += cur[j];
            }
            if(sum <= k) lo = mid;
            else hi = mid;
        }
        int ans = (lo - i + 1);
        if(ans > max)
        {
            for(int j = 0; j<m; j++)
            {
                need[j] = rmqs[j].query(i, lo);
            }
            max = ans;
        }
    }
    for(int x : need) System.out.print(x+" ");
}
static class RMQ
{
/*
 * RMQ - range minimum query
 * O(nlogn) preprocessing, O(1) query
 * Store the array in a, then call preprocess().
 * Then, query(i, j) will return minimum between indices i and j (i<=j).
 */
    RMQ(int[] a)
    {
        this.a = a;
        preprocess();
    }
int[][] rmq;
int[] a;
int[] memo;
int log(int x)
{
    if(memo[x] != -1) return memo[x];
    return memo[x] = Integer.numberOfTrailingZeros(Integer.highestOneBit(x));
}
void preprocess()
{
    int n = a.length;
    memo = new int[n+1];
    Arrays.fill(memo, -1);
    rmq = new int[n][log(n)+1];
    for(int i = 0; i<n; i++) rmq[i][0] = i;
    for(int j = 1; (1<<j) <= n; j++)
        for(int i = 0; i + (1<<j) <= n; i++)
            if(a[rmq[i][j-1]] > a[rmq[i+(1<<(j-1))][j-1]])
                rmq[i][j] = rmq[i][j-1];
            else rmq[i][j] = rmq[i+(1<<(j-1))][j-1];
}
int query(int i, int j)
{
    if(j < i) return 0;
    int k = log(j - i + 1);
    return Math.max(a[rmq[i][k]], a[rmq[j-(1<<k)+1][k]]);
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