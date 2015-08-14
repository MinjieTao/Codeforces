import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long r = input.nextInt(), x = input.nextInt(), y = input.nextInt(), x2 = input.nextInt(), y2 = input.nextInt();
    double d = Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
    int res = 0;
    while(d > 0)
    {
        d -= 2*r;
        res++;
    }
    System.out.println(res);
}
}