import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    //input.init(System.in);
    Scanner input = new Scanner(System.in);
    //int n = input.nextInt();
    String s1 = input.nextLine(), s2 = input.nextLine();
    int[] freq = new int[52];
    for(int i = 0; i<s1.length(); i++)
    {
        char c = s1.charAt(i);
        if(c>='A' && c<= 'Z') freq[c - 'A']++;
        else if(c<='z' && c>='a') freq[26+c-'a']++;
    }
    for(int i = 0; i<s2.length(); i++)
    {
        char c = s2.charAt(i);
        if(c>='A' && c<= 'Z') freq[c - 'A']--;
        else if(c<='z' && c>='a') freq[26+c-'a']--;
    }
    boolean res = true;
    for(int i = 0; i<52; i++) res &= freq[i] >= 0;
    System.out.println(res?"YES":"NO");
    
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