import java.util.*;
public class bb {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), a = input.nextInt(), b = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        long x = input.nextInt();
        long money = (x*a)/b;
        long left = (x*a) - money*b;
        System.out.print(left/a+" ");
    }
}
}