import java.util.*;
import java.io.*;
public class f {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), T = input.nextInt();
    PriorityQueue<Item> pq = new PriorityQueue<Item>();
    for(int i = 0; i<n; i++)
    {
        int t = input.nextInt(), q = input.nextInt();
        pq.add(new Item(t, q));
    }
    int res = 0;
    while(!pq.isEmpty())
    {
        Item e = pq.poll();
        if(e.cost == T)
        {
            res =Math.max(res, e.val);
            continue;
        }
        int nv = e.val;
        if(!pq.isEmpty() && pq.peek().cost == e.cost) nv += pq.poll().val;
        pq.add(new Item(e.cost+1, nv));
    }
    out.println(res);
    out.close();
}
static class Item implements Comparable<Item>
{
    int cost, val;
    public Item(int cc, int vv)
    {
        cost = cc; val = vv;
    }
    @Override
    public int compareTo(Item o) {
        // TODO Auto-generated method stub
        if(cost != o.cost) return cost - o.cost;
        return o.val - val;
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