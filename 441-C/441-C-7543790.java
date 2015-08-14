import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    ArrayList<Integer> rs = new ArrayList<Integer>(), cs = new ArrayList<Integer>(); 
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            rs.add(i+1);
            if(i%2 == 0) cs.add(j+1);
            else cs.add(m - j);
        }
    int at = 0;
    for(int i = 0; i<k-1; i++)
    {
        out.println(2+" "+rs.get(at)+" "+cs.get(at)+" "+rs.get(at+1)+" "+cs.get(at+1));
        at+=2;
    }
    out.print(n*m - 2*(k-1));
    while(at < n*m)
    {
        out.print(" "+rs.get(at)+" "+cs.get(at));
        at++;
    }
    out.println();
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