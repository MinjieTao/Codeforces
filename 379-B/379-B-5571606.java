import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    ArrayList<Character> ch = new ArrayList<Character>();
    for(int i = 0; i<n; i++)
    {
        for(int j = 0; j<data[i]; j++)
        {
            if(i == n-1)
            {
                ch.add('L');
                ch.add('R');
                ch.add('P');
            }
            else
            {
                ch.add('R');
                ch.add('L');
                ch.add('P');
            }
        }
        if(i<n-1) ch.add('R');
    }
    StringBuilder sb = new StringBuilder("");
    for(char c: ch) sb.append(c);
    out.println(sb.toString());
    
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