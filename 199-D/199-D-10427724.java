import java.util.*;
import java.io.*;
public class B125 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = 2, m = input.nextInt(), x = input.nextInt();
    char[][] grid = new char[n][m];
    for(int i = 0; i<n; i++) grid[i] = input.next().toCharArray();
    boolean res = false;
    Queue<Integer> qi = new LinkedList<Integer>(), qj = new LinkedList<Integer>();
    qi.add(0);
    qj.add(0);
    int[] di = new int[]{0, 0, 1, -1};
    int[] dj = new int[]{1, -1, x, x};
    int[][] ds = new int[n][m];
    for(int[] A : ds) Arrays.fill(A, 987654321);
    ds[0][0] = 0;
    while(!qi.isEmpty())
    {
        int ati = qi.poll(), atj = qj.poll();
        //System.out.println(ati+" "+atj);
        for(int k = 0; k<4; k++)
        {
            int ni = ati + di[k], nj = atj + dj[k];
            if(ni < 0 | ni >= n || nj < 0) continue;
            if(nj >= m)
            {
                res = true;
                break;
            }
            //System.out.println(ni+"   "+nj);
            int nd = ds[ati][atj] + 1;
            if(nd >= ds[ni][nj] || nd > nj || grid[ni][nj] == 'X') continue;
            ds[ni][nj] = nd;
            qi.add(ni);
            qj.add(nj);
        }
    }
    System.out.println(res ? "YES" : "NO");
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