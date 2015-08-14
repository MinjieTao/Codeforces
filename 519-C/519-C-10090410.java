import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt();
    int res = 0;
    while(b > a && a > 0 && b > 1)
    {
        a--;
        b -= 2;
        res++;
    }
    while(a > b && b > 0 && a > 1)
    {
        b--;
        a-=2;
        res++;
    }
    res += 2*(Math.min(a, b) / 3);
    int x = Math.min(a, b)/3;
    a -= 3*x;
    b -= 3*x;
    if(a == 2 && b == 2) res++;
    System.out.println(res);
}
}