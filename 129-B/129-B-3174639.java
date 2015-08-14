import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
    PrintWriter out = new PrintWriter(System.out);
    input.init(System.in);
    int n = input.nextInt(), m = input.nextInt();
    boolean[][] adj = new boolean[n][n];
    for(int i = 0; i<m; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        adj[a][b] = adj[b][a] = true;
    }
    int res = 0;
    for(int i = 0; i<n; i++)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int j = 0; j<n; j++)
        {
            int count = 0;
            for(int k = 0; k<n; k++)
                if(adj[j][k]) count++;
            if(count == 1)
            {
                list.add(j);
            }
        }
        if(list.size()>0)res++;
        for(int j: list)
        {
            for(int k = 0; k<n; k++)
                adj[j][k] = adj[k][j]=  false;
        }
    }
    out.println(res);
    out.close();
}
public static long gcd(long a, long b)
{
if(b == 0) return a;
return gcd(b, a%b);
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