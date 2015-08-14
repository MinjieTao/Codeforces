import java.util.*;
import java.io.*;
public class d
{
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n];
        for(int i = 0; i<n; i++)
        {
            g[i] = new ArrayList<Integer>();
        }
        int[] as = new int[n], bs = new int[n], cs = new int[n];
        for(int i = 0; i<n-1; i++)
        {
            as[i] = input.nextInt()-1;
            bs[i] = input.nextInt()-1;
            cs[i] = input.nextInt();
            g[as[i]].add(bs[i]);
            g[bs[i]].add(as[i]);
        }
        ArrayList<Integer>[] tree = new ArrayList[n];
        for(int i = 0; i<n; i++) tree[i] = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        int[] ps = new int[n];
        Arrays.fill(ps, -2);
        ps[0] = -1;
        while(!q.isEmpty())
        {
            int at = q.poll();
            for(int e: g[at])
            {
                if(ps[e] != -2) continue;
                q.add(e);
                ps[e] = at;
                tree[at].add(e);
            }
        }
        int[] subtreeSizes = new int[n];
        Queue<Integer> topsort = new LinkedList<Integer>();
        int[] degs = new int[n];
        for(int i = 0; i<n; i++) if(degs[i] == tree[i].size()) topsort.add(i);
        while(!topsort.isEmpty())
        {
            int at = topsort.poll();
            if(ps[at] != -1)
            {
                degs[ps[at]]++;
                if(degs[ps[at]] == tree[ps[at]].size()) topsort.add(ps[at]);
            }
            subtreeSizes[at] = 1;
            for(int e: tree[at]) subtreeSizes[at] += subtreeSizes[e];
        }
        double cur = 0;
        for(int i = 0; i<n-1; i++) cur += cs[i] * prob(n, Math.min(subtreeSizes[as[i]], subtreeSizes[bs[i]]));
        //out.println(cur);
        int m = input.nextInt();
        for(int i = 0; i<m; i++)
        {
            int edge = input.nextInt()-1, nval = input.nextInt();
            cur -= (cs[edge] - nval) * prob(n, Math.min(subtreeSizes[as[edge]], subtreeSizes[bs[edge]]));
            out.println(cur);
            cs[edge] = nval;
        }
        out.close();
    }
    static double prob(double n, double subtreeSize)
    {
        double res = subtreeSize * (n - subtreeSize) * (n - subtreeSize - 1);
        res += (n - subtreeSize) * subtreeSize * (subtreeSize - 1);
        return res / (n * (n-1) * (n-2) / 6);
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