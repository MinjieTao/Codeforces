import java.util.*;
public class c {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), x = input.nextInt();
    long mod = 1000000007;
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    long sum = 0;
    for(int i =0; i<n; i++) sum += data[i];
    int count = 1;
    long res = 2000000000;
    for(int i =n-2; i>=0; i--)
    {
        if(data[i] == data[i+1]) count++;
        else
        {
            int q = count / x;
            int r = count % x;
            if(r > 0)
            {
                res = data[i+1];
                break;
            }
            boolean found = false;
            int qq = q;
            while(qq > 0)
            {
                if(data[i] == -1 + data[i+1])
                {
                    found = true;
                    count = 1+qq;
                    break;
                }
                if(qq%x != 0)
                {
                    res = data[i+1]-1;
                    break;
                }
                qq /= x;
                data[i+1]--;
            }
            if(res != 2000000000) break;
            if(!found)
            {
                count = 1;
                if(q%x != 0)
                {
                    res = -1+data[i+1];
                    break;
                }
            }
        }
    }
    if(res == 2000000000)
    {
        res = data[0];
        while(count%x == 0)
        {
            res--;
            count = count/x;
        }
    }
    System.out.println(pow(x, Math.min(sum,sum-res)));
}
static long mod = 1000000007;
static long pow(long x, long p)
{
    if(p==0) return 1;
    if((p&1) == 0)
    {
        long sqrt = pow(x, p/2);
        return (sqrt*sqrt)%mod;
    }
    return (x * pow(x, p-1))%mod;
}
}