import java.util.*;
public class a
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), d = input.nextInt();
        long[] data = new long[n];
        for(int i = 0; i<n; i++) data[i] = input.nextInt();
        int res = 0;
        for(int i = 1; i<n; i++)
        {
            //System.out.println(data[i] + " " + data[i-1]);
            if(data[i] <= data[i-1])
            {
                int x = (int)Math.ceil((1.0*data[i-1]+1-data[i])/d);
                //System.out.println(x);
                res += x;
                data[i] += x*d;
            }
        }
        System.out.println(res);
    }
}