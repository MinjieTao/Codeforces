import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt(), l = input.nextInt(), c = input.nextInt(), d = input.nextInt(), p = input.nextInt(), nl = input.nextInt(), np = input.nextInt();
        int res = k*l/(n*nl);
        res = Math.min(res, c*d/n);
        res = Math.min(res, p/(n*np));
        System.out.println(res);
    }
}