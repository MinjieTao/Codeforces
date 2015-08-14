import java.util.*;
import java.io.*;

public class a {
    static long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        int n = input.nextInt(), a = input.nextInt(), d = input.nextInt();
        int[] ts = new int[n], vs = new int[n];
        for(int i = 0; i<n; i++)
        {
            ts[i] = input.nextInt();
            vs[i] = input.nextInt();
        }
        double[] res = new double[n];
        for(int i = 0; i<n; i++)
        {
            double tot = Math.sqrt(2.*d/a);
            double tt = 1.*vs[i]/a;
            double r = 0;
            if(tot <= tt) r = tot;
            else r = tt + (1.*d-.5*a*tt*tt)/vs[i];
            res[i] = r + ts[i];
            if(i>0)res[i] = Math.max(res[i], res[i-1]);
        }
        for(double dd: res) out.println(dd);
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

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
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
}