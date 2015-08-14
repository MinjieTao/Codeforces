import java.util.*;
import java.io.*;
public class c {
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s = input.next();
        int a = input.nextInt(), b = input.nextInt(), n = s.length();
        int[] moda = new int[n], modb = new int[n];
        moda[0] = (s.charAt(0) - '0')%a;
        modb[0] = (s.charAt(0) - '0')%b;
        for(int i = 1; i<n; i++)
        {
            moda[i] = (10 * moda[i-1] + s.charAt(i) - '0')%a;
            modb[i] = (10 * modb[i-1] + s.charAt(i) - '0')%b; 
        }
        boolean found = false;
        //System.out.println(Arrays.toString(modb));
        int[] tenb = new int[n];
        tenb[0] = 1%b;
        for(int i = 1; i<n; i++) tenb[i] = (tenb[i-1] * 10)%b;
        for(int i = 1; i<n && !found; i++)
        {
            if(s.charAt(i) == '0') continue;
            if(moda[i-1] != 0) continue;
            //System.out.println(i);
            if(((long)modb[i-1] * tenb[n-i])%b != modb[n-1]) continue;
            out.println("YES" +"\n"+s.substring(0, i)+"\n"+s.substring(i));
            found = true;
        }
        if(!found) out.println("NO");
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