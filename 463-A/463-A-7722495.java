import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), s = input.nextInt();
    int res = -1;
    for(int i = 0; i<n; i++)
    {
        int d = input.nextInt(), c = input.nextInt();
        if(d*100 + c <= s*100)
        {
            int change = 100 - c;
            if(change == 100)
            {
                change = 0;
            }
            res = Math.max(res, change);
        }
    }
    System.out.println(res);
}
}