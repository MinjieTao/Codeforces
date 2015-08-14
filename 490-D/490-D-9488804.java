import java.util.*;
public class d {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    long a1 = input.nextLong(), b1 = input.nextLong(), a2 = input.nextLong(), b2 = input.nextLong();
    long p1 = a1 * b1, p2 = a2 * b2;
    int two1 = 0, two2 = 0, three1 = 0, three2 = 0;
    while(p1%2 == 0)
    {
        p1 /= 2;
        two1++;
    }
    while(p1%3 == 0)
    {
        p1 /= 3;
        three1++;
    }
    while(p2%2 == 0)
    {
        p2 /= 2;
        two2++;
    }
    while(p2%3 == 0)
    {
        p2 /= 3;
        three2++;
    }
    if(p1 != p2) System.out.println("-1");
    else
    {
        int res = 0;
        while(three1 > three2)
        {
            two1++;
            three1--;
            if(a1%3 == 0) a1 = a1/3 * 2;
            else b1 = b1/3 * 2;
            res++;
        }
        while(three2 > three1)
        {
            two2++;
            three2--;
            if(a2%3 == 0) a2 = a2/3 * 2;
            else b2 = b2/3 * 2;
            res++;
        }
        while(two1 > two2)
        {
            two1--;
            res++;
            if(a1%2 == 0) a1 /= 2;
            else b1 /= 2;
        }
        while(two2 > two1)
        {
            two2--;
            res++;
            if(a2%2 == 0) a2 /= 2;
            else b2 /= 2;
        }
        System.out.println(res+"\n"+a1+" "+b1+"\n"+a2+" "+b2);
    }
}
}