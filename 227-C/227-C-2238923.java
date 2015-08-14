import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    System.out.println((go(n, m)-1+m)%m);
}
public static long go(long n, int m)
{
    if(n==0)
        return 1;
    if(n%2 == 1)
        return (3*go(n-1, m) % m);
    else
    {
        long sqrt = go(n/2,m);
        return (sqrt*sqrt)%m;
    }
}
}