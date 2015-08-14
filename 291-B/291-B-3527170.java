import java.util.*;
import java.io.*;
public class b {
    public static void main(String[] args) throws IOException 
    {
        Scanner input = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s = input.nextLine();
        int n = s.length();
        StringBuilder cur = new StringBuilder("");
        boolean in = false;
        for(int i = 0; i<n; i++)
        {
            char c = s.charAt(i);
            if(c=='"')
            {
                if(!in) in = true;
                else
                {
                    out.print("<");
                    cur.append(">");
                    out.println(cur.toString());
                    cur = new StringBuilder("");
                    in = false;
                }
            }
            else
            {
                if(c==' ' && !in)
                {
                    if(cur.length() > 0)
                    {
                        out.print("<");
                        cur.append(">");
                        out.println(cur.toString());
                        cur = new StringBuilder("");
                    }
                }
                else cur.append(c);
            }
        }
        if(cur.length()>0)
        {
            out.print("<");
            cur.append(">");
            out.println(cur.toString());
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