import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] xs = new int[n], ys = new int[n];
    for(int i = 0; i<n; i++)
    {
        xs[i] = input.nextInt();
        ys[i] = input.nextInt();
    }
    long bad = 0;
    for(int i = 0; i<n; i++)
    {
        TreeMap<myDouble, Integer> map = new TreeMap<myDouble, Integer>();
        for(int j = 0; j<n; j++)
        {
            if(i == j) continue;
            double dy = ys[j] - ys[i], dx = xs[j] - xs[i];
            myDouble slope = new myDouble(dy / dx);
            if(dx == 0) slope = new myDouble(1e9);
            if(!map.containsKey(slope)) map.put(slope, 1);
            else map.put(slope, 1 + map.get(slope));
        }
        for(myDouble d : map.keySet()) bad += map.get(d) * (map.get(d) - 1) / 2;
    }
    bad /= 3;
    long tot = (long)n * (n - 1) * (n-2) / 6;
    System.out.println(tot - bad);
}
static class myDouble implements Comparable<myDouble>
{
    double x;
    myDouble(double xx)
    {
        x = xx;
    }
    @Override
    public int compareTo(myDouble o) {
        // TODO Auto-generated method stub
        if(Math.abs(x - o.x) < 1e-9) return 0;
        return Double.compare(x,  o.x);
    }
}
}