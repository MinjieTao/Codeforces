import java.util.*;
import java.io.*;
public class B219 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt(), q = input.nextInt();
    int[][][][] dp = new int[n][m][n][m];
    char[][] grid = new char[n][m];
    for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
    int[][] up = new int[n][m], left = new int[n][m];
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            int at = i;
            while(at >= 0 && grid[at][j] == '0')
            {
                at--;
            }
            up[i][j] = at;
        }
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            int at = j;
            while(at >= 0 && grid[i][at] == '0')
            {
                at--;
            }
            left[i][j] = at;
        }
    for(int starti = n-1; starti >= 0; starti--)
        for(int startj = m-1; startj >= 0; startj--)
        {
            for(int i = starti; i<n; i++)
                for(int j = startj; j<m; j++)
                {
                    //System.out.println(starti+" "+startj+" "+i+" "+j);
                    if(grid[i][j] == '1') continue;
                    dp[starti][startj][i][j] = 1;
                    int ni = Math.max(starti, up[i][j] + 1);
                    int nj = Math.max(startj, left[i][j] + 1);
                    if(i >starti) dp[starti][startj][i][j] += dp[starti][nj][i-1][j];
                    if(j > startj) dp[starti][startj][i][j] += dp[ni][startj][i][j-1];
                    if(i > starti && j > startj) dp[starti][startj][i][j] -= dp[ni][nj][i-1][j-1];
                    //if(starti + startj == 0) System.out.println(starti+" "+startj+" "+i+" "+j+" "+dp[starti][startj][i][j]);
                }
            
        }
    for(int starti = 0; starti < n; starti++)
        for(int startj = 0; startj < m; startj++)
        {
            for(int i = starti; i<n; i++)
                for(int j = startj; j<m; j++)
                {
                    if(i >starti) dp[starti][startj][i][j] += dp[starti][startj][i-1][j];
                    if(j > startj) dp[starti][startj][i][j] += dp[starti][startj][i][j-1];
                    if(i > starti && j > startj) dp[starti][startj][i][j] -= dp[starti][startj][i-1][j-1];
                    //System.out.println(i+" "+j+" "+dp[i][j]);
                }
        }
    for(int i = 0; i<q; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt()-1,d = input.nextInt()-1;
        int res = dp[a][b][c][d];
        out.println(res);
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