import java.util.*;
import java.io.*;
public class aa {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    int lo = 0, hi = n/2 + 1;
    while(lo < hi - 1)
    {
        int mid = (lo+hi)/2;
        //System.out.println(mid);
        boolean good = true;
        int ptr = mid;
        for(int i = 0; i<mid; i++)
        {
            while(ptr < n && data[ptr] < 2*data[i]) ptr++;
            if(ptr == n)
            {
                good = false;
                break;
            }
            ptr++;
        }
        if(good) lo = mid;
        else hi = mid;
        
    }
    out.println(n - lo);
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