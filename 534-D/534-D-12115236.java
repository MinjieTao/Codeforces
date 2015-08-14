import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    TreeSet<Pair>[] groups = new TreeSet[3];
    for(int i = 0; i<3; i++) groups[i] = new TreeSet<Pair>();
    for(int i = 0; i<n; i++)
    {
        Pair p = new Pair(data[i], i);
        groups[p.v%3].add(p);
    }
    Pair last = new Pair(-1, 0);
    if(groups[0].size() < groups[1].size() || groups[1].size() < groups[2].size() || groups[0].size() > groups[2].size() + 1)
    {
        out.println("Impossible");
    }
    else
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean good = true;
        int sz = groups[2].size();
        for(int i = 0; i<sz; i++)
        {
            for(int j = 0; j<3; j++)
            {
                Pair p = groups[j].floor(new Pair(last.v+1, n));
                if(p == null) good = false;
                else
                {
                    groups[j].remove(p);
                    res.add(p.i);
                    last = p;
                }
            }
        }
        for(int i = 0; i<2; i++)
        {
            if(groups[i].size() > 0)
            {
                Pair p = groups[i].floor(new Pair(last.v+1, n));
                if(p == null || p.v > 1 + last.v) good = false;
                else
                {
                    res.add(p.i);
                    last = p;
                }
            }
        }
        if(good)
        {
            out.println("Possible");
            for(int x : res) out.print((x+1)+" ");
        }
        else out.println("Impossible");
    }
    out.close();
}
static class Pair implements Comparable<Pair>
{
    int v, i;
    public Pair(int vv, int ii)
    {
        v = vv; i = ii;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        if(v != o.v) return v - o.v;
        return i - o.i;
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