import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] as = new int[n];
    for(int i = 0; i<n; i++) as[i] = input.nextInt();
    int[] vs = new int[n];
    DisjointSet ds = new DisjointSet(n);
    int m = input.nextInt();
    for(int i = 0; i<m; i++)
    {
        int type = input.nextInt();
        if(type == 2) System.out.println(vs[input.nextInt()-1]);
        else
        {
            int x = input.nextInt()-1, v = input.nextInt();
            x = ds.find(x);
            while(v > 0 && x<n)
            {
                int take = Math.min(as[x]-vs[x], v);
                v -= take;
                vs[x] += take;
                if(vs[x] == as[x])
                {
                    if(x != n-1) ds.union(x, x+1);
                    x++;
                }
            }
        }
    }
}
public static class DisjointSet
{
    int[] map; //negative if root, more negative means bigger set; if nonnegative, then it indicates the parent 
    public DisjointSet(int n)
    {
        map = new int[n+1];
        Arrays.fill(map, -1);
    }
    public int find(int x)
    {
        if(map[x] < 0)
            return x;
        else
        {
            map[x] = find(map[x]);
            return map[x];
        }
    }
    //Make a be child of b.
    public void union(int a, int b)
    {
        int roota = find(a), rootb = find(b);
        if(roota == rootb)
            return;
        map[rootb] += map[roota];
        map[roota] = rootb;
    }
}
}