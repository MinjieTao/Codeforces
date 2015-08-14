import java.util.*;
public class e {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), l = input.nextInt();
    int[] xs = new int[n], bs = new int[n];
    last = new int[n];
    for(int i = 0; i<n; i++)
    {
        xs[i] = input.nextInt();
        bs[i] = input.nextInt();
        
    }
    double lo = 0, hi = 1e9;
    while(hi - lo > 1e-9)
    {
        double mid = (lo+hi)/2;
        if(possible(mid, xs, bs, l)) lo = mid;
        else hi = mid;
    }
    //System.out.println(lo);
    ArrayList<Integer> res = new ArrayList<Integer>();
    int at = n-1;
    while(at != -1)
    {
        res.add(at+1);
        at = last[at];
    }
    for(int i = res.size() -1; i>=0; i--) System.out.print(res.get(i)+" ");
}
static int[] last;
static boolean possible(double ratio, int[] xs, int[] bs, int l)
{
    int n = xs.length;
    double[] max = new double[n];
    Arrays.fill(max, -1e18);
    for(int i = 0; i<n; i++)
    {
        double cur = i == 0 ? 0 : max[i-1];
        int curx = i == 0 ? 0 : xs[i-1];
        for(int j = i; j<n; j++)
        {
            double next = cur + bs[j] - ratio * Math.sqrt(Math.abs(l - (xs[j] - curx)));
            if(next > max[j])
            {
                max[j] = next;
                last[j] = i-1;
            }
        }
    }
    //System.out.println(max[n-1]);
    return max[n-1] >= 0;
}
}