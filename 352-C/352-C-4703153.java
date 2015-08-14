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
        double[] data = new double[2*n];
        int zs = 0;
        double sum = 0;
        for(int i = 0; i<2*n; i++)
        {
            double d = input.nextDouble();
            data[i] = d - (int)d;
            if(data[i] == 0) zs++;
            sum += data[i];
        }
        //System.out.println(sum);
        double best = 1e18;
        for(int i = n-(2*n-zs); i<=n && i <= zs; i++)
        {
            //System.out.println(i+" "+Math.abs(n-i-sum));
            if(i<0) continue;
            //use that many zeroes for rounding up
            best = Math.min(best, Math.abs(n-i-sum));
        }
        out.printf("%.3f\n", best);
        out.close();
    }
    static class Doub implements Comparable<Doub>
    {
        double a;
        public Doub(double aa)
        {
            a = aa;
        }
        @Override
        public int compareTo(Doub that) {
            // TODO Auto-generated method stub
            return (int)Math.signum(a-(int)(a) - (that.a - (int)that.a));
        }
        
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