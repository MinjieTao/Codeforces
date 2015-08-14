import java.util.*;
public class m{
public static void main(String[]a)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long[] ms = new long[n], xs = new long[n];
    long res = 0;
    for(int i = 0; i<n; i++)
    {
        xs[i] = input.nextLong();
        ms[i] = input.nextLong();
        res ^= xor(xs[i]-1) ^ xor(xs[i]+ms[i]-1);
    }
    System.out.println(res == 0 ? "bolik" : "tolik");
}
public static long xor(long x)
{
    if(x%4 == 0)
        return x;
    if(x%4 == 1)
        return 1;
    if(x%4 == 2)
        return x+1;
    return 0;
}
}