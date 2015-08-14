import java.util.*;
import java.io.*;
public class a
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        int n= Reader.nextInt(), m = Reader.nextInt(), x = Reader.nextInt(), y = Reader.nextInt();
        int[] vests = new int[n], solds = new int[m];
        for(int i= 0; i<n; i++) vests[i] = Reader.nextInt();
        for(int i = 0; i<m; i++) solds[i] = Reader.nextInt();
        int p1 = 0, p2 = 0, count=0;
        StringBuilder out = new StringBuilder();
        while(p1 < n && p2<m)
        {
            if(vests[p1] >= solds[p2]-y && vests[p1] <= solds[p2]+x)
            {
                out.append((p1+1) + " " + (p2+1) + "\n");
                p1++;
                p2++;
                count++;
            }
            else if(vests[p1] < solds[p2]-y)
            {
                p1++;
            }
            else
            {
                p2++;
            }
        }
        System.out.println(count + "\n" + out);
    }
    public static class Reader {
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
    }
}