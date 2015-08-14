import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    User[] data = new User[n];
    for(int i =0; i<n; i++) data[i] = new User(input.nextInt(), i);
    Arrays.sort(data);
    long[] res = new long[n];
    res[0] = data[0].b;
    for(int i =1; i<n; i++)
    {
        res[i] = Math.max(res[i-1]+1, data[i].b);
    }
    long[] pr = new long[n];
    for(int i = 0; i<n; i++) pr[data[i].i] = res[i];
    for(int i =0; i<n; i++) out.print(pr[i]+(i==n-1?"":" "));
    
    out.close();
}
static class User implements Comparable<User>
{
    int b, i;
    public User(int bb, int ii)
    {
        b = bb; i = ii;
    }
    @Override
    public int compareTo(User o) {
        // TODO Auto-generated method stub
        return b-o.b;
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