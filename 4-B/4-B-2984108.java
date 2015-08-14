import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
    public static int mod = 1000000007;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int d = input.nextInt(), tot = input.nextInt();
    int[] mins = new int[d], maxs = new int[d];
    int mintot = 0, maxtot = 0;
    for(int i = 0; i<d; i++)
    {
        mins[i] = input.nextInt();
        maxs[i] = input.nextInt();
        mintot += mins[i];
        maxtot += maxs[i];
    }
    if(tot < mintot || tot > maxtot)
        System.out.println("NO");
    else
    {
        int[] res = new int[d];
        int diff = tot - mintot;
        System.out.println("YES");
        for(int i = 0; i<d; i++)
        {
            res[i] = mins[i] + Math.min(maxs[i] - mins[i], diff);
            diff -= res[i]-mins[i];
            System.out.print(res[i] + " ");
        }
        
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