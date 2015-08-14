import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean[] has = new boolean[n];
        for(int i = 0; i<n; i++)
        {
            int x = input.nextInt();
            if(x<=n)
                has[x-1] = true;
        }
        int count = 0;
        for(int i = 0; i<n; i++)
            if(!has[i])
                count++;
        System.out.println(count);
    }
}