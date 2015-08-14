import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), k = input.nextInt();
    int lo = input.nextInt(), hi = input.nextInt();
    Client[] data = new Client[n];
    for(int i = 0; i<n; i++) data[i] = new Client(lo*input.nextInt()+hi*input.nextInt(),i);
    Arrays.sort(data);
    int res = 0;
    int i = 0;
    ArrayList<Integer> ind = new ArrayList<Integer>();
    while(true)
    {
        if(i==n)break;
        if(data[i].x <= k)
        {
            k-= data[i].x;
            ind.add(data[i].i);
            i++;
            res++;
        }
        else
            break;
    }
    System.out.println(res);
    for(int j: ind) System.out.print((j+1)+" ");
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