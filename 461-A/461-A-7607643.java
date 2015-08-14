import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    if(n == 1)
    {
        System.out.println(data[0]);
        return;
    }
    Arrays.sort(data);
    int ptr = 0;
    int log = 0, cur = 1;
    while(cur < n)
    {
        log++;
        cur *= 2;
    }
    long res = 0;
//  for(int i = 0; i<=log; i++)
//  {
//      if((n & (1<<i)) == 0) continue;
//      for(int j = 0; j<(1<<i); j++)
//      {
//          res += (long)(i+2) * data[ptr++];
//      }
//  }
    for(int i = 0; i<n; i++)
    {
        if(i != n-1) res += (long)data[i] * (i+2);
        else res += (long)data[i] * (i+1);
    }
    out.println(res);
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