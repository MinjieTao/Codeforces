import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
    public static int mod = 1000000007;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    int neg = s.indexOf('-');
    if(neg > -1) s = s.substring(1);
    int point = s.indexOf('.');
    if(point == -1)
    {
        int count = 0;
        for(int i = s.length()-1; i>=0; i--)
        {
            count++;
            if(count%3 == 0&&i>0)
                s = s.substring(0,i)+","+s.substring(i);
        }
        if(neg>-1)
            System.out.println("($"+s+".00)");
        else
            System.out.println("$"+s+".00");
    }
    else
    {
        String part1 = s.substring(0, point);
        int count = 0;
        for(int i = part1.length()-1; i>=0; i--)
        {
            count++;
            if(count%3 == 0&&i>0)
                part1 = part1.substring(0,i)+","+part1.substring(i);
        }
        String part2 = s.substring(point+1);
        while(part2.length()<2) part2 = part2+'0';
        if(neg>-1)
        {
            System.out.println("($"+part1+"."+part2.substring(0, 2)+")");
        }
        else
            System.out.println("$"+part1+"."+part2.substring(0, 2));
    }
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