import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt(), t = input.nextInt(), a = input.nextInt(), b = input.nextInt(), da = input.nextInt(), db = input.nextInt();
        boolean res = x == 0;
        for(int i = 0; i<t; i++)
            for(int j = 0; j<t; j++)
            {
                res |= a - da*i + b - db*j == x;
                res |= a - da*i == x;
                res |= b - db*j == x;
            }
        System.out.println(res ? "YES":"NO");
    }
}