import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    C[] data = new C[n];
    for(int i = 0; i<n; i++) data[i] = new C(input.nextInt(), input.nextInt());
    Arrays.sort(data);
    int time = 0;
    for(int i = 0; i<n; i++)
    {
        if(data[i].b >= time)
        {
            time = data[i].b;
        }
        else time = data[i].a;
    }
    out.println(time);
    out.close();
}
static class C implements Comparable<C>
{
    int a, b;
    public C(int aa, int bb)
    {
        a = aa; b = bb;
    }
    @Override
    public int compareTo(C o) {
        // TODO Auto-generated method stub
        if(a == o.a) return b - o.b;
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