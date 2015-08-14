import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int[] vs = new int[26];
    for(int i = 0; i<26; i++) vs[i] = input.nextInt();
    String s = input.next();
    int n = s.length();
    long[] csum = new long[n+1];
    for(int i = 1; i<=n; i++) csum[i] = vs[s.charAt(i-1) - 'a'] + csum[i-1];
    TreeSet<Long> set = new TreeSet<Long>();
    for(long x :csum) set.add(x);
    HashMap<Long, Integer> comp = new HashMap<Long, Integer>();
    int at = 0;
    for(long x : set) comp.put(x, at++);
    int[] cs = new int[n+1];
    for(int i = 0; i<=n; i++) cs[i] = comp.get(csum[i]);
    //System.out.println(Arrays.toString(cs));
    int[][] count = new int[n+1][26];
    long res = 0;
    for(int i = 0; i<n; i++)
    {
        //System.out.println(cs[i]);
        res += count[cs[i]][s.charAt(i) - 'a'];
        count[cs[i+1]][s.charAt(i)-'a']++;
    }
    System.out.println(res);
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