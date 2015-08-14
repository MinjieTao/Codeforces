import java.util.*;
public class d {
    static ArrayList<Integer>[] g, tree;
    static int[] vals;
    static int d;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    d = input.nextInt(); int n = input.nextInt();
    g = new ArrayList[n]; tree = new ArrayList[n];
    for(int i = 0; i<n; i++)
    {
        g[i] = new ArrayList<Integer>();
        tree[i] = new ArrayList<Integer>();
    }
    vals = new int[n];
    int max = 0;
    for(int i = 0; i<n; i++) max = Math.max(max, vals[i] = input.nextInt());
    for(int i = 0; i<n-1; i++)
    {
        int a = input.nextInt()-1, b = input.nextInt()-1;
        g[a].add(b);
        g[b].add(a);
    }
    boolean[] vis = new boolean[n];
    vis[0] = true;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    while(!q.isEmpty())
    {
        int at = q.poll();
        for(int e: g[at])
        {
            if(vis[e]) continue;
            vis[e] = true;
            q.add(e);
            tree[at].add(e);
        }
    }
    g = null;
    memo = new int[2][n][2001];
    for(int[][] A: memo)
        for(int[] B: A)
            Arrays.fill(B, -1);
    long res = 0;
    for(int root = 0; root < n; root++)
        for(int i = 1; i<=max; i++)
        {
            res = (res + go(root, i, 1))%mod;
            //System.out.println(root+" "+i+" "+res);
        }
    System.out.println(res);
}
static int[][][] memo;
static long mod = 1000000007;
static int go(int at, int min, int flag)
{
    //System.out.println((at+1)+" "+min+" "+flag);
    if(memo[flag][at][min] != -1) return memo[flag][at][min];
    if(Math.abs(min - vals[at]) > d) return memo[flag][at][min] = 0;
    if(vals[at] < min) return memo[flag][at][min] = 0;
    if(flag == 0 && vals[at] == min) return memo[flag][at][min] = 0;
    if(tree[at].size() == 0)
    {
        if(flag == 1 && vals[at] != min) return memo[flag][at][min] = 0;
        return memo[flag][at][min] = 1;
    }
    if(flag == 0)
    {
        long res = 1;
        for(int e: tree[at])
        {
            res = (res * (1+go(e, min, 0)))%mod;
        }
        return memo[flag][at][min] = (int)res;
    }
    else
    {
        long res = 1;
        if(vals[at] == min)
        {
            for(int e : tree[at])
            {
                res = (res * (1 + go(e, min, 1) + go(e, min, 0)))%mod;
            }
        }
        else
        {
            res = 0;
            ArrayList<Integer> children = tree[at];
            long[] anything = new long[children.size()];
            for(int i = 0; i<children.size(); i++)
            {
                int child = children.get(i);
                anything[i] = 1 + go(child, min, 1) + go(child, min, 0);
            }
            for(int i = children.size()-2; i>=0; i--) anything[i] = (anything[i] * anything[i+1])%mod;
            long allZeroes = 1;
            for(int i = 0; i<children.size(); i++)
            {
                int child = children.get(i);
                long toAdd = (allZeroes * (i == children.size() - 1 ? 1 : anything[i+1]))%mod;
                toAdd = (toAdd * go(child, min, 1))%mod;
                res = (res + toAdd)%mod;
                allZeroes = (allZeroes * (1+go(child, min, 0)))%mod;
            }
        }
        return memo[flag][at][min] = (int)res;
    }
}
}