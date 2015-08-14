import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n], b = new int[n];
        for(int i = 0; i<n; i++)
        {
            a[i] = input.nextInt();
            b[i] = a[i];
        }
        Arrays.sort(b);
        int res = 0;
        int c = 0, d = 0;
        for(int i = 0; i<n; i++)
        {
            if(a[i] == b[n-1])
            {
                c = i;
                res += i;
                break;
            }
        }
        for(int i = n-1; i>=0; i--)
        {
            if(a[i] == b[0])
            {
                d = i;
                res += n-1-i;
                break;
            }
        }
        if(c > d)
            res--;
        System.out.println(res);
    }
}