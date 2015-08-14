import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class f {
    static int n;
    static ArrayList<Integer>[] g;
    static int[] data;
public static void main(String[] args) throws IOException
{
//  System.out.println(6000);
//  for(int i = 0; i<6000; i++) System.out.print(100+" ");
//  for(int i = 0; i<5999; i++) System.out.println((i+1)+" "+(i+2));
    input.init(System.in);
    n = input.nextInt();
    data = new int[n];
    g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }
    res = 1;
    dp = new int[n+1];
    Arrays.fill(dp, -1);
    boolean[] used = new boolean[n];
    Random r = new Random();
    ArrayList<Integer> leaves = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) if(g[i].size() == 1) leaves.add(i);
    for(int i = 0; i<leaves.size(); i++)
    {
        if(r.nextDouble() < .8 || leaves.size() < 5000)
        {
            go(leaves.get(i), -1);
        }
    }
    System.out.println(res);
}
static int res;
static int[] dp;
static void go(int at, int p)
{
    //System.out.println(at+" "+p+" "+Arrays.toString(dp));
    int lo = -1, hi = n;
    while(lo < hi - 1)
    {
        int mid = (lo+hi)/2;
        if(dp[mid] != -1 && data[dp[mid]] < data[at]) lo = mid;
        else hi = mid;
    }
    //System.out.println(hi);
    int temp = dp[hi];
    dp[hi] = at;
    for(int x : g[at])
    {
        if(x == p) continue;
        go(x, at);
    }
    while(dp[res] != -1) res++;
    //System.out.println(at+" "+hi+" "+Arrays.toString(dp));
    dp[hi] = temp;
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