import java.io.*;
import java.util.*;
public class a {

    public static void main(String[] args) throws IOException {
        input.init(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = input.nextInt(), m = input.nextInt();
        int[][] degs = new int[n][m];
        int[] di = new int[]{0, 1, 0, -1};
        int[] dj = new int[]{1, 0, -1, 0};
        Queue<Integer> qi = new LinkedList<Integer>(), qj = new LinkedList<Integer>();
        char[][] res = new char[n][m];
        char[][] grid = new char[n][m];
        for(int i = 0; i<n; i++)
        {
            String s = input.next();
            for(int j = 0; j<m; j++)
                res[i][j] = grid[i][j] = s.charAt(j);
        }
        for(int i = 0; i<n; i++)
            for(int j = 0; j<m; j++)
            {
                if((i+j)%2 == 0 || grid[i][j] == '*') continue;
                int d =0;
                for(int k =0 ; k<4; k++)
                {
                    int ni = i+di[k], nj = j+dj[k];
                    if(ni<0 || nj < 0 || ni >= n || nj >= m) continue;
                    if(grid[ni][nj] == '.') d++;
                }
                degs[i][j] = d;
                //out.println(i+" "+j+" "+d);
                if(degs[i][j] == 1)
                {
                    qi.add(i);
                    qj.add(j);
                }
            }
        while(!qi.isEmpty())
        {
            int ati = qi.poll();
            int atj = qj.poll();
            //out.println(ati+" "+atj);
            int d = -1;
            for(int k = 0; k<4; k++)
            {
                int ni = ati+di[k], nj = atj+dj[k];
                if(ni<0 || nj < 0 || ni >= n || nj >= m) continue;
                if(res[ni][nj] == '.') d = k;
            }
            if(d == -1) break;
            int i = ati+di[d], j = atj+dj[d];
            if(d == 0)
            {
                res[ati][atj] = '<';
                res[i][j] = '>';
            }
            else if(d == 1)
            {
                res[ati][atj] = '^';
                res[i][j] = 'v';
            }
            else if(d == 2)
            {
                res[ati][atj] = '>';
                res[i][j] = '<';
            }
            else if(d == 3)
            {
                res[ati][atj] = 'v';
                res[i][j] = '^';
            }
            for(int k = 0; k<4; k++)
            {
                int ni = i+di[k], nj = j+dj[k];
                if(ni<0 || nj < 0 || ni >= n || nj >= m) continue;
                if(grid[ni][nj] == '.')
                {
                    degs[ni][nj]--;
                    if(degs[ni][nj] == 1)
                    {
                        qi.add(ni);
                        qj.add(nj);
                    //  out.println("ADD: "+ni+" "+nj);
                    }
                }
            }
        }
        boolean good = true;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<m; j++)
                good &= res[i][j] != '.';
        if(good)
        {
            for(char[] A: res) out.println(new String(A));
        }
        else
        {
            out.println("Not unique");
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