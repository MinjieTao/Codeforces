import java.util.*;
import java.io.*;
public class e {
    public static void main(String[] args) throws IOException
    {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        char[][] data = new char[n][];
        for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
        boolean good = true;
        String[] res = new String[n];
        for(int i = 0; i<n; i++)
        {
            String prev = (i == 0 ? "" : res[i-1]);
            res[i] = go(prev, new String(data[i]));
            if(res[i] == null)
            {
                good = false;
                break;
            }
        }
        if(good) 
        {
            out.println("YES");
            for(String s : res) out.println(s);
        }
        else out.println("NO");
        
        out.close();
    }
    static String go(String last, String cur)
    {
        char[] res = cur.toCharArray();
        int n = cur.length();
        if(cur.length() < last.length()) return null;
        if(cur.length() > last.length())
        {
            for(int i = 0; i<n; i++)
            {
                if(res[i] == '?') res[i] = (i == 0 ? '1' : '0');
            }
            return new String(res);
        }
        if(!cur.contains("?")) return (cur.compareTo(last) > 0 ? cur : null);
        for(int i = 0; i<n; i++)
        {
            boolean flag = res[i] != '?';
            for(int j = (i == 0 ? 1 : 0); j<10; j++)
            {
                if(flag && j != res[i] - '0') continue;
                //System.out.println(i+" "+j);
                res[i] = (char) (j+'0');
                if(possible(new String(res), last)) break;
                if(!flag) res[i] = '?';
                if(j == 9) return null;
            }
        }
        return new String(res);
    }
    static boolean possible(String s, String t)
    {
        String p = s.replace('?', '9');
        return p.compareTo(t) > 0;
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