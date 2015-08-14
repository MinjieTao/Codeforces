import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        int lo = 0, hi = (int)1e9+1;
        while(lo < hi - 1)
        {
            int mid = (lo+hi)/2;
            if(go(mid, k) >= n)
                hi = mid;
            else
                lo = mid;
        }
        System.out.println(hi);
    }
    public static long go(int v, int k)
    {
        int res = 0, term = v, denom =1;
        while(term/denom > 0)
        {
            res += term/denom;
            if(res > (int)1e9)
                return (long)1e9+1;
            denom *= k;
        }
        return res;
    }
}