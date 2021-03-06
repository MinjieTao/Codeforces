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
        int[] freq = new int[8];
        for(int i = 0;i<n;i++) freq[input.nextInt()]++;
        boolean good = true;
        if(freq[7] > 0 || freq[5] > 0) good = false;
        int[][] res = new int[n/3][3];
        for(int i = 0; i<n/3; i++)
        {
            if(freq[1] == 0)
            {
                good = false;
                break;
            }
            res[i][0] = 1;
            freq[1]--;
            if(freq[2] > 0)
            {
                res[i][1] = 2;
                freq[2]--;
                if(freq[4] > 0)
                {
                    res[i][2] = 4;
                    freq[4]--;
                }
                else if(freq[6] > 0)
                {
                    res[i][2] = 6;
                    freq[6]--;
                }
                else
                {
                    good = false;
                    break;
                }
            }
            else if(freq[3] > 0 && freq[6] > 0)
            {
                res[i][1] = 3;
                freq[3]--;
                res[i][2] = 6;
                freq[6]--;
            }
            else
            {
                good = false;
                break;
            }
        }
        if(good)
        {
            for(int i = 0; i<n/3; i++)
            {
                for(int j = 0; j<3; j++)
                    out.print(res[i][j]+" ");
                out.println();
            }
        }
        else out.println(-1);
        
        
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
    public static boolean[] sieve(int n)
    {
        boolean[] res = new boolean[n+1];
        for(int i = 2; i<=n; i++) res[i] = true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(res[i])
                for(long j = (long)i*i; j<=n; j+=i)
                    res[(int) j] = false;
        return res;
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