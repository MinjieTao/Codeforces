import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    int[] floor = new int[2000001];
    Arrays.fill(floor, -1);
    for(int i = 0; i<n; i++) floor[data[i]] = data[i];
    for(int i = 1; i<floor.length; i++)
    {
        if(floor[i] == -1) floor[i] = floor[i-1]; 
    }
    int res = 0;
    for(int i = 0; i<n; i++)
    {
        int cur = data[i];
        if(i > 0 && cur == data[i-1]) continue;
        for(int j = 2*cur - 1; j <= cur + 1000000; j+=cur)
        {
            int next = floor[j];
            if(next >= cur) res = Math.max(res, next%cur);
        }
    }
    System.out.println(res);
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