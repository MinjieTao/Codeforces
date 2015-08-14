import java.util.*;
import java.io.*;
public class e {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt(), dx = input.nextInt(), dy = input.nextInt();
    TreeSet<Pair> set = new TreeSet<Pair>();
    int atx = 0, aty = 0;
    for(int i = 0; i<n; i++)
    {
        set.add(new Pair(atx, aty));
        atx = (atx+dx)%n;
        aty = (aty+dy)%n;
    }
    TreeMap<Tree, Integer> map = new TreeMap<Tree, Integer>();
    int res = 0;
    int xx = 0, yy = 0;
    for(int i = 0; i<m; i++)
    {
        int x = input.nextInt(), y = input.nextInt();
        Tree at = new Tree(x, y);
        Pair cur = set.floor(new Pair(x, y));
        at.x = (at.x - cur.x + n)%n;
        at.y = (at.y - cur.y + n)%n;
        if(!map.containsKey(at)) map.put(at,  1);
        else map.put(at, map.get(at)+1);
        if(map.get(at) > res)
        {
            res = map.get(at);
            xx = at.x;
            yy = at.y;
        }
        //res = Math.max(res, map.get(at));
    }
    System.out.println(xx+" "+yy);
}
static class Tree implements Comparable<Tree>
{
    int x, y;
    public Tree(int xx, int yy)
    {
        x = xx; y = yy;
    }
    @Override
    public int compareTo(Tree o) {
        // TODO Auto-generated method stub
        if(x != o.x) return x - o.x;
        return y - o.y; 
    }
}
static class Pair implements Comparable<Pair>
{
    int x, y;
    public Pair(int xx, int yy)
    {
        x = xx; y = yy;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return x - o.x;
    }
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