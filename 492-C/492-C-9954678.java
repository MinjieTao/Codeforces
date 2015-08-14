import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), r = input.nextInt();
    int avg = input.nextInt();
    long need = (long) n * avg;
    Exam[] data = new Exam[n];
    for(int i = 0; i<n; i++) data[i] = new Exam(input.nextInt(), input.nextInt());
    Arrays.sort(data);
    for(int i = 0; i<n; i++) need -= data[i].a;
    need = Math.max(need, 0);
    long res = 0;
    for(int i = 0; i<n; i++)
    {
        long cur = Math.min(r - data[i].a, need);
        res += cur * data[i].b;
        need -= cur;
    }
    System.out.println(res);
}
static class Exam implements Comparable<Exam>
{
    int a, b;
    public Exam(int aa, int bb)
    {
        a = aa; b = bb;
    }
    @Override
    public int compareTo(Exam o) {
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