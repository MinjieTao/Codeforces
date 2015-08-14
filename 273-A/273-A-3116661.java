import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    IT it = new IT(0, n-1);
    for(int i = 0; i<n; i++)
        it.add(input.nextInt(),i);
    int q = input.nextInt();
    for(int i = 0; i<q; i++)
    {
        int w = input.nextInt();
        int h = input.nextInt();
        long biggest = it.getMax(0, w-1);
        out.println(biggest);
        it.add(biggest+h,0,0);
    }
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
static class IT
{
    int start, end;
    long count;
    IT left, right;
    IT(int s, int e)
    {
        start = s;
        end = e;
        if(start == end)
            count = 0;
        else
        {
            left = new IT(s, (s+e)/2);
            right = new IT((s+e)/2 + 1, e);
        }
    }
    void add(long val, int index)
    {
        if(index > end || index < start)
            return;
        count = Math.max(count, val);
        if(start == end)
            return;
        left.add(val, index);
        right.add(val, index);
    }
    void add(long val, int s, int e)
    {
        if(s>end || e<start)return;
        count = Math.max(count,val);
        if(start==end) return;
        left.add(val,s,e);
        right.add(val, s,e);
    }
    long getCount(int s, int e)
    {
        if(s <= start && e >= end)
            return count;
        if(e < start || s > end)
            return 0;
        return left.getCount(s,  e) + right.getCount(s,  e);
    }
    long getMax(int s, int e)
    {
        if(s<=start && e>=end) return count;
        if(e < start || s > end) return 0;
        return Math.max(left.getMax(s, e),right.getMax(s, e));
    }
}
}