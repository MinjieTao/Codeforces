import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    //int n = 50;
    int[] f = new int[n+1];
    //Random r = new Random();
    //for(int i = 1; i<=n; i++) f[i] = r.nextInt(n)+1;
    //System.out.println(Arrays.toString(f));
    //System.out.println(n);
    //for(int x : f) System.out.print(x+" ");
    //System.out.println();
    for(int i = 1; i<=n; i++) f[i] = input.nextInt();
    int[] g = new int[n+1];
    for(int i = 0; i<=n; i++) g[i] = f[i];
    int res = 1;
    int[] cycles = new int[n+1];
    int[] off = new int[n+1];
    for(int i = 1; i<=n; i++)
    {
        cycles[i] = 0;
        int at = i;
        int[] last = new int[n+1];
        Arrays.fill(last, -1);
        int ctr = 0;
        last[i] = 0;
        while(true)
        {
            at = f[at];
            ctr++;
            if(last[at] != -1)
            {
                off[i] = last[at];
                cycles[i] = ctr - last[at];
                break;
            }
            last[at] = ctr;
        }
    }
    //System.out.println(Arrays.toString(cycles)+" "+Arrays.toString(off));
    long lcm = 1;
    for(int i = 1; i<=n; i++)
    {
        lcm = lcm(lcm, cycles[i]);
    }
    long ans = lcm;
    for(int i = 1; i<=n; i++) lcm = Math.max(lcm, off[i]);
    //System.out.println(ans+" "+lcm);
    long output = lcm / ans * ans;
    //System.out.println(output+" "+lcm+" "+ans);
    while(output < lcm) output += ans;
    System.out.println(output);
//  while(true)
//  {
//      boolean valid = true;
//      for(int i = 1; i<=n; i++) if(g[g[i]] != g[i])
//      {
//          valid = false;
//          break;
//      }
//      if(valid)
//      {
//          System.out.println(res);
//          break;
//      }
//      res++;
//      for(int i = 1; i<=n; i++) g[i] = f[g[i]];
//  }
    //System.out.println(res);
}
static long gcd(long a, long b)
{
    return b == 0 ? a : gcd(b, a%b);
}
static long lcm(long a, long b)
{
    return a / gcd(a, b) * b;
}
}