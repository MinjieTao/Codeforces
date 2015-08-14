import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    boolean[] sieve = new boolean[3000];
    int n = input.nextInt(), k = input.nextInt();
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for(int i = 2; i<= 2000; i++)
    {
        boolean p = true;
        for(int j = 2; j<i; j++)
            if(i%j == 0)
            {
                p = false;
                break;
            }
        if(p) 
            {primes.add(i); sieve[i]=true;}
    }
    ArrayList<Integer> sums = new ArrayList<Integer>();
    for(int i= 0; i<primes.size()-1; i++)
    {
        sums.add(primes.get(i)+primes.get(i+1)+1);
    }
    int count = 0;
    for(int i = 2; i<=n; i++)
    {
        boolean found = false;
        for(int j = 0; j<sums.size(); j++)
            found |= sums.get(j) == i;
        if(found && sieve[i])
            count++;
    }
    System.out.println(count >= k?"YES":"NO");
    
    
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