import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int need = 1000000 - input.nextInt();
    City[] data = new City[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = new City(input.nextInt(), input.nextInt(), input.nextInt());
    }
    Arrays.sort(data);
    int at = 0, count = 0;
    double dist = -1;
    while(count < need && at < n)
    {
        count += data[at].p;
        if(count >= need) dist = data[at].d;
        at++;
    }
    System.out.println(dist < 0 ? "-1" : dist);
}
static class City implements Comparable<City>
{
    int x, y, p;
    double d;
    public City(int xx, int yy, int pp)
    {
        x = xx; y = yy; p = pp;
        d = Math.sqrt((double)x*x + (double)y*y);
    }
    public int compareTo(City o)
    {
        return (int)Math.signum(d - o.d);
    }
}
}