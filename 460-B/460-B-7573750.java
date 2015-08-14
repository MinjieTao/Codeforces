import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
    ArrayList<Integer> res = new ArrayList<Integer>();
    for(int sum = 1; sum < 100; sum++)
    {
        long need = 1;
        for(int i = 0; i<a; i++) need *= sum;
        need *= b;
        need += c;
        if(need > 0 && need < 1e9 && sum((int)need) == sum) res.add((int)need);
    }
    out.println(res.size());
    for(int x: res) out.print(x+" ");
    out.close();
}
static int sum(int x)
{
    int res = 0;
    while(x > 0)
    {
        res += x%10;
        x/=10;
    }
    return res;
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