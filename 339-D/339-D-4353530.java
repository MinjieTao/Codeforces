import java.util.*;
import java.io.*;

public class cfa {
    static long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        int n = input.nextInt(), m = input.nextInt();
        int[][] data = new int[n+1][(1<<n)];
        for(int i = 0; i<(1<<n); i++) data[0][i] = input.nextInt();
        int count = (1<<n);
        for(int i = 0; i<n; i++)
        {
            count /= 2;
            for(int j = 0; j<count; j++)
            {
                if((i&1) == 0)
                    data[i+1][j] = data[i][2*j] | data[i][2*j+1];
                else
                    data[i+1][j] = data[i][2*j] ^ data[i][2*j+1];
            }
        }
        for(int i = 0; i<m; i++)
        {
            int p = input.nextInt()-1, b = input.nextInt();
            data[0][p] = b;
            int at = p;
            for(int j = 0; j<n; j++)
            {
                if(j%2 == 0)
                {
                    data[j+1][at/2] = at%2 == 0 ? (data[j][at] | data[j][at+1]) : (data[j][at] | data[j][at-1]);
                }
                else
                {
                    data[j+1][at/2] = at%2 == 0 ? (data[j][at] ^ data[j][at+1]) : (data[j][at] ^ data[j][at-1]);
                }
                at = at/2;
            }
            out.println(data[n][0]);
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