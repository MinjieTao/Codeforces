import java.util.*;
import java.io.*;
public class b {
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        HashMap<Integer, Integer> nexts = new HashMap<Integer, Integer>(), prevs = new HashMap<Integer, Integer>();
        int n = input.nextInt();
        for(int i = 0; i<n; i++)
        {
            int a = input.nextInt(), b = input.nextInt();
            nexts.put(a, b);
            prevs.put(b, a);
        }
        int[] res = new int[n];
        int at = 0;
        for(int i = 0; i<n/2; i++)
        {
            res[2*i+1] = nexts.get(at);
            at = res[2*i+1];
        }
        if(n%2 == 0)
        {
            at = 0;
            for(int i = n/2-1; i>=0; i--)
            {
                res[2*i] = prevs.get(at);
                at = res[2*i];
            }
        }
        else
        {
            int start = -1;
            for(int x : prevs.values())
            {
                if(!prevs.containsKey(x) && x != 0)
                {
                    start = x;
                }
            }
            at = start;
            for(int i = 0; i<= n/2; i++)
            {
                res[2*i] = at;
                //System.out.println(at);
                if(i != n/2) at = nexts.get(at);
            }
        }
        for(int x : res) out.print(x+" ");
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