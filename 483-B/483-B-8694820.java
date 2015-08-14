import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int c1 = input.nextInt(), c2 = input.nextInt(), x = input.nextInt(), y = input.nextInt(); 
    long lo = 2, hi = 2100000000;
    while(lo < hi - 1)
    {
        long mid = (lo+hi)>>1;
        if(good(mid, c1, c2, x, y)) hi = mid;
        else lo = mid;
    }
    if(good(lo, c1, c2, x, y)) hi = lo;
    System.out.println(hi);
}
static boolean good(long res, int c1, int c2, int x, int y)
{
    long total = res - res / lcm(x, y);
    if(total < c1+c2) return false;
    long good1 = res - res / x, good2 = res - res/y;
    return good1 >= c1 && good2 >= c2;
}
static int gcd(int a, int b)
{
    return b == 0 ? a : gcd(b, a%b);
}
static int lcm(int a, int b)
{
    return a / gcd(a, b) * b;
}
}