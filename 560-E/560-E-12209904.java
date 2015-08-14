import java.util.*;
import java.io.*;
public class f {
    static long mod = (long)(1e9+7);
    static long[] facts, ifacts;
public static void main(String[] args) throws Exception
{
    EspyScanner input = new EspyScanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    facts = new long[200001];
    ifacts = new long[200001];
    facts[0] = 1;
    ifacts[0] = 1;
    for(int i = 1; i<facts.length; i++)
    {
        facts[i] = (facts[i-1] * i)%mod;
        ifacts[i] = invmod(facts[i]);
    }
    //int T = input.nextInt();
    //for(int t = 0; t<T; t++)
    {
        int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
        Block[] data = new Block[k+2];
        data[0] = new Block(1, 1);
        data[k+1] = new Block(n, m);
        for(int i = 1; i<=k; i++) data[i] = new Block(input.nextInt(), input.nextInt());
        Arrays.sort(data);
        int[] inside = new int[k+2];
        for(int i = 0; i<k+2; i++)
            for(int j = 0; j<i; j++)
            {
                if(data[j].x <= data[i].x && data[j].y <= data[i].y)
                {
                    if(data[i].x == data[j].x && data[i].y == data[j].y) continue;
                    inside[i]++;
                }
            }
        //System.out.println(Arrays.toString(inside));
        //System.out.println(Arrays.toString(last));
        long[][] dist = new long[k+2][k+2];
        for(int i = 0; i<k+2; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(data[j].x <= data[i].x && data[j].y <= data[i].y)
                {
                    int dx = data[i].x - data[j].x;
                    int dy = data[i].y - data[j].y;
                    dist[j][i] = choose(dx+dy, dx);
                    if(dist[j][i] < 0) System.out.println(1/0);
                }
            }
        }
        long[] ways = new long[k+2];
        ways[0] = 1;
        for(int i = 1; i<k+2; i++) ways[i] = dist[0][i];
        for(int i = 1; i<k+2; i++)
        {
            //System.out.println(ways[i]);
            for(int j = i+1; j<k+2; j++)
            {
                if(data[i].x <= data[j].x && data[i].y <= data[j].y)
                {
                    //System.out.println(i+" "+j+" "+ways[j]);
                    ways[j] -= ways[i] * dist[i][j];
                    //System.out.println(ways[j]);
                    ways[j] = (ways[j]%mod + mod)%mod;
                }
            }
        }
//      for(int i = 1; i<k+2; i++)
//      {
//          for(int j= 0; j<i; j++)
//          {
//              if(data[j].x <= data[i].x && data[j].y <= data[i].y)
//              {
//                  if(j == 0) ways[i] = (ways[i] + ways[j] * dist[j][i])%mod;
//                  else ways[i] = (ways[i] - ways[j] * dist[j][i])%mod;
//                  ways[i] = (ways[i] + mod)%mod;
//                  //System.out.println(i+" "+j+" "+ways[i]);
//              }
//          }
//          //System.out.println(i+" "+ways[i]);
//      }
        out.println(ways[k+1]);
    }
    
    
    out.close();
}
static class Block implements Comparable<Block>
{
    int x, y;
    public Block(int xx, int yy)
    {
        x = xx; y = yy;
    }
    @Override
    public int compareTo(Block o) {
        // TODO Auto-generated method stub
        if(x == o.x) return y - o.y;
        return x - o.x;
    }
}
static long choose(int n, int k)
{
    long res = (facts[n] * ifacts[n-k])%mod;
    return (res * ifacts[k])%mod;
}
//GCD - O(log(max(p, q)))
//res[0] is gcd of p and q
//res[1] and res[2] are values used in extended Euclidean algorithm for inverse mod
public static long[] gcd(long p, long q)
{
    if(q==0)
        return new long[] {p, 1, 0};
    long[] vals = gcd(q, p%q);
    return new long[] {vals[0], vals[2], vals[1] - (p/q)*vals[2]};
}
//Inverse Mod - O(log(mod))
//Returns A s.t. x*A = 1(MOD mod)
public static long invmod(long x)
{
    long[] vals = gcd(x, mod);
    if(vals[0]>1)
        return -1;
    if(vals[1]>0)
        return vals[1];
    return mod + vals[1];
}
public static class EspyScanner {
    public final int BASE_SPEED = 110;
    public BufferedReader bf;
    public StringTokenizer st;

    public EspyScanner(InputStream in) throws Exception {
        bf = new BufferedReader(new InputStreamReader(in));
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(next());
    }

    public String next() throws Exception {
        if (st == null || !st.hasMoreTokens()) {
            String line = bf.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
            return next();
        }
        return st.nextToken();
    }
}
}