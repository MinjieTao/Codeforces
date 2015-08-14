import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    char[] s = input.next().toCharArray();
    int[] zs = zs(s);
    char[] res = new char[n];
    Arrays.fill(res, '0');
    int[] max = new int[n];
    Arrays.fill(max, -1);
    for(int len = 1; len * k <= n && len < n; len++)
    {
        boolean good = zs[len] >= len * (k-1);
        if(!good) continue;
        //res[len*k - 1] = '1';
        //System.out.println(zs[len*k]);
        max[len * k - 1] = Math.min(len * k - 1 + len, len * k - 1 + (len*k < n ? zs[len*k] : 0));
        //for(int j = 0; j<=zs[len*k] && j <= len; j++) res[len * k - 1 + j] = '1';
    }
    boolean on = false;
    int m = -1;
    for(int i = 0; i<n; i++)
    {
        if(i > m) on = false;
        m = Math.max(m, max[i]);
        if(m >= i) on = true;
        if(on || k == 1) res[i] = '1';
    }
    out.println(new String(res));
    out.close();
}
static int[] zs(char[] s)
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