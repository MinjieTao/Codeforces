import java.util.*;
public class c {
    static int n, m;
    static char[][] data;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static char[] dima = new char[]{'D','I','M','A'};
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    n = input.nextInt(); m = input.nextInt();
    data = new char[n][m];
    for(int i = 0; i<n; i++) data[i] = input.next().toCharArray();
    poss = new int[n][m];
    for(int[] A: poss) Arrays.fill(A, -1);
    boolean good = false;
    indexMap = new int[n*m];
    Arrays.fill(indexMap, -1);
    int cnt = 0;
    for(int i =0 ; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(data[i][j] == 'D') indexMap[i*m+j] = cnt++;
        }
    g = new ArrayList[cnt];
    for(int i = 0; i<cnt; i++) g[i] = new ArrayList<Integer>();
    for(int i = 0; i<n; i++)
        for(int j = 0; j<m; j++)
        {
            if(data[i][j] == 'D')
                good |= possible(i, j, i, j, 0, true);
        }
    if(!good) System.out.println("Poor Dima!");
    else
    {
        for(int i = 0; i<n; i++)
            for(int j = 0; j<m; j++)
            {
                if(data[i][j] == 'D')
                    possible(i, j, i, j, 0, false);
            }
//      for(int i = 0; i<cnt; i++) 
//      {
//          System.out.println(i);
//          for(int e: g[i]) System.out.print(e+" ");
//          System.out.println("!");
//      }
        cycle = false;
        vis = new int[cnt];
        ds = new int[cnt];
        for(int i = 0; i<n; i++)
            for(int j =0; j<m; j++)
                if(data[i][j] == 'D' && poss[i][j] == 1 && vis[indexMap[i*m+j]] == 0)
                {
                    cycle |= dfs(indexMap[i*m+j]);
                }
        if(cycle) System.out.println("Poor Inna!");
        else
        {
            int res = 1;
            for(int i = 0; i<cnt; i++) res = Math.max(res, ds[i]);
            System.out.println(res);
        }
    }
}
static int[] indexMap;
static int[][] poss;
static ArrayList<Integer>[] g;
static boolean cycle;
static int[] vis;
static int[] ds; //Stores distances
//Iterative DFS
static boolean dfs(int start)
{
    Stack<Integer> stk = new Stack<Integer>();
    stk.add(start);
    while(!stk.isEmpty())
    {
        int at = stk.pop();
        if(vis[at] == 0)
        {
            vis[at] = 1;
            stk.push(at);
        }
        else if(vis[at] == 2) continue;
        else
        {
            int res = 0;
            for(int e: g[at])
            {
                res = Math.max(res, ds[e]);
            }
            res++;
            ds[at] = res;
            vis[at] = 2;
            continue;
        }
        for(int e: g[at])
        {
            if(vis[e] == 2) continue;
            else if(vis[e] == 1)
            {
                return true;
            }
            else
            {
                stk.push(e);
            }
        }
    }
    return false;
}
static boolean possible(int sr, int sc, int r, int c, int count, boolean first)
{
    if(poss[r][c] != -1 && first) return poss[r][c]>0;
    if(count == 3)
    {
        for(int k =0; k<4; k++)
        {
            int nr = r+dr[k], nc = c+dc[k];
            if(nr<0||nr>=n||nc<0||nc>=m||data[nr][nc] != 'D') continue;
            if(!first && poss[nr][nc] == 1 && !g[indexMap[sr*m+sc]].contains(indexMap[nr*m+nc])) g[indexMap[sr*m+sc]].add(indexMap[nr*m+nc]);
        }
        return true;
    }
    boolean res = false;
    for(int k =0; k<4; k++)
    {
        int nr = r+dr[k], nc = c+dc[k];
        if(nr<0||nr>=n||nc<0||nc>=m||data[nr][nc] != dima[count+1]) continue;
        res |= possible(sr, sc, nr, nc, count+1, first);
    }
    poss[r][c] = res?1:0;
    return res;
}
}