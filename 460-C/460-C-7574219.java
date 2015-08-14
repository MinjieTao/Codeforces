import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), w = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
    }
    int lo = 1, hi = (int)(1e9+1e6);
    while(lo < hi - 1)
    {
        int mid = (lo+hi)>>1;
        int used = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i<n; i++)
        {
            while(!q.isEmpty() && q.peek() == i) q.poll();
            int need = Math.max(0, mid - data[i] - q.size());
            if(need + used > m)
            {
                used = m+1;
                break;
            }
            else
            {
                for(int j = 0; j<need; j++)
                {
                    q.add(i+w);
                    used++;
                }
            }
        }
        if(used <= m) lo = mid;
        else hi = mid;
    }
    out.println(lo);
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