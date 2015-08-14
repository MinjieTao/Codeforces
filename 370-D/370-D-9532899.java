import java.io.*;
import java.util.*;
public class d {
    static char[][] data;
    static int n, m;
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    n = input.nextInt();
    m = input.nextInt();
    data = new char[n][m];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    int mini = n, minj = m, maxi = -1, maxj = -1;
    countW = 0;
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(data[i][j] == 'w')
            {
                countW++;
                mini = Math.min(mini, i);
                maxi = Math.max(maxi, i);
                minj = Math.min(minj, j);
                maxj = Math.max(maxj, j);
            }
        }
    int size = Math.max(maxj - minj, maxi - mini) + 1;
    int goodi = -1, goodj = -1;
    for(int i = 0; i<n && goodi == -1; i++)
    {
        if(good(i, minj, size))
        {
            goodi = i; goodj = minj;
        }
    }
    for(int j = 0; j<m && goodi == -1; j++)
    {
        if(good(mini, j, size))
        {
            goodi = mini; goodj = j;
        }
    }
    if(goodi == -1) out.println(-1);
    else
    {
        fill(goodi, goodj, size);
        for(char[] A : data) out.println(new String(A));
    }
    
    out.close();
}
static void fill(int starti, int startj, int size)
{
    for(int i = starti; i<starti+size; i++)
        for(int j = startj; j<startj+size; j++)
        {
            if(i != starti && i != starti + size - 1 && j != startj && j != startj + size - 1) continue;
            if(data[i][j] == '.') data[i][j] = '+';
        }
}
static boolean good(int starti, int startj, int size)
{
    if(starti + size > n) return false;
    if(startj + size > m) return false;
    if(size == 1) return countW == 1 && data[starti][startj] == 'w';
    int countIn = 0;
    for(int i = starti; i < starti + size; i++)
    {
        if(data[i][startj] == 'w') countIn++;
        if(data[i][startj + size - 1] == 'w') countIn++;
    }
    for(int j = startj + 1; j < startj + size - 1; j++)
    {
        if(data[starti][j] == 'w') countIn++;
        if(data[starti + size - 1][j] == 'w') countIn++;
    }
    return countIn == countW;
}
static int countW;
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