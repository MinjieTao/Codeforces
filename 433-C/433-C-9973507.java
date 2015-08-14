import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class C248 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    ArrayList<Integer>[] ds = new ArrayList[n];
    for(int i = 0; i<n; i++) ds[i] = new ArrayList<Integer>();
    int[] data = new int[m];
    for(int i = 0; i<m; i++) data[i] = input.nextInt()-1;
    for(int i = 0; i<m; i++)
    {
        if(i > 0 && data[i] != data[i-1]) ds[data[i]].add(data[i] - data[i-1]);
        if(i < m-1 && data[i] != data[i+1]) ds[data[i]].add(data[i] - data[i+1]);
    }
    long res = 0;
    for(int i = 0; i<m-1; i++)
    {
        res += Math.abs(data[i+1] - data[i]);
    }
    long max = 0;
    for(int i = 0; i<n; i++)
    {
        if(ds[i].size() > 0)
        {
            //System.out.println(i);
            //for(int x : ds[i]) System.out.print(x+" ");
                //  System.out.println();
            //System.out.println(sum(ds[i]));
            max = Math.max(max, sum(ds[i]));
        }
    }
    System.out.println(res - max);
}
static long sum(ArrayList<Integer> a)
{
    Collections.sort(a);
    int median = a.get(a.size() / 2);
    int median2 = a.get((a.size()-1)/2);
    long mean = 0;
    for(int x : a) mean += x;
    mean /= a.size();
    //System.out.println(a+" "+median);
    long res = 0, res2 = 0, res3 = 0, res4 = 0, res5 = 0;
    for(int x : a)
    {
        long old = Math.abs(x);
        long now = Math.abs(x - median);
        long now2 = Math.abs(x - median2);
        long now3 = Math.abs(x - mean);
        long now4 = Math.abs(x - mean + 1);
        long now5 = Math.abs(x - mean - 1);
        res += old - now;
        res2 += old - now2;
        res3 += old - now3;
        res4 += old - now4;
        res5 += old - now5;
    }
    res = Math.max(res, Math.max(res2, Math.max(res3, Math.max(res4, res5))));
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