import java.util.*;
import java.io.*;
public class a
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        int[] d1 = new int[20], d2 = new int[20];
        int a = input.nextInt(), b = input.nextInt();
        int i = 19;
        while(a > 0)
        {
            d1[i] = a%3;
            a/=3;
            i--;
        }
        i = 19;
        while(b > 0)
        {
            d2[i] = b%3;
            b/=3;
            i--;
        }
        int[] res = new int[20];
        for(i = 0; i<20; i++)
        {
            res[i] = (d2[i]-d1[i]+3)%3;
        }
        int ans = 0;
        for(i = 19; i>=0; i--)
        {
            if(res[i] == 0)
                continue;
            ans += res[i]*Math.pow(3, 19-i);
        }
        System.out.println(ans);
    }
}