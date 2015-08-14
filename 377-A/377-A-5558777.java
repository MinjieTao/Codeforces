import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    
    int n = input.nextInt(), m = input.nextInt(), count = input.nextInt();
    char[][] data = new char[n][m];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    ArrayList<Integer>[] g = new ArrayList[n*m];
    int[] ps = new int[n*m];
    Arrays.fill(ps, -1);
    boolean[] vis = new boolean[n*m];
    int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};
    int[] deg = new int[n*m];
    for(int i = 0; i<n*m; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n*m; i++)
    {
        if(vis[i]) continue;
        Queue<Integer> q = new LinkedList<Integer>();
        vis[i] = true;
        q.add(i);
        while(!q.isEmpty())
        {
            int at = q.poll();
            int y = at/m, x = at%m;
            if(data[y][x] != '.') continue;
            for(int k = 0; k<4; k++)
            {
                int ny = y+dy[k], nx = x+dx[k];
                if(ny<0||nx<0||ny>=n||nx>=m||data[ny][nx] != '.') continue;
                int next = ny*m+nx;
                if(vis[next] && next != ps[at]) continue;
                ps[next] = at;
                g[at].add(ny*m+nx);
                deg[at]++;
                if(!vis[next]) q.add(next);
                vis[next] = true;
            }
        }
    }
    LinkedList<Integer> q = new LinkedList<Integer>();
    
    int done = 0;
    for(int i = 0; i<=4 && done<count; i++)
    {
        for(int j = 0; j<n*m; j++) if(data[j/m][j%m] == '.' && deg[j] == i)
        {
            q.add(j);
        }
        while(!q.isEmpty() && done < count)
        {
            int x = q.poll();
            for(int e: g[x])
            {
                deg[e]--;
                if(deg[e] == i) q.addLast(e);
            }
            done++;
            data[x/m][x%m] = 'X';
        }
    }
    for(int i = 0; i<n; i++) System.out.println(new String(data[i]));
    out.close();
}
static class Pair implements Comparable<Pair>
{
    int d, i;
    public Pair(int dd, int ii)
    {
        d = dd; i = ii;
    }
    @Override
    public int compareTo(Pair o) {
        // TODO Auto-generated method stub
        return d - o.d;
    }
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