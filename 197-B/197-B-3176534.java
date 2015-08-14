import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int[] p = new int[n+1], q = new int[m+1];
    for(int i = 0; i<p.length; i++) p[i] = input.nextInt();
    for(int i = 0; i<q.length; i++) q[i] = input.nextInt();
    if(n>m)
    {
        System.out.println(1.*p[0]/q[0] > 0 ? "Infinity" : "-Infinity");
    }
    else if(n<m)
    {
        System.out.println("0/1");
    }
    else
    {
        boolean neg = (p[0] < 0) ^ (q[0] < 0);
        p[0] = Math.abs(p[0]);
        q[0]=  Math.abs(q[0]);
        long g = gcd(p[0],q[0]);
        System.out.println((neg?"-":"")+p[0]/g+"/"+q[0]/g);
    }
    out.close();
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