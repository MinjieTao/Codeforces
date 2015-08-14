import java.util.*;
import java.io.*;

public class cfa {
    static long mod = 1000000009;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        String s = input.next();
        int n = input.nextInt();
        boolean found = false;
        for(int i = 0; i<10; i++)
        {
            if(found) break;
            if(s.charAt(i) == '0') continue;
            boolean possible = true;
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(i+1);
            int suml = i+1, sumr = 0, last = i;
            for(int j = 0; j<n-1; j++)
            {
                int needed = 0;
                if(j%2 == 0) needed = suml - sumr;
                else needed = sumr - suml;
                boolean b = false;
                for(int k = 0; k<10; k++)
                {
                    if(s.charAt(k) == '0' || k < needed || k == last) continue;
                    ans.add(k+1);
                    last = k;
                    b = true;
                    if(j%2 == 0) sumr += k+1;
                    else suml += k+1;
                    break;
                }
                if(!b)
                {
                    possible = false;
                    break;
                }
            }
            if(possible)
            {
                found = true;
                out.println("YES");
                for(int x: ans) out.print(x+" ");
                break;
            }
        }
        if(!found) out.println("NO");
        
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