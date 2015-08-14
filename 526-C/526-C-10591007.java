import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    long c = input.nextInt(), hr = input.nextInt(), hb = input.nextInt(), wr = input.nextInt(), wb = input.nextInt();
//  if(wr <= wb && hr >= hb)
//  {
//      out.println((c / wr) * hr);
//  }
//  else if(wb <= wr && hb >= hr)
//  {
//      out.println((c/wb) * hb);
//  }
//  else
    {
//      long lcm = lcm(wr, wb);
//      long rval = (lcm / wr) * hr;
//      long bval = (lcm / wb) * hb;
//      long res = c / lcm * Math.max(rval, bval);
//      c %= lcm;
        long res = 0;
        //out.println(res);
        long lo = 0, hi = c / wr;
//      while(hi  >lo + 3)
//      {
//          long m1 = (lo+lo+hi)/3, m2 = (lo+hi+hi)/3;
//          long f1 = m1 * hr + ((c - m1*wr) / wb) * hb;
//          long f2 = m2 * hr + ((c - m2*wr) / wb) * hb;
//          if(f1 > f2) hi = m2;
//          else lo = m1;
//      }
        lo = (lo+hi)/2;
        long add = 0;
        for(long i = Math.max(0, lo - 10000000); i <= Math.min(c / wr, lo + 1000000); i++)
        {
            long f = i * hr + ((c - i * wr) / wb) * hb;
            add = Math.max(add, f);
        }
        for(long i = 0; i <= 10000000 && i <= c / wr; i++)
        {
            long f = i * hr + ((c - i * wr) / wb) * hb;
            add = Math.max(add, f);
        }
        for(long i = Math.max(0, c / wr - 10000000); i <= c / wr; i++)
        {
            long f = i * hr + ((c - i * wr) / wb) * hb;
            add = Math.max(add, f);
        }
        out.println(res + add);
    }
    out.close();
}
static long gcd(long a, long b)
{
    return b == 0 ? a : gcd(b, a%b);
}
static long lcm(long a, long b)
{
    return a / gcd(a, b) * b;
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