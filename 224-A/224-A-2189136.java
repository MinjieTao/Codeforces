import java.util.*;
public class a {
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int a = input.nextInt(), b = input.nextInt(), c = input.nextInt();
    for(int i = 1; i<=a; i++)
    {
        if(a%i != 0)
            continue;
        int j = a/i;
        if(b%j != 0)
            continue;
        int k = b/j;
        if(c != k*i)
            continue;
        else
        {
            System.out.println(i*4 + j*4 + k*4);
            break;
        }
    }
}
}