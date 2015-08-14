import java.io.*;
import java.util.*;
public class a {

    public static void main(String[] args) throws IOException {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt(), m = input.nextInt(), p = input.nextInt();
        int[] as = new int[n];
        for(int i = 0; i<n; i++) as[i] = input.nextInt();
        int[] bs = new int[m];
        for(int i =0; i<m; i++) bs[i] = input.nextInt();
        HashMap<Integer, Integer> bmap = new HashMap<Integer, Integer>();
        for(int i = 0; i<m; i++) inc(bs[i], bmap, 1);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i<p; i++)
        {
            HashMap<Integer, Integer> fs = new HashMap<Integer, Integer>();
            int count = 0;
            int j = i;
            int k = 0;
            for(j = i; j<n && k < m; j+=p, k++)
            {
                int val = as[j];
                if(get(val, fs) < get(val, bmap)) count++;
                inc(val, fs, 1);
            }
            //System.out.println(count);
            if(count == m) res.add(i);
            //System.out.println(fs);
            for(k = j; k<n; k += p)
            {
                int val = as[k];
                if(get(val, fs) < get(val, bmap))
                {
                    count++;
                }
                inc(val, fs, 1);
                int other = k - p * m;
                //System.out.println(as[other]+" "+val);
                if(get(as[other], fs) <= get(as[other], bmap)) count--;
                
                inc(as[other], fs, -1);
                if(count == m) res.add(other + p);
                //System.out.println((other+p)+" "+k+" "+fs);
                //System.out.println(count);
            }
        }
        
        
        
        
        Collections.sort(res);
        out.println(res.size());
        for(int x: res)
        {
            out.print((x+1)+" ");;
        }
        out.close();
    }
    static int get(int key, HashMap<Integer, Integer> map)
    {
        return map.containsKey(key) ? map.get(key) : 0;
    }
    static void inc(int key, HashMap<Integer, Integer> map, int v)
    {
        int nv = v+get(key, map);
        if(nv > 0) map.put(key,  nv);
        else map.remove(key);
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