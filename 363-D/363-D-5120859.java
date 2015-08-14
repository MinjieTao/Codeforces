import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), a = input.nextInt();
    int[] bs = new int[n], cs = new int[m];
    for(int i = 0; i<n; i++) bs[i] = input.nextInt();
    Arrays.sort(bs);
    for(int i = 0; i<m; i++) cs[i] = input.nextInt();
    Arrays.sort(cs);
    int lo = 0, hi = Math.min(n, m)+1;
    while(lo<hi-1)
    {
        int mid = (lo+hi)/2;
        if(possible(mid, bs, cs, a)) lo = mid;
        else hi = mid;
    }
    int res = lo;
    long per = 0;
    for(int i = 0; i<res; i++) per += cs[i];
    per -= a;
    if(per < 0) per = 0;
    System.out.println(res+" "+per);
}
static boolean possible(int k, int[] bs, int[] cs, int a)
{
    if(k==0) return true;
    int n = bs.length, m = cs.length;
    int atb = n-k, atc = 0;
    long needed = 0;
    while(atb<n)
    {
        needed += Math.max(0, cs[atc++] - bs[atb++]);
    }
    return needed <= a;
}
}