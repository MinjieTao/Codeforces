import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        long[] der = new long[n+1]; //derangements
        der[0] = 1;
        der[1] = 0;
        for(int i = 2; i<=n; i++) der[i] = ((i-1)*(der[i-1] + der[i-2]))%mod;
        long[] facts = new long[n+1]; //factorials
        facts[0] = 1;
        for(int i =1; i<=n; i++) facts[i] = (i*facts[i-1])%mod;
        boolean[] used = new boolean[n];
        for(int i = 0; i<n; i++)
        {
            if(data[i] > 0) used[data[i]-1] = true;
        }
        int countgood = 0, countbad = 0;
        for(int i =0; i<n; i++)
        {
            if(data[i] == -1)
            {
                if(used[i]) countgood++;
                else countbad++;
            }
        }
        //countgood is ones that can go anywhere, countbad is ones that can't go in own index
        long[] combs = new long[countbad+1]; //combs[i] = countbad(choose)i.
        combs[0] = 1;
        for(int i = 1; i<= countbad; i++)
        {
            combs[i] = (combs[i-1]*(countbad-i+1))%mod;
            combs[i] = (combs[i]*invmod(i))%mod;
        }
        //System.out.println(countgood + " " +countbad);
        long[][] dp = new long[countgood+1][countbad+1];
        for(int i = 0; i<countbad+1; i++) dp[0][i] = der[i];
        for(int i = 0; i<countgood+1; i++) dp[i][0] = facts[i];
        for(int i = 1; i<= countgood; i++)
            for(int j = 1; j<=countbad; j++)
            {
                dp[i][j] = (i*dp[i-1][j] + j*dp[i][j-1])%mod;
            }
        out.println(dp[countgood][countbad]);
        out.close();
    }
    static long pow(long x, long p) {
        if (p == 0)
            return 1;
        if ((p & 1) > 0) {
            return (x * pow(x, p - 1)) % mod;
        }
        long sqrt = pow(x, p / 2);
        return (sqrt * sqrt) % mod;
    }

    static class input {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                // TODO add check for eof if necessary
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static String nextLine() throws IOException {
            return reader.readLine();
        }
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
    public static long invmod(long x)
    {
        long[] vals = gcd(x, mod);
        if(vals[0]>1)
            return -1;
        if(vals[1]>0)
            return vals[1];
        return mod + vals[1];
    }
}