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
        String s = input.next(), t = input.next();
        int[] data = new int[4];
        int[] counts = new int[2];
        for(int i = 0; i<2*n; i++)
        {
            data[2*(t.charAt(i)-'0') + s.charAt(i)-'0']++;
        }
        int turn = 0;
        for(int i = 0; i<2*n; i++)
        {
            if(data[3] > 0)
            {
                data[3]--;
                counts[turn]++;
            }
            else if(data[turn+1] > 0)
            {
                data[turn+1]--;
                counts[turn]++;
            }
            else if(data[2-turn] > 0) data[2-turn]--;
            else data[0]--;
            turn = 1-turn;
        }
        //out.println(counts[0]+" "+counts[1]);
        if(counts[0] > counts[1]) out.println("First");
        else if(counts[1] > counts[0]) out.println("Second");
        else out.println("Draw");
        
        
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