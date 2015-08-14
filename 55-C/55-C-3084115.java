import java.util.*;
public class m{
public static void main(String[]a)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
    boolean win = false;
    for(int i = 0; i<k; i++)
    {
        int x = input.nextInt(), y = input.nextInt();
        int dx = Math.min(x-1,n-x);
        int dy = Math.min(y-1,m-y);
        win |= Math.min(dx,dy)<=4;
    }
    System.out.println(win?"YES":"NO");
}
}