import java.util.*;
import java.io.*;
public class bb {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    String s = input.next(), t = input.next();
    int[][] swap = new int[26][26];
    for(int[] A : swap) Arrays.fill(A, -1);
            int[] neq = new int[26];
            Arrays.fill(neq, -1);
            int count = 0;
    for(int i = 0; i<n; i++)
    {
        int a = s.charAt(i) - 'a', b = t.charAt(i) - 'a';
        if(a != b)
        {
            count++;
            swap[a][b] = i+1;
            neq[a] = i+1;
        }
    }
    for(int i = 0; i<26; i++)
        for(int j = i+1; j<26; j++)
        {
            if(swap[i][j] != -1 && swap[j][i] != -1)
            {
                System.out.println(count - 2);
                System.out.println(swap[i][j]+" "+swap[j][i]);
                return;
            }
        }
    for(int i = 0; i<26; i++)
        for(int j = 0; j<26; j++)
        {
            if(swap[i][j] != -1 && neq[j] != -1)
            {
                System.out.println(count - 1);
                System.out.println(swap[i][j]+" "+neq[j]);
                return;
            }
        }
    System.out.println(count);
    System.out.println("-1 -1");
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