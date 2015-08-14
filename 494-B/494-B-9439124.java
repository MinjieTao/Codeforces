import java.util.*;
import java.io.*;
public class b {
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        s = input.next();
        t = input.next();
        n = s.length();
        int[] zs = zs((t+'#'+s).toCharArray());
        start = new boolean[n];
        for(int i = 0; i<n; i++) start[i] = zs[i+t.length()+1] == t.length();
//      long res = 0;
        memo = new long[n+1][2];
//      for(long[] A : memo) Arrays.fill(A, -1);
//      res = (res+go(0, 0))%mod;
        int[] next = new int[n];
        for(int i = n-1; i>=0; i--)
            if(start[i]) next[i] = i;
            else if(i == n-1) next[i] = n;
            else next[i] = next[i+1];
        memo[n][1] = 1;
        memo[n][0] = 0;
        long[] csum = new long[n+1];
        csum[n] = 1;
        for(int i = n-1; i>=0; i--)
        {
            int other = next[i] + t.length();
            for(int j = 0; j<2; j++)
            {
                memo[i][j] = (memo[i][j] + memo[i+1][j])%mod;
                if(other <= n)
                {
                    memo[i][j] = (memo[i][j] + csum[other])%mod;
                }
                //System.out.println(i+" "+j+" "+memo[i][j]);
            }
            csum[i] = (csum[i+1] + memo[i][1])%mod;
        }
        System.out.println(memo[0][0]);
        out.close();
    }
    static int mod = (int)(1e9+7);
    static int n;
    static boolean[] start;
    static String s, t;
    static long[][] memo;
    static long go(int at, int flag)
    {
        if(at == n) return flag;
        if(memo[at][flag] != -1) return memo[at][flag];
        long res = go(at+1, flag);
        int next = n;
        for(int i = at; i<n; i++)
        {
            if(start[i])
            {
                next = i;
                break;
            }
        }
        int other = next + t.length();
        for(int i = other; i<=n; i++) res = (res + (go(i, 1)))%mod;
        return memo[at][flag] = res;
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