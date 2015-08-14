import java.util.Arrays;
import java.util.Scanner;
public class b {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    if(n>m)
    {
        int temp = n;
        n = m;
        m = temp;
    }
    int on = n, om = m;
    n--;
    int max = 0;
    int c1 = 0, c2 = 0, turn = 0, last = 0;
    while(true)
    {
        turn++;
        if(n+m==0)break;
        if(turn%2 == 1)
        {
            if(last == 0 && m > 0)
            {
                m--;
                c2++;
                last = 1;
            }
            else if(n>0)
            {
                n--;
                if(last == 1) c2++;
                else c1++;
                last = 0;
            }
            else
            {
                m--;
                c1++;
                last = 1;
            }
        }
        else
        {
            if(last == 0 && n > 0)
            {
                n--;
                c1++;
                last = 0;
            }
            else if(m>0)
            {
                m--;
                if(last == 0) c2++;
                else c1++;
                last = 1;
            }
            else
            {
                n--;
                c2++;
                last = 0;
            }
        }
    }
    max = c1;
    c1 = 0; c2 = 0; last = 1; turn = 0; m = om; n = on; m--;
    //System.out.println(n+" "+m);
    while(true)
    {
        turn++;
        if(n+m==0)break;
        if(turn%2 == 1)
        {
            if(last == 0 && m > 0)
            {
                m--;
                c2++;
                last = 1;
            }
            else if(n>0)
            {
                n--;
                if(last == 1) c2++;
                else c1++;
                last = 0;
            }
            else
            {
                m--;
                c1++;
                last = 1;
            }
        }
        else
        {
            if(last == 0 && n > 0)
            {
                n--;
                c1++;
                last = 0;
            }
            else if(m>0)
            {
                m--;
                if(last == 0) c2++;
                else c1++;
                last = 1;
            }
            else
            {
                n--;
                c2++;
                last = 0;
            }
        }
    }
    max = Math.max(max, c1);
    System.out.println(max+" "+(om+on-max-1));
}
}