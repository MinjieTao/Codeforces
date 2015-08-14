import java.util.*;
public class d21 {
  static int n;
  static long[][] g;
  static long oo = (long)1e12;
  static HashSet<Integer> set;
public static void main(String[] args)
{
  Scanner input = new Scanner(System.in);
  n = input.nextInt();
  DisjointSet ds = new DisjointSet(n);
  int m = input.nextInt();
  g = new long[n][n];
  for(long[] A : g) Arrays.fill(A, oo);
  memo = new long[1<<n];
  Arrays.fill(memo, -1);
  int[] degs = new int[n];
  long res = 0;
  set = new HashSet<Integer>();
  for(int i = 0; i<m; i++)
  {
    int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt();
    set.add(a);
    set.add(b);
    ds.union(a, b);
    if(a != b) g[a][b] = g[b][a] = Math.min(g[a][b], c);
    degs[a] ^= 1;
    degs[b] ^= 1;
    res += c;
  }
  for(int k = 0; k<n; k++)
    for(int i = 0; i<n; i++)
      for(int j = 0; j<n; j++)
      {
        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
      }
  if((m > 0 && !set.contains(0)) || (m > 0 && ds.map[ds.find(0)] != -set.size())) System.out.println(-1);
  else
  {
    int mask = 0;
    for(int i = 0; i<n; i++)
      if(degs[i] == 0)
        mask |= (1<<i);
    res += go(mask);
    System.out.println(res > 1e12 ? -1 : res);
  }
}
static long[] memo;
static long go(int mask)
{
  //System.out.println(mask);
  if(mask == (1<<n)-1) return 0;
  if(memo[mask] != -1) return memo[mask];
  int min = 0;
  while((mask & (1<<min)) > 0 || !set.contains(min)) min++;
  long res = (long)1e15;
  for(int j =min+1; j<n; j++)
  {
    if(!set.contains(j)) continue;
    if(g[min][j] == -1) continue;
    if((mask & (1<<j)) > 0) continue;
    int nmask = mask | (1<<min) | (1<<j);
    res = Math.min(res, go(nmask) + g[min][j]);
  }
  return memo[mask] = res;
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
    public void union(int a, int b)
    {
        int roota = find(a), rootb = find(b);
        if(roota == rootb)
            return;
        if(map[roota] < map[rootb])
        {
            map[roota] += map[rootb]; //add the sizes
            map[rootb] = roota; //connect the smaller to the bigger
        }
        else
        {
            map[rootb] += map[roota];
            map[roota] = rootb;
        }
    }
}
}