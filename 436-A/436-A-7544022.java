import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), x = input.nextInt();
    ArrayList<Candy> fruit = new ArrayList<Candy>(), caramel = new ArrayList<Candy>();
    for(int i = 0; i<n; i++)
    {
        int type = input.nextInt();
        Candy cur = new Candy(input.nextInt(), input.nextInt());
        if(type == 0) caramel.add(cur);
        else fruit.add(cur);
    }
    Collections.sort(caramel);
    Collections.sort(fruit);
    out.println(Math.max(go(caramel, fruit, x), go(fruit, caramel, x)));
    out.close();
}
static int go(ArrayList<Candy> first, ArrayList<Candy> second, int x)
{
    int type = 0;
    int count = 0;
    boolean[] used1 = new boolean[first.size()], used2 = new boolean[second.size()];
    while(true)
    {
        int next = -1;
        if(type == 0)
        {
            for(int k = 0; k<first.size(); k++) if(!used1[k] && first.get(k).h <= x) next = k;
            if(next == -1) return count;
            used1[next] = true;
            x += first.get(next).m;
        }
        else
        {
            for(int k = 0; k<second.size(); k++) if(!used2[k] && second.get(k).h <= x) next = k;
            if(next == -1) return count;
            used2[next] = true;
            x += second.get(next).m;
        }
        type = 1 - type;
        count++;
    }
}
static class Candy implements Comparable<Candy>
{
    int h, m;
    public Candy(int hh, int mm)
    {
        h = hh; m = mm;
    }
    @Override
    public int compareTo(Candy o) {
        // TODO Auto-generated method stub
        return m-o.m;
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