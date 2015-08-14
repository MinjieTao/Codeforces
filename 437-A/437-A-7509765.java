import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int[] data = new int[4];
    for(int i = 0; i<4; i++) data[i] = input.next().length() - 2;
    int count = 0;
    int x = 0;
    for(int i = 0; i<4; i++)
    {
        int max = 0, min = 987654321;
        for(int j = 0; j<4; j++)
        {
            if (i != j)
            {
                max = Math.max(max, data[j]);
                min = Math.min(min, data[j]);
            }
        }
        if(data[i] >= 2*max || data[i]*2 <= min)
        {
            x = i;
            count++;
        }
    }
    if(count == 1)
    {
        System.out.println((char)('A'+x));
    }
    else System.out.println("C");
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