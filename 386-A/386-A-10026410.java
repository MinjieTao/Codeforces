import java.io.*;
import java.util.*;
public class a {

    public static void main(String[] args) throws IOException {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = input.nextInt();
        int[] data = new int[n];
        int max = 0;
        int maxi = -1;
        for(int i = 0; i<n; i++)
        {
            data[i] = input.nextInt();
            if(data[i]  > max)
            {
                max = data[i];
                maxi=i+1;
            }
        }
        Arrays.sort(data);
        System.out.println(maxi+" "+data[n-2]);
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