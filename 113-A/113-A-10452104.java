import java.io.*;
import java.util.*;
public class A86 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.nextLine();
    StringTokenizer str = new StringTokenizer(s," ");
    int m = 0, f = 0;
    int count = 0;
    while(str.hasMoreTokens())
    {
        count++;
        String cur = str.nextToken();
        if(m == 0 && cur.endsWith("lios"));
        else if(m == 0 && cur.endsWith("etr")) m = 1;
        else if(m == 1 && cur.endsWith("etr")) m = -1;
        else if(m == 1 && cur.endsWith("initis")) m++;
        else if(m == 2 && cur.endsWith("initis"));
        else m = -1;
        
        if(f == 0 && cur.endsWith("liala"));
        else if(f == 0 && cur.endsWith("etra")) f++;
        else if(f == 1 && cur.endsWith("etra")) f = -1;
        else if(f == 1 && cur.endsWith("inites")) f++;
        else if(f == 2 && cur.endsWith("inites"));
        else f = -1;
        
        if(count == 1 && !str.hasMoreTokens() && (cur.endsWith("inites") || cur.endsWith("initis"))) m = 1;
    }
    if(count == 1 && m != -1) m = 1;
    if(count == 1 && f != -1) f = 1;
    System.out.println(m < 1 && f < 1 ? "NO" : "YES");
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
    static String nextLine() throws IOException
    {
        return reader.readLine();
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