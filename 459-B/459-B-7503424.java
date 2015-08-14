import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Random r = new Random();
    for(int i = 0; i<100000; i++)
    {
        int a = r.nextInt(n);
        int b = r.nextInt(n);
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
    Arrays.sort(data);
    long res = data[n-1] - data[0];
    long ways1 = 1, ways2 = 1;
    while(ways1 < n && data[(int)ways1] == data[0]) ways1++;
    while(ways2 < n && data[n-1-(int)ways2] == data[n-1]) ways2++;
    if(data[0] == data[n-1])
    {
        ways1 = 1;
        ways2 = (long)n * (n-1)/2;
    }
    System.out.println(res+" "+ways1*ways2);
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