import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    TreeSet<String> set = new TreeSet<String>();
    int n = input.nextInt();
    int sx = input.nextInt(), sy = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        int x = input.nextInt() - sx, y = input.nextInt() - sy;
        int gcd = gcd(Math.abs(x), Math.abs(y));
        if(x < 0)
        {
            x *= -1;
            y *= -1;
        }
        if(x == 0 && y < 0) y *= -1;
        x /= gcd;
        y /= gcd;
        set.add(x+" "+y);
    }
    System.out.println(set.size());
}
static int gcd(int x, int y)
{
    return y == 0 ? x : gcd(y, x%y);
}
}