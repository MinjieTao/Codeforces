import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    for(int i =0; i<n; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        int t = input.nextInt();
        if(a==b)
            out.println(t);
        else
        {
            int starttime = t;
            int x = t%(2*(m-1));
            if(x<=a-1)
                starttime = t + (a-1-x);
            else if(x<= m-1+m-a)
                starttime = t + (m-1+m-a-x);
            else
                starttime = t + (2*(m-1)-x) + (a-1);
            int endtime = starttime;
            if(b!=a)
            {
                boolean up = starttime%(2*(m-1)) <= m-1;
                if(up && b>a)
                    endtime += b -a;
                else if(!up && b<a)
                    endtime += a-b;
                else if(up)
                {
                    endtime += m-a + m-b;
                }
                else
                    endtime += a+b-2;
            }
            out.println(endtime);
        }
    }
    out.close();
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