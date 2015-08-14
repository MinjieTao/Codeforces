import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    System.out.println(go(input.nextLong(), input.nextLong(), true));
}
static long go(long h, long n, boolean left)
{
    if(h == 0) return 0;
    return (left == (n > (1l << (h-1)))) ? (1l << h) + go(h-1, 1+(n-1)%(1l << (h-1)), left) : 1 + go(h-1, 1+(n-1)%(1l << (h-1)), !left);
}
}