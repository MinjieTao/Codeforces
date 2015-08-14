import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String s = input.next();
    int n = s.length();
    int m = input.nextInt();
    int[] xs = new int[n], ys = new int[n], zs = new int[n];
    for(int i = 0; i<n; i++)
    {
        if(i > 0)
        {
            xs[i] = xs[i-1]; ys[i] = ys[i-1]; zs[i] = zs[i-1];
        }
        char c = s.charAt(i);
        if(c == 'x') xs[i]++;
        else if(c == 'y') ys[i]++;
        else if(c == 'z') zs[i]++;
    }
    for(int i = 0; i<m; i++)
    {
        int l = input.nextInt()-1, r = input.nextInt()-1, len = r - l + 1;
        int cx = xs[r] - (l == 0 ? 0 : xs[l-1]);
        int cy = ys[r] - (l == 0 ? 0 : ys[l-1]);
        int cz = zs[r] - (l == 0 ? 0 : zs[l-1]);
        if(len <= 2) out.println("YES");
        else if(cx > cy+1 || cx > cz+1 || cy > cx+1 || cy > cz+1 || cz > cx+1 || cz > cy+1) out.println("NO");
        else out.println("YES");
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