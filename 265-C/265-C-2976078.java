import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    PrintWriter out = new PrintWriter(System.out);
    ArrayList<Integer> left = new ArrayList<Integer>(), right = new ArrayList<Integer>();
    int n = s.length();
    for(int i = 0; i<n; i++)
        if(s.charAt(i) == 'l')
            left.add(i+1);
        else
            right.add(i+1);
    for(int i: right)
        out.println(i);
    for(int i = left.size()-1; i>=0;i--)
        out.println(left.get(i));
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
}
}