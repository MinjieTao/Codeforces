import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        int n = input.nextInt()+1;
        long[] data = new long[n];
        data[0] = 0;
        for(int i = 0; i<n-1; i++) data[i+1] = input.nextInt();
        Arrays.sort(data);
        long[] ls = new long[n];
        ls[0] = data[0];
        for(int i = 1; i<n; i++) ls[i] = ls[i-1] + data[i];
        long[] rs = new long[n];
        rs[n-1] = data[n-1];
        for(int i = n-2; i>=0; i--) rs[i] = rs[i+1] + data[i];
        long num = 0;
        for(int i = 1;i<n; i++)
        {
            num += (long)data[i]*i - ls[i-1];
            if(i <n-1) num += rs[i+1] - (long)(n-i-1)*data[i];
            //System.out.println(num);
        }
        long denom = n-1;
        long g = gcd(num, denom);
        num /= g;
        denom /= g;
        out.println(num+" "+denom);
        
        
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