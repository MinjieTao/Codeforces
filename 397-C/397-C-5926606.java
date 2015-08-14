import java.util.*;
import java.io.*;
public class a {
    static int[][] comb;
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        comb = comb(3000);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++)
        {
            for(int x = 2; x<= Math.sqrt(data[i])+1; x++)
            {
                while(data[i]%x == 0)
                {
                    if(map.containsKey(x)) map.put(x, map.get(x)+1);
                    else map.put(x, 1);
                    data[i] /= x;
                }
            }
            if(data[i] > 1)
            {
                if(map.containsKey(data[i])) map.put(data[i], map.get(data[i])+1);
                else map.put(data[i], 1);
            }
        }
        long res = 1;
        for(int x: map.keySet())
        {
            int r = map.get(x);
            res = (res * comb(r+n-1, r))%mod;
        }
        out.println(res);
        
        out.close();
    }
    static long comb(int n, int k)
    {
        if(n < 3000 && k < 3000) return comb[n][k];
        long res = 1;
        for(int i = 0; i<k; i++)
        {
            res = (res * (n-i))%mod;
        }
        for(int i = 1; i<=k; i++)
        {
            res = (res * invmod(i, mod))%mod;
        }
        return res%mod;
    }
    //GCD - O(log(max(p, q)))
    //res[0] is gcd of p and q
    //res[1] and res[2] are values used in extended Euclidean algorithm for inverse mod
    public static long[] gcd(long p, long q)
    {
        if(q==0)
            return new long[] {p, 1, 0};
        long[] vals = gcd(q, p%q);
        return new long[] {vals[0], vals[2], vals[1] - (p/q)*vals[2]};
    }
    //Inverse Mod - O(log(mod))
    //Returns A s.t. x*A = 1(MOD mod)
    public static long invmod(long x, long mod)
    {
        long[] vals = gcd(x, mod);
        if(vals[0]>1)
            return -1;
        if(vals[1]>0)
            return vals[1];
        return mod + vals[1];
    }
    //Returns array of combinations (Pascals's triangle) up to nCn - O(n^2)
    //comb[i][j] represents the value of i choose j
    static int mod = 1000000007;
    public static int[][] comb(int n)
    {
        int[][] comb = new int[n+1][n+1];
        for(int i = 0; i<= n; i++)
            comb[i][0] = 1;
        for(int i = 1; i<= n; i++)
            for(int j = 1; j<= i; j++)
                comb[i][j] = (comb[i-1][j] + comb[i-1][j-1])%mod;
        return comb;
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