import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m =input.nextInt();
    boolean[][] data = new boolean[n][n];
    for(int i = 0; i<m; i++)
    {
        int x, y;
        data[x=input.nextInt()-1][y=input.nextInt()-1] = true;
        boolean good = false;
        for(int j= x-2; j<=x; j++)
            for(int k = y-2; k<=y; k++)
            {
                if(j<0 || k<0 || j+2>=n || k+2>=n) continue;
                boolean ok = true;
                for(int p = 0; p<3; p++)
                    for(int q = 0; q<3; q++)
                        ok &= data[j+p][k+q];
                good |= ok;
            }
        if(good)
        {
            System.out.println(i+1);
            return;
        }
    }
    System.out.println(-1);
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