import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    String s =input.next();
    int count = 0;
    ArrayList<Integer> data = new ArrayList<Integer>();
    for(int i = 0; i<s.length(); i++)
    {
        if(s.charAt(i)=='0')
            count++;
        else
        {
            data.add(count);
            count = 0;
        }
    }
    data.add(count);
    long res = 0;
    for(int i = 0; i+n<data.size(); i++)
        if(n==0) res += (long)(data.get(i))*(data.get(i)+1)/2;
        else res += (long)(1+data.get(i))*(1+data.get(i+n));
    System.out.println(res);
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