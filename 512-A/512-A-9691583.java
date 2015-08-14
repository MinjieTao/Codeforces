import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    String[] data = new String[n];
    boolean[][] g = new boolean[26][26];
    for(int i = 0; i<n; i++)
    {
        data[i] = input.next();
    }
    boolean good = true;
    for(int i = 0; i<n; i++)
        for(int j = i+1; j<n; j++)
        {
            for(int k = 0; k<data[i].length() && k < data[j].length(); k++)
            {
                if(data[i].charAt(k) != data[j].charAt(k))
                {
                    g[data[i].charAt(k)-'a'][data[j].charAt(k)-'a'] = true;
                    break;
                }
                if(k+1 == data[j].length()) good = false;
            }
        }
    for(int k = 0; k<26; k++)
        for(int i = 0; i<26; i++)
            for(int j = 0; j<26; j++)
                g[i][j] |= g[i][k] && g[k][j];
    for(int i = 0;i<26; i++) good &= !g[i][i]; 
    if(!good) out.println("Impossible");
    else
    {
        int[] ds = new int[26];
        for(int i = 0; i<26; i++)
            for(int j = 0; j<26; j++)
                if(g[i][j]) ds[j]++;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i<26; i++)
        {
            if(ds[i] == 0) q.add(i);
        }
        while(!q.isEmpty())
        {
            int at = q.poll();
            out.print((char)('a'+at));
            for(int i = 0; i<26; i++)
            {
                if(g[at][i])
                {
                    ds[i]--;
                    if(ds[i] == 0) q.add(i);
                }
            }
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