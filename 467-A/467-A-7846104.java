import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int res = 0, n = input.nextInt();
    for(int i = 0; i<n; i++)
    {
        int a = input.nextInt(), b = input.nextInt();
        if(b >= a+2) res++;
    }
    System.out.println(res);
}
}