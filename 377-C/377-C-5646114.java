import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    n = input.nextInt();
    int[] data2 = new int[n];
    for(int i = 0; i<n; i++) data2[i] = input.nextInt();
    Arrays.sort(data2);
    n = Math.min(n, 20);
    data = new int[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = data2[data2.length-1-i];
    }
    m = input.nextInt();
    types = new char[m];
    nums = new int[m];
    for(int i = 0; i<m; i++)
    {
        types[i] = input.next().charAt(0);
        nums[i] = input.nextInt();
    }
    memo = new int[m][1<<n];
    lowestZero = new int[1<<n];
    Arrays.fill(lowestZero, -1);
    for(int[] A: memo) Arrays.fill(A, 987654321);
    System.out.println(go(0, 0));
}
static int[] data, nums;
static char[] types;
static int n, m;
static int[][] memo;
static int go(int at, int mask)
{
    if(at==m) return 0;
    if(memo[at][mask] != 987654321) return memo[at][mask];
    if(types[at] == 'b')
    {
        if(nums[at] == 1)
        {
            int res = -987654321;
            for(int i = 0; i<n; i++)
            {
                if((mask & (1<<i)) == 0) res = Math.max(res, go(at+1, mask ^ (1<<i)));
            }
            return memo[at][mask] = res;
        }
        else
        {
            int res = 987654321;
            for(int i = 0; i<n; i++)
            {
                if((mask & (1<<i)) == 0) res = Math.min(res, go(at+1, mask ^ (1<<i)));
            }
            return memo[at][mask] = res;
        }
    }
    int low = lowest(mask);
    int recursion = go(at+1, mask ^ (1<<low));
    if(nums[at] == 1) return recursion + data[low];
    else return recursion - data[low];
}
static int[] lowestZero;
static int lowest(int mask)
{
    if(lowestZero[mask] != -1) return lowestZero[mask];
    for(int i = 0; i<n; i++) if((mask & (1<<i)) == 0) return lowestZero[mask] = i;
    return -1;
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