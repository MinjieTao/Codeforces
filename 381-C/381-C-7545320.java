import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int m = input.nextInt();
    ArrayList<Integer> types = new ArrayList<Integer>(), ls = new ArrayList<Integer>(), cs = new ArrayList<Integer>();
    for(int i  =0; i<m; i++)
    {
        types.add(input.nextInt());
        ls.add(input.nextInt());
        if(types.get(i) == 2) cs.add(input.nextInt());
        else cs.add(0);
    }
    ArrayList<Integer> seq = new ArrayList<Integer>();
    int n = input.nextInt();
    long[] qs = new long[n];
    for(int i = 0; i<n; i++) qs[i] = input.nextLong()-1;
    int ptr = 0;
    long length = 0;
    for(int i = 0; i<m; i++)
    {
        if(types.get(i) == 1)
        {
            if(seq.size() < 100000) seq.add(ls.get(i));
            length++;
            if(ptr < n && length == qs[ptr]+1)
            {
                out.print(ls.get(i)+" ");
                ptr++;
            }
        }
        else
        {
            //out.println(i+" "+cs.get(i)+" "+ls.get(i));
            long nl = length + cs.get(i) * ls.get(i);
            for(int k = 0; k<cs.get(i) && seq.size() < 100000; k++)
                for(int j = 0; j<ls.get(i) && seq.size() < 100000; j++)
                    seq.add(seq.get(j));
            while(ptr < n && nl > qs[ptr])
            {
                out.print(seq.get((int)(qs[ptr]-length)%ls.get(i))+" ");
                ptr++;
            }
            length = nl;
            //out.println(seq.size());
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