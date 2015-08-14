import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    long res = (long)1e18;
    for(int i = -10; i<=10; i++)
    {
        int ni = n/2 + i;
        if(ni >= 0 && ni < n) res = Math.min(res, go(data, ni, k));
    }
    //long res = n == 1 ? 0 : Math.min(go(data, (n+1)/2, k), go(data, (n-1)/2, k));
    System.out.println(res);
}
static long go(int[] data, int splitIndex, int k)
{
    int n = data.length;
    int[] first = new int[splitIndex+1];
    int[] second = new int[n-splitIndex];
    for(int i = 0; i<splitIndex+1; i++) first[i] = data[i];
    for(int i = splitIndex; i<n; i++) second[i-splitIndex] = data[i];
    return go(rev(first), k) + go(second, k);   
}
static int[] rev(int[] a)
{
    int n= a.length;
    int[] res = new int[n];
    for(int i = 0; i<n; i++) res[n-i-1] = a[i];
    return res;
}
static long go(int[] data, int k)
{
    int n = data.length;
    long res = 0;
    int i = n-1;
    while(i>0)
    {
        res += 2*Math.abs((long)data[i] - data[0]);
        i -= k;
    }
    return res;
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