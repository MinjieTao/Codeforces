import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] a = new int[n], b = new int[n];
    for(int i = 0; i<n; i++) a[i] = input.nextInt();
    for(int j = 0; j<n; j++) b[j] = input.nextInt();
    int m = input.nextInt();
    long res = 1;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i<n; i++)
    {
        if(a[i] != b[i])
        {
            if(!map.containsKey(a[i]))
                map.put(a[i],1);
            else
            {
                int get = map.get(a[i]);
                map.put(a[i],get+1);
                res = (res*(get+1))%m;
            }
            if(!map.containsKey(b[i]))
                map.put(b[i],1);
            else
            {
                int get = map.get(b[i]);
                map.put(b[i],get+1);
                res = (res*(get+1))%m;
            }
        }
        else
        {
            if(!map.containsKey(a[i]))
                map.put(a[i],2);
            else
            {
                int get = map.get(a[i]);
                map.put(a[i],get+2);
                res *= ((long)(get+1)*(get+2)/2)%m;
                res %= m;
            }
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