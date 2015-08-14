import java.util.*;
import java.io.*;
import java.math.*;
public class b {
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = input.nextInt();
        for(int t =0; t<T; t++)
        {
            long n = input.nextInt();
            if(isPrime(n+1))
            {
                BigInteger[] res = get(n);
                out.println(res[0].longValue()+"/"+res[1].longValue());
            }
            else
            {
                long prev = prevPrime(n);
                BigInteger[] first = get(prev-1);
                int next = nextPrime(n);
                //System.out.println(prev+" "+next););
                BigInteger[] second = new BigInteger[]{(new BigInteger(""+(n-prev+1))), new BigInteger(""+(prev*next))};
                BigInteger g = gcd(second[0], second[1]);
                //System.out.println(second[0]+" "+second[1]);
                second[0] = second[0].divide(g);
                second[1] = second[1].divide(g);
                first = add(first, second);
                out.println(first[0].toString()+"/"+first[1].toString());
            }
        }
        
        
        out.close();
    }
    static int prevPrime(long n)
    {
        int cur = (int)n;
        while(cur>1)
        {
            if(isPrime(cur)) return cur;
            cur--;
        }
        return 1;
    }
    static int nextPrime(long n)
    {
        int cur = (int)n+1;
        while(cur < 2e9)
        {
            if(isPrime(cur)) return cur;
            cur++;
        }
        return cur;
    }
    static boolean isPrime(long n)
    {
        for(int i = 2; i<=Math.sqrt(n); i++) if(n%i == 0) return false;
        return true;
    }
    static BigInteger[] add(BigInteger[] a, BigInteger[] b)
    {
        BigInteger num = a[0].multiply(b[1]).add(a[1].multiply(b[0]));
        BigInteger denom = a[1].multiply(b[1]);
        BigInteger g = gcd(num, denom);
        return new BigInteger[]{num.divide(g), denom.divide(g)};
    }
    static BigInteger[] get(long n)
    {
        long num = n-1;
        long denom = 2*n+2;
        long g = gcd(num, denom);
        num /= g;
        denom /= g;
        return new BigInteger[]{new BigInteger(""+num), new BigInteger(""+denom)};
    }
    static long gcd(long a, long  b)
    {
        return b == 0 ? a : gcd(b, a%b);
    }
    static BigInteger gcd(BigInteger a, BigInteger b)
    {
        if(b.toString().equals("0")) return a;
        return gcd(b, a.mod(b));
    }
    public static class input {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(
                         new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                       reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }
        
        static double nextDouble() throws IOException {
            return Double.parseDouble( next() );
        }
        static long nextLong() throws IOException {
            return Long.parseLong( next() );
        }
    }
}