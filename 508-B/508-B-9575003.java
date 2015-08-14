import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    char[] s = input.next().toCharArray();
    int n = s.length;
    String res = "";
    boolean[] found = new boolean[257];
    for(int i = 0; i<n-1; i++)
    {
        if((s[i] - '0')%2 == 0)
        {
            if(found[s[i]]) continue;
            found[s[i]] = true;
            char temp = s[i];
            s[i] = s[n-1];
            s[n-1] = temp;
            String ns = new String(s);
            if(res.length() == 0 || ns.compareTo(res) > 0) res = ns;
            temp = s[i];
            s[i] = s[n-1];
            s[n-1] = temp;
        }
    }
    found = new boolean[257];
    for(int i = n-2; i>=0; i--)
    {
        if((s[i] - '0')%2 == 0)
        {
            if(found[s[i]]) continue;
            found[s[i]] = true;
            char temp = s[i];
            s[i] = s[n-1];
            s[n-1] = temp;
            String ns = new String(s);
            if(res.length() == 0 || ns.compareTo(res) > 0) res = ns;
            temp = s[i];
            s[i] = s[n-1];
            s[n-1] = temp;
        }
    }
    if(res.length() == 0) res = "-1";
    out.println(res);
    
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