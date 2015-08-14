import java.util.*;

public class A76 {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt(), m = input.nextInt();
    int a = input.nextInt()-1, b = input.nextInt()-1;
    int above = (m - a%m)%m;
    int below = (b+1)%m;
    if(b == n-1) below = 0;
    //System.out.println(above+" "+below);
    if(a/m == b/m || above + below == 0) System.out.println(1);
    else
    {
        if(b/m == 1+a/m || above == 0 || below == 0 || above + below == m) System.out.println(2);
        else System.out.println(3);
    }
}
}