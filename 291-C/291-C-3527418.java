import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class c {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        input.init(System.in);
        int n = input.nextInt(), k = input.nextInt();
        long[] data = new long[n];
        for(int i = 0; i<n; i++)
        {
            String s = input.next();
            StringTokenizer str = new StringTokenizer(s, ".");
            long x = 0;
            int shift = 24;
            while(str.hasMoreTokens())
            {
                String at = str.nextToken();
                x += (Long.parseLong(at) << shift);
                shift -= 8;
            }
            data[i] = x;
        }
        boolean found = false;
        for(int i = 1; i<32 && !found; i++)
        {
            long num = i, mask = 0;
            for(int j = 31; num > 0; num--) mask |= (1l<<(j--));
            TreeSet<Long> poss = new TreeSet<Long>();
            for(int j = 0; j<n; j++) poss.add(mask & (data[j]));
            //System.out.println(mask + " "+poss.size());
            if(poss.size() == k)
            {
                found = true;
                System.out.println((mask>>24) + "."+(mask>>16)%(1<<8)+"."+(mask>>8)%(1<<8)+"."+(mask)%(1<<8));
            }
        }
        if(!found) System.out.println(-1);
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