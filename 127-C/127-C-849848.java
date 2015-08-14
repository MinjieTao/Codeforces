import java.util.*;
public class c {
    public static int t1, t2, x1, x2, t;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    t1 = input.nextInt();
    t2 = input.nextInt();
    x1 = input.nextInt();
    x2 = input.nextInt();
    t = input.nextInt();
    double closest = t2-t;
    int besty1 = 0, besty2 = x2;
    if(t1==t2)
        besty1 = x1;
    for(int y1 = x1; y1>=0; y1--)
    {
        int low = 0;
        int high = x2;
        int mid = 0;
        while(true)
        {
            mid = (low+high)/2;
            if(high-low<=1)
            {
                if(temp(y1, low) >= t)
                    mid = low;
                else
                    mid = high;
                break;
            }

            if(temp(y1, mid) >= t)
                high = mid;
            else if(temp(y1, mid)==t)
            {
                break;
            }
            else
                low = mid;
        }
        //System.out.println(y1 + " " + mid);
        double d = (temp(y1, mid)-t);
        //System.out.println(d);
        if(d>=0 && d < closest)
        {
            closest = Math.abs(d);
            besty1 = y1;
            besty2 = mid;
        }
        else if(d>=0 && Math.abs(d-closest) < 1E-9 && (y1+mid)>(besty1+besty2))
        {
            closest = Math.abs(d);
            besty1 = y1;
            besty2 = mid;
        }
    }
    int b1 = besty1, b2 = besty2;
    while(besty1 + b1 <= x1 && besty2 + b2 <= x2)
    {
        besty1 += b1;
        besty2 += b2;
    }
//  if(besty1==0)
//      besty2 = x2;
//  else if (besty2==0)
//      besty1 = x1;
    System.out.println(besty1 + " " + besty2);
}
public static double temp(int y1, int y2)
{
    if(y1==0 && y2 == 0)
        return -123456789;
    return 1.0*(1.0*t1*y1+1.0*t2*y2)/(y1+y2);
}
}