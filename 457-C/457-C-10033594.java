import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    Voter[] data = new Voter[n];
    for(int i = 0; i<n; i++) data[i] = new Voter(input.nextInt(), input.nextInt());
    Arrays.sort(data);
    int lo = 1, hi = n;
    while(lo < hi - 3)
    {
        int mid = (lo+hi)/2;
        if(go(mid, data) < go(mid+1, data)) hi = mid+1;
        else lo = mid;
    }
    long res = (long)1e12;
    for(int i = lo; i<=hi; i++) res = Math.min(res, go(i, data));
    System.out.println(res);
}
static long go(int votes, Voter[] data)
{
    int n = data.length;
    int[] counts = new int[100001];
    for(Voter v : data) counts[v.a]++;
    long res = 0;
    boolean[] paid = new boolean[n];
    int soFar = counts[0];
    for(int i = 0; i<n; i++)
    {
        if(counts[data[i].a] >= votes && data[i].a != 0)
        {
            soFar++;
            paid[i] = true;
            res += data[i].b;
            counts[data[i].a]--;
        }
    }
    for(int i = 0; i<n; i++)
    {
        if(!paid[i] && soFar < votes && data[i].a != 0)
        {
            paid[i] = true;
            soFar++;
            res += data[i].b;
        }
    }
    return res;
}
static class Voter implements Comparable<Voter>
{
    int a, b;
    public Voter(int aa, int bb)
    {
        a = aa; b = bb;
    }
    @Override
    public int compareTo(Voter o) {
        // TODO Auto-generated method stub
        return b - o.b;
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