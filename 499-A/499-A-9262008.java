import java.util.*;
public class aa {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), x = input.nextInt();
    int cur = 0;
    int res = 0;
    for(int i = 0; i<n; i++)
    {
        cur++;
        int y = input.nextInt();
        res += ((y - cur)%x + x)%x;
        cur = input.nextInt();
        res += cur - y + 1;
    }
    System.out.println(res);
}
}