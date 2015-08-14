import java.util.*;
import java.io.*;
public class B263 {
public static long mod = (long)1e9+7;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    //System.out.println(n);
    ArrayList<Integer>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    int[] ps = new int[n];
    Arrays.fill(ps, -1);
    for(int i = 0; i<n-1; i++)
    {
        int p = input.nextInt();
        ps[i+1] = p;
        g[p].add(i+1);
    }
    long[][] dp = new long[n][2];
    int[] degs = new int[n];
    Queue<Integer> q = new LinkedList<Integer>();
    for(int i = 0; i<n; i++)
    {
        degs[i] = g[i].size();
        if(degs[i] == 0) q.add(i);
        //System.out.println(i+" "+degs[i]);
    }
    boolean[] color = new boolean[n];
    for(int i = 0; i<n; i++) color[i] = (input.nextInt() == 1);
    while(!q.isEmpty())
    {
        int at = q.poll();
        //System.out.println(at+" "+ps[at]);
        if(ps[at] >= 0)
        {
            degs[ps[at]]--;
            if(degs[ps[at]] == 0) q.add(ps[at]);
        }
        
        if(color[at])
        {
            dp[at][0] = 0;
            dp[at][1] = 1;
            for(int e : g[at])
            {
                dp[at][1] = (dp[at][1] * (dp[e][1] + dp[e][0]))%mod;
            }
        }
        else
        {
            dp[at][0] = 1;
            for(int e : g[at])
            {
                dp[at][0] = (dp[at][0] * (dp[e][1] + dp[e][0]))%mod;
            }
            int k = g[at].size();
            long[] preprod = new long[k+1], postprod = new long[k+1];
            preprod[0] = 1;
            postprod[k] = 1;
            for(int i = 0; i<k; i++)
            {
                int e = g[at].get(i);
                preprod[i+1] = (preprod[i] * (dp[e][1] + dp[e][0]))%mod;
            }
            for(int i = k-1; i>=0; i--)
            {
                int e = g[at].get(i);
                postprod[i] = (postprod[i+1] * (dp[e][1] + dp[e][0]))%mod;
            }
            for(int i = 0; i<k; i++)
            {
                int e = g[at].get(i);
                long ways = (preprod[i] * postprod[i+1])%mod;
                //System.out.println(preprod[i] +" "+postprod[i+1]);
                ways = (ways * dp[e][1])%mod;
                dp[at][1] = (dp[at][1] + ways)%mod;
            }
        }
        //System.out.println(at+" "+dp[at][0]+" "+dp[at][1]);
    }
    System.out.println(dp[0][1]);

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