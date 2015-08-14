import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for(int t = 0; t<T; t++)
    {
        long a = input.nextLong(), b = input.nextLong();
        res = 0;
        go(a, b, 60);
        //System.out.println(r);
        System.out.println(res);
    }
}
static long res;
static long go(long a, long b, int bit)
{
    //System.out.println(a+" "+b+" "+bit);
    if(bit < 0) return 0;
    boolean aa = (a & (1l << bit)) > 0;
    boolean bb = (b & (1l << bit)) > 0;
    if(aa && bb)
    {
        res |= (1l<<bit);
        return 1 + go(a, b, bit-1);
    }
    if(bb)
    {
        long g = go(0, b, bit-1);
        if(1+g > bit) res |= (1l<<bit);
        else res |= (1l<<bit) - 1;
        return Math.max(bit, 1 + g);
    }
    return go(a, b, bit-1);
}
}