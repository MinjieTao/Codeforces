import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s1 = input.next(), s2 = input.next();
    int idx = 0;
    for(int i = 0; i<s1.length(); i++)
    {
        if(idx < s2.length() && s1.charAt(i) == s2.charAt(idx)) idx++;
    }
    int[] f1 = new int[26], f2 = new int[26];
    for(int i = 0; i<s1.length(); i++) f1[s1.charAt(i) - 'a']++;
    for(int i = 0; i<s2.length(); i++) f2[s2.charAt(i) - 'a']++;
    boolean possible = true;
    for(int i = 0; i<26; i++) if(f2[i] > f1[i]) possible = false;
    if(!possible) System.out.println("need tree");
    else if(idx == s2.length()) System.out.println("automaton");
    else if(s2.length() < s1.length()) System.out.println("both");
    else System.out.println("array");
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