import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class b {
    static long mod = (long)(1e9+9);
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] xs = new int[n], ys = new int[n];
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    long[] invMap = new long[n];
    for(int i = 0; i<n; i++)
    {
        xs[i] = input.nextInt() + (int)1e9;
        ys[i] = input.nextInt();
        long key = key(xs[i], ys[i]);
        map.put(key, i);
        invMap[i] = key;
    }
    TreeSet<Integer> q = new TreeSet<Integer>();
    ArrayList<Integer>[] g = new ArrayList[n], grev = new ArrayList[n];
    for(int i = 0; i<n; i++)
    {
        g[i] = new ArrayList<Integer>();
        grev[i] = new ArrayList<Integer>();
        long key1 = key(xs[i], ys[i] - 1);
        if(map.containsKey(key1)) g[i].add(map.get(key1));
        long key2 = key(xs[i]+1, ys[i] - 1);
        if(map.containsKey(key2)) g[i].add(map.get(key2));
        long key3 = key(xs[i]-1, ys[i] - 1);
        if(map.containsKey(key3)) g[i].add(map.get(key3));
    }
    for(int i = 0; i<n; i++)
        for(int e: g[i])
            grev[e].add(i);
    int[] above = new int[n];
    int[] below = new int[n];
    for(int i = 0; i<n; i++)
    {
        above[i] = grev[i].size();
        below[i] = g[i].size();
    }
    for(int i = 0; i<n; i++) q.add(i);
    for(int i = 0; i<n; i++)
        if(below[i] == 1)
        {
            q.remove(g[i].get(0));
        }
    long[] pows = new long[n];
    pows[0] = 1;
    for(int i = 1; i<n; i++)
        pows[i] = (pows[i-1] * n)%mod;
    long res = 0;
    int turn = 0;
    boolean[] used = new boolean[n];
    while(!q.isEmpty())
    {
        int at = (turn%2 == 0) ? q.pollLast() : q.pollFirst();
        //System.out.println(at+" "+Arrays.toString(above)+" "+Arrays.toString(below)+" "+q);
        used[at] = true;
        res += (at * pows[n-1-turn])%mod;
        res %= mod;
        for(int e: g[at])
        {
            grev[e].remove(new Integer(at));
            above[e]--;
            if(below[at] == 1 && !used[e])
            {
                boolean good = true;
                for(int ee : grev[e])
                {
                    if(below[ee] == 1 && !used[ee]) good = false;
                }
                if(!good) continue;
                //used[e] = true;
                q.add(e);
            }
        }
        for(int e : grev[at])
        {
            g[e].remove(new Integer(at));
            below[e]--;
            if(below[e] == 1)
            {
                for(int ee : g[e])
                {
                    if(q.contains(ee))
                    {
                        used[ee] = false;
                        q.remove(ee);
                    }
                }
            }
        }
        
        turn++;
    }
    System.out.println(res);
}
static int[] decode(long key)
{
    return new int[]{(int)(key / (int)(1e9+1)), (int)key % ((int)1e9+1)};
}
static long key(int x, int y)
{
    return x * ((long)(1e9+1)) + y;
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