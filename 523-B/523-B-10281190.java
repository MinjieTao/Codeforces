import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), T = input.nextInt();
    double c = input.nextDouble();
    double[] firsts = new double[n];
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    double sum = 0;
    for(int i = 0; i<T; i++) sum += data[i];
    firsts[T-1] = sum;
    for(int i = T; i<n; i++)
    {
        sum += data[i];
        sum -= data[i-T];
        firsts[i] = sum;
    }
    for(int i = 0; i<n; i++) firsts[i] /= T;
    //System.out.println(Arrays.toString(firsts));
    double[] seconds = new double[n];
    double at = 0;
    for(int i = 0; i<n; i++)
    {
        at = (at + data[i] * 1.0 / T) / c;
        seconds[i] = at;
    }
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int x = input.nextInt()-1;
        double a = firsts[x], b = seconds[x];
        out.printf("%.6f %.6f %.6f\n", a, b, Math.abs(a - b)/a);
    }
    out.close();
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