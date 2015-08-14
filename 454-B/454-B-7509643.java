import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    int min = 987654321, mindex = -1;
    int res = 0;
    for(int i = 0, iter = 0; iter<n; i = (i+n-1)%n)
    {
        if(i != 0 && data[i] > (data[(i+1)%n])) break;
        if(data[i] <= min)
        {
            min = data[i];
            mindex = i;
            res = iter;
        }
        iter++;
    }
    boolean allSame = true;
    for(int i = 1; i<n; i++) if(data[i] != data[0]) allSame = false;
    boolean good = true;
    for(int i = 0; i<n-1; i++)
    {
        if(data[(i+1+mindex)%n] < data[(i+mindex)%n]) good = false;
    }
    if(allSame) System.out.println(0);
    else System.out.println(good ? res : -1);
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