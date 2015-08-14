import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int[] ds = new int[n], ss = new int[n];
    for(int i = 0; i<n; i++)
        ds[i] = input.nextInt();
    for(int i = 0; i<n; i++)
        ss[i] = input.nextInt();
    int gas = 0;
    int max = ss[0];
    int time = 0;
    for(int i = 0; i<n; i++)
    {
        gas += ss[i];
        max = Math.max(max, ss[i]);
        time += ds[i];
        gas -= ds[i];
        while(gas<0)
        {
            gas += max;
            time+=k;
        }
    }
    System.out.println(time);
}
public static class Client implements Comparable<Client>
{
    int x, i;
    public Client(int x, int i)
    {
        this.x = x;
        this.i = i;
    }
    @Override
    public int compareTo(Client that) {
        // TODO Auto-generated method stub
        return this.x-that.x;
    }
    
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