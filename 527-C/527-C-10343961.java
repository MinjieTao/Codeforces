import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    TreeMap<Integer, Integer> verts = new TreeMap<Integer, Integer>(), horiz = new TreeMap<Integer, Integer>();
    TreeSet<Integer> vs = new TreeSet<Integer>();
    TreeSet<Integer> hs = new TreeSet<Integer>();
    PrintWriter out = new PrintWriter(System.out);
    int w = input.nextInt(), h = input.nextInt(), n = input.nextInt();
    vs.add(0);
    vs.add(w);
    hs.add(0);
    hs.add(h);
    horiz.put(h, 1);
    verts.put(w, 1);
    for(int i = 0; i<n; i++)
    {
        char c = input.next().charAt(0);
        int x = input.nextInt();
        int lower = c == 'H' ? hs.lower(x) : vs.lower(x);
        int higher = c == 'H' ? hs.higher(x) : vs.higher(x);
        int key = higher - lower;
        TreeMap<Integer, Integer> cur = (c == 'H') ? horiz : verts;
        add(cur, key, -1);
        add(cur, higher-x, 1);
        add(cur, x-lower, 1);
        if(c == 'H') hs.add(x);
        else vs.add(x);
        out.println((long)horiz.lastKey() * verts.lastKey());
    }
    out.close();
}
static void add(TreeMap<Integer, Integer> map, int x, int v)
{
    if(!map.containsKey(x)) map.put(x, 0);
    map.put(x, map.get(x)+v);
    if(map.get(x) == 0) map.remove(x);
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