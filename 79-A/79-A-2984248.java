import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
    public static int mod = 1000000007;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int x = input.nextInt(), y = input.nextInt();
    int turn = 0;
    while(true)
    {
        if(turn == 0)
        {
            if(x >= 2 && y>= 2)
            {
                x-=2;
                y-=2;
            }
            else if(x>=1 && y>=12)
            {
                x--;
                y-= 12;
            }
            else if(y>=22)
            {
                y-=22;
            }
            else
            {
                System.out.println("Hanako");
                break;
            }
            turn = 1;
        }
        else
        {
            if(y>=22) y-=22;
            else if(x>=1 && y>=12)
            {
                x--;
                y-=12;
            }
            else if(x>=2 && y>=2)
            {
                x-=2;
                y-=2;
            }
            else
            {
                System.out.println("Ciel");
                break;
            }
            turn = 0;
        }
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