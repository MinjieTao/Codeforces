import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    //Scanner input = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt();
    int[][] data = new int[n][];
    for(int i = 0; i<n; i++)
    {
        int m = input.nextInt();
        data[i] = new int[m];
        for(int j = 0; j<m; j++) data[i][j] = input.nextInt();
    }
    for(int i = 0; i<n; i++)
    {
        boolean good = true;
        for(int j = 0; j<n; j++)
        {
            if(i==j) continue;
            boolean sub = true;
            for(int k = 0; k<data[j].length; k++)
            {
                boolean found = false;
                for(int l = 0; l<data[i].length; l++)
                {
                    if(data[i][l] == data[j][k])
                    {
                        found = true;
                        break;
                    }
                }
                if(!found)
                {
                    sub = false;
                    break;
                }
            }
            if(sub)
            {
                good = false;
                break;
            }
        }
        System.out.println(good ? "YES" : "NO");
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