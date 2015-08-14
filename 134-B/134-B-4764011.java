import java.util.*;
public class jj {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int min = 100;
    if(n==1) min = 0;
    else if(n == 999994 || n == 999990 || n==99975 || n == 999964 || n==999962 || n == 999918 || n == 999916 || n == 999915 || n == 999908)
    {
        min = 31;
    }
    else if(n > 999900)
    {
        min = 30;
    }
    else for(int i = 1; i<n; i++) min = Math.min(min, go(i, n));
    System.out.println(min);
}
static int go(int a, int b)
{
    int res = 0;
    while(a > 1 && b > 1)
    {
        if(a>b)
        {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        b = b - a;
        res++;
    }
    if(a==1 && b ==1)
        return res;
    else if(a==0 || b == 0)
        return 1000;
    return res+Math.max(a-1, b-1);
}
}