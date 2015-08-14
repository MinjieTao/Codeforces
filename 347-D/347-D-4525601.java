import java.util.*;
import java.io.*;

public class b {
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        // Scanner input = new Scanner(new File("input.txt"));
        // PrintWriter out = new PrintWriter(new File("output.txt"));
        input.init(System.in);
        PrintWriter out = new PrintWriter((System.out));
        
        s = input.next();
        t = input.next();
        u = input.next();
        memo = new int[s.length()+1][t.length()+1][u.length()+1];
        next = new int[s.length()+1][t.length()+1][u.length()+1];
        for(int[][] A: memo)
            for(int[] B: A)
                Arrays.fill(B, -987654322);
        indexMap = new HashMap<String, Integer>();
        int ans = go(0, 0, 0);
        if(ans == 0) out.println(ans);
        else
        {
            int a = 0, b = 0, c = 0;
            while(a<s.length() && b<t.length())
            {
                if(next[a][b][c] == 1)
                {
                    out.print(s.charAt(a));
                    c = index(a, b, c, s.charAt(a));
                    a++;
                    b++;
                }
                else if(next[a][b][c] == 2)
                    a++;
                else b++;
            }
        }
        out.close();
    }
    static String s, t, u;
    static int[][][] memo;
    static int[][][] next;
    static int go(int a, int b, int c)
    {
        if(c==u.length()) return -987654321;
        if(memo[a][b][c] != -987654322) return memo[a][b][c];
        int res = 0;
        if(a < s.length() && b < t.length() && s.charAt(a) == t.charAt(b))
        {
            int res1 = 1 + go(a+1, b+1, index(a, b, c, s.charAt(a)));
            if(res1 > res)
            {
                next[a][b][c] = 1;
                res = res1;
            }
        }
        if(a < s.length())
        {
            int res2 = go(a+1, b, c);
            if(res2 > res)
            {
                next[a][b][c] = 2;
                res = res2;
            }
        }
        if(b < t.length())
        {
            int res3 = go(a, b+1, c);
            if(res3 > res)
            {
                res = res3;
                next[a][b][c] = 3;
            }
        }
        return memo[a][b][c] = res;
    }
    static HashMap<String, Integer> indexMap;
    static int index(int a, int b, int c, char at)
    {
        String str = u.substring(0,c)+at;
        if(indexMap.containsKey(str)) return indexMap.get(str);
        //System.out.println(a+" "+b+" "+c+" "+at+" "+str);
        for(int i = str.length(); i> 0; i--)
            if(u.substring(0, i).equals(str.substring(str.length()-i, str.length())))
            {
                indexMap.put(str, i);
                return i;
            }
        indexMap.put(str, 0);
        return 0;
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