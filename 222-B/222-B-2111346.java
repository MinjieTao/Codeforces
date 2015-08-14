import java.util.*;
import java.io.*;
public class b {
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
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(System.in);
    Reader.init(System.in);
    int n = Reader.nextInt(), m = Reader.nextInt(), k = Reader.nextInt();
    int[][] data = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
            data[i][j] = Reader.nextInt();
    int[] rows = new int[n];
    int[] cols = new int[m];
    for(int i = 0; i<n; i++)
        rows[i] = i;
    for(int i = 0; i<m; i++)
        cols[i] = i;
    for(int i = 0; i<k; i++)
    {
        char c = Reader.next().charAt(0);
        if(c== 'c')
        {
            int c1 = Reader.nextInt()-1;
            int c2 = Reader.nextInt()-1;
            int temp = cols[c1];
            cols[c1] = cols[c2];
            cols[c2] = temp;
        }
        else if(c== 'r')
        {
            int r1 = Reader.nextInt()-1;
            int r2 = Reader.nextInt()-1;
            int temp = rows[r1];
            rows[r1] = rows[r2];
            rows[r2] = temp;
        }
        else
        {
            int row = Reader.nextInt()-1;
            int col = Reader.nextInt()-1;
            System.out.println(data[rows[row]][cols[col]]);
        }
    }
}
}