import java.util.*;
public class B69 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for(int t = 0; t<T; t++)
    {
        int a = input.nextInt(), b = input.nextInt();
        double x = Math.min(b, a/4.0);
        double fail = x * 2 * x + a * (b - x);
        double tot = 2 * (long)a * b;
        double res = 1 - fail/tot;
        if(a == 0) res = .5;
        if(b == 0) res = 1;
        System.out.println(res);
    }
}
}