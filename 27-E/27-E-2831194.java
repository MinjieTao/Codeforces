import java.util.Arrays;
import java.util.Scanner;
public class c2 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long[] res = new long[1002];
    Arrays.fill(res, (long)1e18);
    res[1] = 1;
    long x = 1;
    for(int a = 1; a< 63; a++)
    {
        x *= 2;
        res[a+1] = Math.min(res[a+1], x);
        long y = 1;
        for(int b = 1; b<=a; b++)
        {
            y *= 3;
            if(y*x > 1e18 || y*x<0)
                break;
            if((a+1)*(b+1) <= 1001)
                res[(a+1)*(b+1)] = Math.min(res[(a+1)*(b+1)], x*y);
            long z = 1;
            for(int c = 1; c<=b; c++)
            {
                z *= 5;
                if(x*y*z > 1e18 || x*y*z < 0)
                    break;
                if((a+1)*(b+1)*(c+1) <= 1001)
                    res[(a+1)*(b+1)*(c+1)] = Math.min(res[(a+1)*(b+1)*(c+1)], x*y*z);
                long w = 1;
                for(int d = 1; d<=c; d++)
                {
                    w *= 7;
                    if(w*x*y*z > 1e18 || w*x*y*z < 0)
                        break;
                    if((a+1)*(b+1)*(c+1)*(d+1) <= 1001)
                        res[(a+1)*(b+1)*(c+1)*(d+1)] = Math.min(res[(a+1)*(b+1)*(c+1)*(d+1)], w*x*y*z);
                    long v = 1;
                    for(int e = 1; e<=d; e++)
                    {
                        v *= 11;
                        if(v*w*x*y*z > 1e18 || v*w*x*y*z < 0)
                            break;
                        if((a+1)*(b+1)*(c+1)*(d+1)*(e+1) <= 1001)
                            res[(a+1)*(b+1)*(c+1)*(d+1)*(e+1)] = Math.min(res[(a+1)*(b+1)*(c+1)*(d+1)*(e+1)], v*w*x*y*z);
                        long vv = 1;
                        for(int f = 1; f<=e; f++)
                        {
                            vv *= 13;
                            if(v*w*x*y*z*vv > 1e18 || v*w*x*y*z*vv < 0)
                                break;
                            if((a+1)*(b+1)*(c+1)*(d+1)*(e+1)*(f+1) <= 1001)
                                res[(a+1)*(b+1)*(c+1)*(d+1)*(e+1)*(f+1)] = Math.min(res[(a+1)*(b+1)*(c+1)*(d+1)*(e+1)*(f+1)], v*w*x*y*z*vv);
                            long vvv = 1;
                            for(int g = 1; g<=f; g++)
                            {
                                vvv *= 17;
                                if(v*w*x*y*z*vv*vvv > 1e18 || v*w*x*y*z*vv*vvv < 0)
                                    break;
                                if((a+1)*(b+1)*(c+1)*(d+1)*(e+1)*(f+1)*(g+1) <= 1001)
                                    res[(a+1)*(b+1)*(c+1)*(d+1)*(e+1)*(f+1)*(g+1)] = Math.min(res[(a+1)*(b+1)*(c+1)*(d+1)*(e+1)*(f+1)*(g+1)], v*w*x*y*z*vv*vvv);
                            }
                        }
                    }
                }
            }
        }
    }

        int n = input.nextInt();
        System.out.println(res[n]);
}
}