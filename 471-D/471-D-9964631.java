import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
    }
    for(int i = n-1; i>0; i--) data[i] -= data[i-1];
    int[] pattern = new int[m];
    for(int i = 0; i<m; i++)
    {
        pattern[i] = input.nextInt();
    }
    for(int i = m-1; i>0; i--) pattern[i] -= pattern[i-1];
    int[] match = new int[n+m-1];
    for(int i = 0; i<m-1; i++) match[i] = pattern[i+1];
    match[m-1] = (int)2e9;
    for(int i = m; i<match.length; i++) match[i] = data[i+1-m];
    //System.out.println(Arrays.toString(match));
    int[] zs = zs(match);
    int res = 0;
    for(int i = 1; i<zs.length; i++) if(zs[i] == m-1) res++;
    if(m == 1) res++;
    System.out.println(res);
}
static int[] zs(int[] s)
{
    int L = 0, R = 0;
    int n = s.length;
    int[] z = new int[n];
    for (int i = 1; i < n; i++) 
    {
          if (i > R) 
          {
            L = R = i;
            while (R < n && s[R-L] == s[R]) R++;
            z[i] = R-L; R--;
          } 
          else 
          {
                int k = i-L;
                if (z[k] < R-i+1) 
                    z[i] = z[k];
                else 
                {
                      L = i;
                      while (R < n && s[R-L] == s[R]) R++;
                      z[i] = R-L; R--;
                }
          }
    }
    return z;
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