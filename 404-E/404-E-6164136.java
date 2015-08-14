import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    String s = input.next();
    if(good(s))
    {
        System.out.println(1);
    }
    else
    {
        if(s.charAt(s.length()-1) == 'R') s = rev(s);
        int lo = 0, hi = 1000001;
        while(lo < hi - 1)
        {
            int mid = (lo+hi)/2;
            if(goodWallRight(s, mid)) lo = mid;
            else hi = mid;
        }
        System.out.println(lo);
    }
}
static String rev(String s)
{
    char[] ca = s.toCharArray();
    for(int i = 0; i<ca.length; i++) if(ca[i] == 'R') ca[i] = 'L'; else ca[i] = 'R';
    return new String(ca);
}
static boolean goodWallRight(String s, int pos)
{
    boolean[] vis = new boolean[2000001];
    int at = 1000000;
    vis[at] = true;
    int n = s.length();
    for(int i = 0; i<n; i++)
    {
        if(s.charAt(i) == 'L') at--;
        else if(at+1 != pos + 1000000) at++;
        if(i == n-1)
        {
            return vis[at] ? false : true;
        }
        vis[at] = true;
    }
    return true;
}
static boolean good(String s)
{
    boolean[] vis = new boolean[2000001];
    int at = 1000000;
    vis[at] = true;
    int n = s.length();
    for(int i = 0; i<n; i++)
    {
        if(s.charAt(i) == 'L') at--;
        else at++;
        if(i == n-1)
        {
            return vis[at] ? false : true;
        }
        vis[at] = true;
    }
    return true;
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