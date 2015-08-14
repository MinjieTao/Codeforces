import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n1 = input.nextInt(), m1 = input.nextInt();
    int[][] d1 = new int[n1][m1];
    for(int i = 0; i<n1; i++)
    {
        String s = input.next();
        for(int j = 0; j<m1; j++)
            d1[i][j] = s.charAt(j)-'0';
    }
    
    int n2 = input.nextInt(), m2 = input.nextInt();
    int[][] d2 = new int[n2][m2];
    for(int i = 0; i<n2; i++)
    {
        String s = input.next();
        for(int j = 0; j<m2; j++)
            d2[i][j] = s.charAt(j)-'0';
    }
    int best = 0, bestx = 0, besty = 0;
    for(int x = -100; x<=100; x++)
        for(int y = -100; y<=100; y++)
        {
            int count = 0;
            for(int p = 0; p<n1; p++)
                for(int q = 0; q<m1; q++)
                {
                    int ny = p+x, nx = q+y;
                    if(ny >= 0 && ny < n2 && nx >= 0 && nx < m2)
                        count += d1[p][q]*d2[ny][nx];
                }
            if(count>best)
            {
                best = count;
                bestx = x;
                besty = y;
            }
        }
    System.out.println(bestx+" "+besty);
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