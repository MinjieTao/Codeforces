import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int y = input.nextInt(), k = input.nextInt(), n = input.nextInt();
    boolean found = false;
    int start= k-y%k;
    for(int x = start; x<=n-y; x+=k)
    {
        int at = x+y;
        if(at%k == 0)
        {
            System.out.print(x + " ");
            found = true;
        }
    }
    if(!found)
        System.out.print(-1);
    System.out.println();
}
}