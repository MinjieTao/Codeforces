import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int g = input.nextInt();
    for(int i = 0; i<n-1; i++) g = gcd(g, input.nextInt());
    System.out.println(g*n);
}
static int gcd(int a, int b)
{
    return b == 0 ? a : gcd(b, a%b);
}
}