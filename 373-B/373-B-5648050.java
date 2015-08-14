import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long w = input.nextLong(), m = input.nextLong(), k = input.nextLong();
    w /= k;
    int len = (m+"").length();
    long res = 0;
    long allowed = getTenPow(len) - m;
    while(true)
    {
        long canMake = w/len;
        long make = Math.min(allowed, canMake);
        res += make;
        w -= len*make;
        if(w<=len) break;
        len++;
        allowed = getTenPow(len) - getTenPow(len-1);
    }
    System.out.println(res);
}
static long getTenPow(int len)
{
    long res = 1;
    for(int i = 0; i<len; i++) res *= 10;
    return res;
}
}