import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int sum = input.nextInt(), limit = input.nextInt();
    ArrayList<Integer> set = new ArrayList<Integer>();
    for(int i = limit; i>=1; i--)
    {
        if((sum & Integer.lowestOneBit(i)) != 0 || i < Integer.highestOneBit(sum))
        {
            sum -= Integer.lowestOneBit(i);
            set.add(i);
        }
    }
    if(sum == 0)
    {
        out.println(set.size());
        for(int x: set) out.print(x+" ");
    }
    else out.println(-1);
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