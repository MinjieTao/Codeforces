import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int vp = input.nextInt(), vd = input.nextInt(), t = input.nextInt(), f = input.nextInt(), c = input.nextInt();
    int res = 0;
    if(vp >= vd)
    {
        System.out.println(0);
        return;
    }
    double time = t + 1.*(t*vp)/(vd-vp);
    while(true)
    {
        if(vp*time >= c)
        {
            System.out.println(res);
            break;
        }
        res++;
        time += 1.*(vp*time)/vd + f;
        time += 1.*(time*vp)/(vd-vp);
    }
}
public static long gcd(long a, long b)
{
if(b == 0) return a;
return gcd(b, a%b);
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