import java.util.*;
import java.io.*;
public class a {
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String s = input.next();
        int count = 0;
        int n = s.length();
        for(int i = 0; i<n; i++)
            if(s.charAt(i) == '#')
                count++;
        int[] res = new int[count];
        int diff = 0;
        for(int i = 0; i<n; i++)
            if(s.charAt(i) == '(')
                diff++;
            else if(s.charAt(i) == ')')
                diff--;
        if(diff < count) out.println(-1);
        else
        {
            Arrays.fill(res, 1);
            res[count-1] = diff - count + 1;
            int depth = 0;
            boolean good = true;
            int at = 0;
            for(int i = 0; i<n; i++)
            {
                if(s.charAt(i) == '(') depth++;
                else if(s.charAt(i) == ')') depth--;
                else depth -= res[at++];
                if(depth < 0) good = false;
            }
            if(good)
            {
                for(int x : res) out.println(x);
            }
            else out.println(-1);
        }
        
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