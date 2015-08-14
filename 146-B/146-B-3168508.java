import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt();
    while(true)
    {
        a++;
        if(mask(a)==b)
        {
            System.out.println(a);
            break;
        }
    }
}
public static int mask(int n)
{
    String s = n+"";
    String out = "";
    for(int i = 0; i<s.length(); i++)
    {
        if(s.charAt(i)=='4' || s.charAt(i)=='7')
            out += s.charAt(i);
    }
    if(out.length()==0) return -1;
    return Integer.parseInt(out);
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