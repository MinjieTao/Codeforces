import java.util.*;
import java.io.*;

public class cfa {
    static long mod = 1000000009;
    static class Pair1 implements Comparable<Pair1>
    {
        int a, b, i;
        public Pair1(int aa, int bb, int ii)
        {
            a = aa; b = bb; i = ii;
        }
        @Override
        public int compareTo(Pair1 o) {
            // TODO Auto-generated method stub
            if(this.b == o.b) return o.a - this.a;
            return o.b - this.b;
        }
    }
    static class Pair2 implements Comparable<Pair2>
    {
        int a, b, i;
        public Pair2(int aa, int bb, int ii)
        {
            a = aa; b = bb; i = ii;
        }
        @Override
        public int compareTo(Pair2 o) {
            // TODO Auto-generated method stub
            if(this.a == o.a) return o.b - this.b;
            return o.a - this.a;
        }
    }
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        
        int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
        if(a>b+c || b>a+c || c>a+b) out.println("Impossible");
        else
        {
            int y = (a-b+c)/2, x = a-y, z = c-y;
            if(x+z==b) out.println(x+" "+z+" "+y);
            else out.println("Impossible");
        }
        
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