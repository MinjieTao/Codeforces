import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int res = 0;
    while(n >= (res + 1) * (res+2) / 2)
    {
        res++;
        n -= res * (res+1)/2;
    }
    System.out.println(res);
}
}