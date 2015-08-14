import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] as = new int[n], bs = new int[n];
    Laptop[] data = new Laptop[n];
    for(int i = 0; i<n; i++)
    {
        as[i] = input.nextInt();
        bs[i] = input.nextInt();
        data[i] = new Laptop(as[i], bs[i]);
    }
    Arrays.sort(data);
    boolean good = true;
    for(int i = 0; i<n-1; i++)
        if(data[i+1].b < data[i].b) good = false;
    System.out.println(!good ? "Happy Alex" : "Poor Alex");
}
static class Laptop implements Comparable<Laptop>
{
    int a, b;
    public Laptop(int aa, int bb)
    {
        a = aa; b = bb;
    }
    @Override
    public int compareTo(Laptop o) {
        // TODO Auto-generated method stub
        return a - o.a;
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