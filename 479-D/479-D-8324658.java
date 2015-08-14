import java.util.*;
import java.io.*;
public class b {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int L = input.nextInt(), x = input.nextInt(), y = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    boolean hasX = false, hasY = false;
    HashSet<Integer> set = new HashSet<Integer>();
    for(int i = 0; i<n; i++)
    {
        set.add(data[i]);
        if(set.contains(data[i] - x)) hasX = true;
        if(set.contains(data[i] - y)) hasY = true;
    }
    if(hasX && hasY) out.println(0);
    else if(hasX) out.println(1+"\n"+y);
    else if(hasY) out.println(1+"\n"+x);
    else
    {
        boolean hasPair = false;
        int val = -1;
        for(int i = 0; i<n; i++)
        {
            if(set.contains(data[i] - (x+y)))
            {
                val = data[i] - x;
                hasPair = true;
            }
            if(set.contains(data[i] - (y-x)) && data[i] + x <= L)
            {
                val = data[i] + x;
                hasPair = true;
            }
            else if(set.contains(data[i] - (y-x)) && data[i] - y >= 0)
            {
                val = data[i] - y;
                hasPair = true;
            }
        }
        if(hasPair)
        {
            out.println(1+"\n"+val);
        }
        else
        {
            out.println(2);
            out.println(x+" "+y);
        }
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