import java.io.*;
import java.util.*;
public class a {

    public static void main(String[] args) throws IOException {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TreeSet<Integer> primes = new TreeSet<Integer>();
        boolean[] sieve = new boolean[100000];
        Arrays.fill(sieve, true);
        for(int i = 2; i<sieve.length; i++)
        {
            for(long j = (long)i*i; j<sieve.length; j+=i)
            {
                sieve[(int)j] = false;
            }
        }
        for(int i = 2; i<100000; i++)
            if(sieve[i])
                primes.add(i);
        int n = input.nextInt();
        int[] data = new int[n];
        int[] pos = new int[n];
        for(int i = 0; i<n; i++)
        {
            int a = input.nextInt()-1;
            data[i] = a;
            pos[a] = i;
        }
        ArrayList<Integer> as = new ArrayList<Integer>(), bs = new ArrayList<Integer>();
        for(int i = 0; i<n; i++)
        {
            int idx = pos[i];
            int diff = pos[i] - i;
            //System.out.println(i+" "+pos[i]);
            while(diff > 0)
            {
                int shift = primes.floor(diff+1) - 1;
                int other = pos[i] - shift;
                //System.out.println(shift+" "+other+" "+pos[i]);
                swap(data, pos, pos[i], other);
                //System.out.println(Arrays.toString(data)+" "+Arrays.toString(pos));
                as.add(idx+1);
                bs.add(other+1);
                idx = pos[i];
                diff = pos[i] - i;
            }
        }
        out.println(as.size());
        for(int i = 0; i<as.size(); i++)
        {
            int a = as.get(i), b = bs.get(i);
            if(a > b)
            {
                int temp = a; a = b; b = temp;
            }
            out.println(a+" "+b);
        }
        out.close();
    }
    static void swap(int[] data, int[] pos, int i, int j)
    {
        int posi = pos[data[i]];
        int posj = pos[data[j]];
        int datai = data[i];
        int dataj = data[j];
        data[i] = dataj;
        data[j] = datai;
        pos[data[j]] = posj;
        pos[data[i]] = posi;
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