import java.util.*;
import java.io.*;
public class d {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    long time = System.currentTimeMillis();
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    int[] bad = new int[k];
    boolean[] mark = new boolean[n];
    for(int i = 0; i<k; i++) mark[bad[i] = input.nextInt()-1] = true;
    ArrayList<Integer>[] g = new ArrayList[n];
    for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }

    double lo = 0, hi = 1;
    int[] degs = new int[n];
    for(int i = 0; i<n; i++) degs[i] = g[i].size();
    int[] have = new int[n];
    for(int i = 0; i<n; i++)
    {
        have[i] = degs[i];
        for(int e : g[i]) if(mark[e]) have[i]--;
    }
    //System.out.println(Arrays.toString(mark));
    ArrayList<Integer> set = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) if(!mark[i]) set.add(i);
    for(int iter = 0; iter < 50; iter++)
    {
        if(System.currentTimeMillis() - time > 1900) break;
        double mid = (lo+hi)/2;
        int[] need = new int[n];
        for(int i = 0; i<n; i++) need[i] = (int)Math.ceil(mid * degs[i]);
        int[] cur = new int[n];
        Queue<Integer> remove = new LinkedList<Integer>();
        for(int i = 0; i<n; i++)
        {
            cur[i] = have[i];
            if(cur[i] < need[i] && !mark[i]) remove.add(i);
        }
        boolean[] rem = new boolean[n];
        while(!remove.isEmpty())
        {
            int at = remove.poll();
            rem[at] = true;
            for(int e : g[at])
            {
                cur[e]--;
                if(cur[e] == need[e] - 1 && !mark[e])
                {
                    remove.add(e);
                }
            }
        }
        ArrayList<Integer> valid = new ArrayList<Integer>();
        for(int i = 0; i<n; i++) if(!mark[i] && !rem[i]) valid.add(i);
        if(valid.size() > 0)
        {
            set = valid;
            lo = mid;
        }
        else hi = mid;
    }
    out.println(set.size());
    for(int x : set) out.print((x+1)+" ");
    
    out.close();
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