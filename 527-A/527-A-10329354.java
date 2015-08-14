import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long a = input.nextLong(), b = input.nextLong();
    System.out.println(go(a, b)-1);
}
static long go(long a, long b)
{
    if(b > a) return go(b, a);
    return b == 0 ? 1 : go(b, a%b) + a/b;
}
}