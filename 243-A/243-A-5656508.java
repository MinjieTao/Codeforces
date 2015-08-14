import java.io.*;
import java.util.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i =0; i<n; i++) data[i] = input.nextInt();
    HashSet<Integer> res = new HashSet<Integer>();
    HashSet<Integer> cur = new HashSet<Integer>();
    for(int  i= 0; i<n; i++)
    {
        int at = data[i];
        for(int x: cur) res.add(x);
        HashSet<Integer> next = new HashSet<Integer>();
        next.add(at);
        for(int x: cur) next.add(at | x);
        cur = next;
    }
    for(int x: cur) res.add(x);
    System.out.println(res.size());
    
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
}