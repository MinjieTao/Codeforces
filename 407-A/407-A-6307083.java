import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt();
    int g = gcd(a, b);
    if(a>b)
    {
        int temp = a;
        a = b; b = temp;
    }
    int[] first = py(g);
    if(first.length == 0 || first[0]*(a/g) == (b/g)*first[1])
    {
        System.out.println("NO");
    }
    else
    {
        System.out.println("YES");
        System.out.println(0+" "+0);
        System.out.println(first[0]*(a/g)+" "+first[1]*(a/g));
        System.out.println((b/g)*first[1]+" "+(-b/g)*first[0]);
    }
}
static int gcd(int a, int b)
{
    if(b == 0) return a;
    return gcd(b, a%b);
}
static int[] py(int c)
{
    for(int i = 1; i<c; i++)
    {
        int diff = c*c - i*i;
        int sqrt = (int)(Math.sqrt(diff) + .5);
        if(Math.abs(sqrt - Math.sqrt(diff)) < 1e-9)
            return new int[]{i, sqrt};
    }
    return new int[0];
}
}