import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int r1 = input.nextInt(), c1 = input.nextInt(), r2 = input.nextInt(), c2 = input.nextInt();
    int rook = 2;
    if(r1 == r2 || c1 == c2) rook = 1;
    int bishop = 2;
    if((r1+c1) %2 != (r2+c2)%2) bishop = 0;
    else if(r1+c1 == r2+c2 || r1 - c1 == r2 - c2) bishop = 1;
    int king = Math.max(Math.abs(r1 - r2), Math.abs(c1 - c2));
    out.println(rook+" "+bishop+" "+king);
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