import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String s = input.next();
    int n = s.length();
    int res = n;
    ArrayList<Integer> nonzero = new ArrayList<Integer>();
    int length = 0;
    for(int i = 0; i<s.length(); i++) if(s.charAt(i) != '0') nonzero.add(i);
    int k = nonzero.size();
    for(int i = 0; i<k; i++)
    {
        int curLength = i == k - 1 ? s.length() - nonzero.get(i) : nonzero.get(i+1) - nonzero.get(i);
        //System.out.println(length+" "+curLength);
        if(curLength > length)
        {
            res = k - i;
        }
        else if(curLength == length)
        {
            boolean good = true;
            for(int j = 0; j<length; j++)
            {
                if(s.charAt(j) < s.charAt(nonzero.get(i)+j))
                {
                    good = false;
                    break;
                }
            }
            if(!good) res = k - i;
        }
        length += curLength;
    }
    out.println(res);
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