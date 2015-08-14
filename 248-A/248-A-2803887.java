import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), lo = 0, ro = 0;
        for(int i = 0; i<n; i++)
        {
            if(input.nextInt() == 1) lo ++;
            if(input.nextInt() == 1) ro++;
        }
        System.out.println(Math.min(lo, n - lo) + Math.min(ro, n - ro));
    }
}