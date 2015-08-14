import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    ArrayList<Integer> data = new ArrayList<Integer>();
    for(int i = 1; i*(i+1)/2<=n;i++)
        data.add(i*(i+1)/2);
    int i = 0, j = data.size()-1;
    boolean found = false;
    while(i<=j)
    {
        int sum = data.get(i)+data.get(j);
        if(sum > n)
            j--;
        else if(sum < n)
            i++;
        else
        {
            found = true;
            break;
        }
    }
    System.out.println(found?"YES":"NO");
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