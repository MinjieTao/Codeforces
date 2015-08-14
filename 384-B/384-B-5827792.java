import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    //Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    for(int i =0; i<n; i++) for(int j = 0; j<m; j++) input.nextInt();
    System.out.println(m*(m-1)/2);
    for(int i = 1; i<=m; i++)
        for(int j = i+1; j<=m; j++)
        {
            if(k == 0) System.out.println(i+" "+j);
            else System.out.println(j+" "+i);
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