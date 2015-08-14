import java.util.*;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), v = input.nextInt();
    int[] as = new int[n], bs = new int[n];
    for(int i = 0; i<n; i++)
    {
        as[i] = input.nextInt();
        bs[i] = input.nextInt();
    }
    int res = 0;
    for(int i = 1; i<=3001; i++)
    {
        int left = v;
        for(int j = 0; j<n; j++)
        {
            if(as[j] == i-1)
            {
                int take = Math.min(bs[j], left);
                res += take;
                bs[j] -= take;
                left -= take;
                
            }
        }
        for(int j = 0; j<n; j++)
        {
            if(as[j] == i)
            {
                int take = Math.min(bs[j], left);
                res += take;
                bs[j] -= take;
                left -= take;
                
            }
        }
    }
    System.out.println(res);
}
}