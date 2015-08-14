import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String s = input.next(), t = input.next();
    int n = s.length();
    char[] ss = new char[n];
    for(int i = 0; i<n; i++) ss[i] = s.charAt(i);
    for(int i = n-1; i>=0; i--)
    {
        if(ss[i] != 'z')
        {
            ss[i]++;
            for(int j= i+1; j<n; j++) ss[j] = 'a';
            break;
        }
    }
    String sss = new String(ss);
    if(!sss.equals(t))
    {
        out.println(sss);
    }
    else out.println("No such string");
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