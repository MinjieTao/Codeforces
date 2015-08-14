import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    
    Scanner input = new Scanner(new File("input.txt"));
    PrintWriter out = new PrintWriter(new File("output.txt"));
    //PrintWriter out = new PrintWriter(System.out);
    //input.init(System.in);
    String[] outs = {"L","R"};
    String s = input.next();
    int i = input.nextInt()-1;
    if(s.equals("front"))
        out.println(outs[i]);
    else
        out.println(outs[1-i]);
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